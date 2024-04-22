package ink.on.central.bot;

import ink.ik.tools.exception.normal.IkToolsReflectionException;
import ink.ik.tools.toys.IkToyReflection;
import ink.on.central.bot.annotation.MiraBotListener;
import ink.on.central.bot.entity.event.AnalyzedEvent;
import ink.on.central.bot.exception.MiraBotError;
import ink.on.central.bot.template.ListenerTemplate;
import org.java_websocket.WebSocket;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 事件监听器管理器
 * <p>
 * Create Time: 2024-04-08 Last Update: 2024-04-22
 *
 * @author BGLuminous
 * @since 1.4.0
 */
public class ListenerManager {
  private static final Logger log = LoggerFactory.getLogger(ListenerManager.class);

  /** 事件监听器类位置列表 */
  private final Set<Class<?>> listenerClassSet = new HashSet<>();

  /** 事件监听器和事件ID的映射 */
  @SuppressWarnings("rawtypes")
  private final Map<String, List<ListenerTemplate>> listenerMap = new HashMap<>();

  /**
   * 扫描和检查事件监听器
   *
   * @param clz 启动类
   */
  public static void prepare(Class<?> clz) {
    // 扫描事件监听器
    String rootPackage = clz.getPackageName();
    Holder.INSTANCE.listenerClassSet.addAll(
      new Reflections(rootPackage).getTypesAnnotatedWith(MiraBotListener.class))
    ;
    // 扫描额外的事件监听器
    List<String> extraListenerPackageList = ConfigManager.getConfig().getExtraListenerPackage();
    if (extraListenerPackageList != null && !extraListenerPackageList.isEmpty()) {
      extraListenerPackageList.forEach(
        e -> Holder.INSTANCE.listenerClassSet.addAll(
          new Reflections(e).getTypesAnnotatedWith(MiraBotListener.class)
        )
      );
    }
    // 检查是否存在事件监听器，不存在则退出
    if (Holder.INSTANCE.listenerClassSet.isEmpty()) {
      throw new MiraBotError("没有找到事件监听器! 正在退出///");
    }
  }

  /**
   * 注册事件监听器
   *
   * @param botInstance Bot 连接实例
   */
  @SuppressWarnings("rawtypes")
  public static void registerListener(BotInstance botInstance) {
    Holder.INSTANCE.listenerClassSet.forEach(e -> {
      // 尝试构建事件监听器
      try {
        ListenerTemplate listener =
          (ListenerTemplate) new IkToyReflection<>(e)
            .findConstructor(BotInstance.class).newInstance(botInstance);
        String registerEventTarget = listener.getEventId();
        compareAndInject(registerEventTarget, listener);
      } catch (IkToolsReflectionException ex) {
        if (ConfigManager.getConfig().getStrict() == Boolean.TRUE) {
          throw new MiraBotError(
            "初始化监听器 %s 出错! 已启用严格模式, 正在退出/// 错误信息:%s"
              .formatted(e.getSimpleName(), ex.getMessage())
          );
        }
        log.warn("初始化监听器 {} 错误，正在跳过... 错误信息:{}", e.getSimpleName(), ex.getMessage());
      }
    });
  }

  /**
   * 比较并注入事件监听器
   *
   * @param eventId           事件ID
   * @param listenerInstance 事件监听器
   */
  @SuppressWarnings("rawtypes")
  public static void compareAndInject(String eventId, ListenerTemplate listenerInstance) {
    List<ListenerTemplate> listenerList = Holder.INSTANCE.listenerMap.get(eventId);
    if (listenerList == null) {
      List<ListenerTemplate> newListenerList = new ArrayList<>();
      newListenerList.add(listenerInstance);
      Holder.INSTANCE.listenerMap.put(eventId, newListenerList);
      return;
    }
    listenerList.add(listenerInstance);
  }

  /**
   * 通过eventId获取事件监听器并执行处理方法
   *
   * @param event        解析后的事件数据
   * @param receivedTime 事件接收时间
   * @param currentConn  当前连接
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static void pushEvent(AnalyzedEvent event, Long receivedTime, WebSocket currentConn) {
    List<ListenerTemplate> listenerList = Holder.INSTANCE.listenerMap.get(event.getEventId());
    if (listenerList == null || listenerList.isEmpty()) {
      log.warn("接收到 {} 事件但是没有可用的监听器!", event.getEventId());
      return;
    }
    listenerList.forEach(
      e -> ThreadPoolManger.push(() -> e.entrace(event.getData(), receivedTime, currentConn))
    );
  }

  /** 内部类 */
  private static class Holder {
    private static final ListenerManager INSTANCE = new ListenerManager();
  }

}

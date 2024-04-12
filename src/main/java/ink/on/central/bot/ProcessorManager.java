package ink.on.central.bot;

import ink.ik.tools.exception.normal.IkToolsReflectionException;
import ink.ik.tools.toys.IkToyReflection;
import ink.on.central.bot.annotation.MiraBotProcessor;
import ink.on.central.bot.entity.event.AnalyzedEvent;
import ink.on.central.bot.exception.MiraBotError;
import ink.on.central.bot.template.ProcessorTemplate;
import org.java_websocket.WebSocket;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 事件处理器管理器
 * <p>
 * Create Time: 2024-04-08 Last Update: 2024-04-12
 *
 * @author BGLuminous
 * @since 1.0.0
 */
public class ProcessorManager {
  private static final Logger log = LoggerFactory.getLogger(ProcessorManager.class);

  /** 事件处理器类位置列表 */
  private final Set<Class<?>> processorClassSet = new HashSet<>();

  /** 事件处理器和事件ID的映射 */
  @SuppressWarnings("rawtypes")
  private final Map<String, List<ProcessorTemplate>> processorMap = new HashMap<>();

  /**
   * 扫描和检查事件处理器
   *
   * @param clz 启动类
   */
  public static void prepare(Class<?> clz) {
    // 扫描事件处理器
    String rootPackage = clz.getPackageName();
    Holder.INSTANCE.processorClassSet.addAll(
      new Reflections(rootPackage).getTypesAnnotatedWith(MiraBotProcessor.class))
    ;
    // 扫描额外的事件处理器
    List<String> extraProcessorPackageList = ConfigManager.getConfig().getExtraProcessorPackage();
    if (extraProcessorPackageList != null && !extraProcessorPackageList.isEmpty()) {
      extraProcessorPackageList.forEach(
        e -> Holder.INSTANCE.processorClassSet.addAll(
          new Reflections(e).getTypesAnnotatedWith(MiraBotProcessor.class)
        )
      );
    }
    // 检查是否存在事件处理器，不存在则退出
    if (Holder.INSTANCE.processorClassSet.isEmpty()) {
      throw new MiraBotError("没有找到事件处理器! 正在退出///");
    }
  }

  /**
   * 注册事件处理器
   *
   * @param botInstance Bot 连接实例
   */
  @SuppressWarnings("rawtypes")
  public static void registerProcessor(BotInstance botInstance) {
    Holder.INSTANCE.processorClassSet.forEach(e -> {
      // 尝试构建事件处理器
      try {
        ProcessorTemplate processor =
          (ProcessorTemplate) new IkToyReflection<>(e)
            .findConstructor(BotInstance.class)
            .newInstance(botInstance);
        String registerEventTarget = processor.getEventId();
        compareAndInject(registerEventTarget, processor);
      } catch (IkToolsReflectionException ex) {
        if (ConfigManager.getConfig().getStrict() == Boolean.TRUE) {
          throw new MiraBotError(
            "初始化处理器 %s 出错! 已启用严格模式, 正在退出/// 错误信息:%s"
              .formatted(e.getSimpleName(), ex.getMessage())
          );
        }
        log.warn("初始化处理器 {} 错误，正在跳过... 错误信息:{}", e.getSimpleName(), ex.getMessage());
      }
    });
  }

  /**
   * 比较并注入事件处理器
   *
   * @param eventId           事件ID
   * @param processorInstance 事件处理器
   */
  @SuppressWarnings("rawtypes")
  public static void compareAndInject(String eventId, ProcessorTemplate processorInstance) {
    List<ProcessorTemplate> processorList = Holder.INSTANCE.processorMap.get(eventId);
    if (processorList == null) {
      List<ProcessorTemplate> newProcessorList = new ArrayList<>();
      newProcessorList.add(processorInstance);
      Holder.INSTANCE.processorMap.put(eventId, newProcessorList);
      return;
    }
    processorList.add(processorInstance);
  }

  /**
   * 通过eventId获取事件处理器并执行处理方法
   *
   * @param event        解析后的事件数据
   * @param receivedTime 事件接收时间
   * @param currentConn  当前连接
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static void pushEvent(AnalyzedEvent event, Long receivedTime, WebSocket currentConn) {
    List<ProcessorTemplate> processorList = Holder.INSTANCE.processorMap.get(event.getEventId());
    if (processorList == null || processorList.isEmpty()) {
      log.warn("接收到 {} 事件但是没有可用的处理器!", event.getEventId());
      return;
    }
    processorList.forEach(
      e -> ThreadPoolManger.push(() -> e.entrace(event.getData(), receivedTime, currentConn))
    );
  }

  /** 内部类 */
  private static class Holder {
    private static final ProcessorManager INSTANCE = new ProcessorManager();
  }

}

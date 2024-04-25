package ink.on.central.bot;

import ink.on.central.bot.entity.ResponseManageWrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * API调用返回管理器
 * <p>
 * Create Time: 2024-04-12 Last Update: 2024-04-25
 *
 * @author BGLuminous
 * @since 1.2.0
 */
@SuppressWarnings("unused")
public class ResponseManager {
  private static final Logger log = LoggerFactory.getLogger(ResponseManager.class);

  /** 缓存API返回事件 */
  private final Map<String, ResponseManageWrap> resposeBufMap = new HashMap<>();

  private Thread cleanThread;

  /** 初始化 */
  @SuppressWarnings("all")
  public static void prepare() {
    // 新建一个线程专门用于删除过期没有使用的返回事件
    Holder.INSTANCE.cleanThread = new Thread(() -> {
      log.info("API调用返回管理器垃圾回收开始工作~");
      while (true) {
        try {
          Thread.sleep(ConfigManager.getConfig().getResCleanTime() * 1000L);
        } catch (Exception ex) {
          log.error(
            "垃圾回收线程睡眠过程发生错误! 错误信息:{} (如果是断开连接导致的错误请忽略, 垃圾回收线程会自动重启)",
            ex.getMessage()
          );
          return;
        }
        Iterator<String> keyIterator = Holder.INSTANCE.resposeBufMap.keySet().iterator();
        while (keyIterator.hasNext()) {
          String key = keyIterator.next();
          ResponseManageWrap responseManageWrap = Holder.INSTANCE.resposeBufMap.get(key);
          if (responseManageWrap.expire()) {
            log.debug("删除过期的API返回事件 ID:{} 数据:{}", key, responseManageWrap.getData());
            keyIterator.remove();
          }
        }
      }
    });
    ThreadPoolManger.push(Holder.INSTANCE.cleanThread);
  }

  public static void shutdown() {
    Holder.INSTANCE.cleanThread.interrupt();
  }

  /**
   * 获取异步API返回事件
   *
   * @param requestId 请求ID
   * @param timeout   超时时间
   *
   * @return 返回数据
   */
  @SuppressWarnings("all")
  public static String asyncGetResponse(String requestId, Long timeout) {
    long endTime = System.currentTimeMillis() + timeout;
    while (System.currentTimeMillis() < endTime) {
      if (Holder.INSTANCE.resposeBufMap.containsKey(requestId)) {
        String dataJson = Holder.INSTANCE.resposeBufMap.get(requestId).getData().toString();
        Holder.INSTANCE.resposeBufMap.remove(requestId);
        return dataJson;
      }
      try {
        Thread.sleep(500L);
      } catch (Exception ex) {
        log.error("线程睡眠过程发生错误! 错误信息:{}", ex.getMessage());
        Thread.currentThread().interrupt();
        return null;
      }
    }
    log.warn("未找到请求 {} 的返回数据, 可以尝试增加接收时间或者检查代码逻辑错误!", requestId);
    return null;
  }

  /**
   * 获取异步API返回事件
   *
   * @param responseId 请求ID
   * @param timeout    超时时间
   *
   * @return 返回数据
   */
  public static String asyncGetResponse(Long responseId, Long timeout) {
    return asyncGetResponse(String.valueOf(responseId), timeout);
  }

  /**
   * 获取异步API返回事件
   *
   * @param requestId 请求ID
   *
   * @return 返回数据
   */
  public static String asyncGetResponse(String requestId) {
    return asyncGetResponse(requestId, 10 * 1000L);
  }

  /**
   * 获取异步API返回事件
   *
   * @param responseId 请求ID
   *
   * @return 返回数据
   */
  public static String asyncGetResponse(Long responseId) {
    return asyncGetResponse(String.valueOf(responseId));
  }

  /**
   * 添加异步API返回事件
   *
   * @param responseId 请求ID
   * @param response   返回数据
   */
  public static void pushResponse(String responseId, Object response) {
    Holder.INSTANCE.resposeBufMap.put(
      responseId,
      new ResponseManageWrap().setData(response).setTrackTime(System.currentTimeMillis())
    );
  }

  /** 静态内部类 */
  private static class Holder {
    private static final ResponseManager INSTANCE = new ResponseManager();
  }
}

package ink.on.central.bot.template;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.exception.MiraBotRuntimeException;
import ink.on.central.bot.utils.SenderUtil;
import lombok.Getter;
import org.java_websocket.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 事件处理器模板
 * <p>
 * Create Time: 2024-04-07 Last Update:
 *
 * @param <T> 事件信息实体类
 *
 * @author BGLuminous
 * @since 1.0.0
 */
public class ProcessorTemplate<T> {
  private final Logger log;

  /** 事件ID = post_type + 对应的子类型 */
  @Getter
  private final String eventId;
  /** 机器人实例 */
  protected final BotInstance instance;

  /** 发送工具类 */
  protected SenderUtil sender;

  /**
   * 构造方法
   *
   * @param instance      机器人实例
   * @param targetEvent   作用事件类型
   * @param targetSubType 作用事件子类型
   */
  public ProcessorTemplate(
    BotInstance instance, String targetEvent, String targetSubType
  ) {
    this.instance = instance;
    this.eventId = targetEvent + targetSubType;
    log = LoggerFactory.getLogger(this.getClass().getSimpleName());
  }

  /**
   * 主处理逻辑
   *
   * @param data         事件数据
   * @param receivedTime 事件接收时间
   * @param currentConn
   */
  @SuppressWarnings("all")
  public void entrace(T data, Long receivedTime, WebSocket currentConn) {
    sender = new SenderUtil(currentConn);
    try {
      process(data, receivedTime);
    } catch (Exception ex) {
      errorHandler(ex);
    }
  }

  @SuppressWarnings("all")
  public void process(T data, Long receivedTime) throws Exception {
    throw new MiraBotRuntimeException("请重写 process() 方法或者删除该处理器!");
  }

  private void errorHandler(Exception ex) {
    log.error(ex.getMessage(), ex);
  }

}

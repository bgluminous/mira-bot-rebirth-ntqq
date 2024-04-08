package ink.on.central.bot.template;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.exception.MiraBotRuntimeException;
import ink.on.central.bot.utils.SenderUtil;
import lombok.Getter;

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

  /** 机器人实例 */
  protected final BotInstance instance;
  /** 发送工具类 */
  protected final SenderUtil sender;

  /** 事件ID = post_type + 对应的子类型 */
  @Getter
  private final String eventId;

  /**
   * 构造方法
   *
   * @param instance      机器人实例
   * @param sender        发送工具类
   * @param targetEvent   作用事件类型
   * @param targetSubType 作用事件子类型
   */
  public ProcessorTemplate(
    BotInstance instance, SenderUtil sender, String targetEvent, String targetSubType
  ) {
    this.instance = instance;
    this.sender = sender;
    this.eventId = targetEvent + targetSubType;
  }

  /**
   * 主处理逻辑
   *
   * @param data         事件数据
   * @param receivedTime 事件接收时间
   */
  @SuppressWarnings("all")
  public void process(T data, Long receivedTime) {
    throw new MiraBotRuntimeException("请重写 process() 方法或者删除该处理器!");
  }

}

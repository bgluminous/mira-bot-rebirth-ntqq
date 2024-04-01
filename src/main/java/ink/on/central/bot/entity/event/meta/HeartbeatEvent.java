package ink.on.central.bot.entity.event.meta;

import ink.on.central.bot.entity.event.meta.pojo.HeartbeatStatePojo;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 心跳检查事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/meta.md#%E5%BF%83%E8%B7%B3">查看文档</a>
 * <br>
 * Create Time: 2024-03-29 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class HeartbeatEvent {
  /** 上报类型 */
  private String postType;
  /** 元事件类型 */
  private String metaEventType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 到下次心跳的间隔，单位毫秒 */
  private Long interval;
  /** 状态信息 */
  private HeartbeatStatePojo status;
}


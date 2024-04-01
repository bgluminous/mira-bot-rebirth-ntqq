package ink.on.central.bot.entity.event.meta;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 生命周期事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/meta.md#%E7%94%9F%E5%91%BD%E5%91%A8%E6%9C%9F">查看文档</a>
 * <br>
 * Create Time: 2024-03-29 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class LifecycleEvent {
  /** 上报类型 */
  private String postType;
  /** 元事件类型 */
  private String metaEventType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 事件子类型，分别表示 OneBot 启用、停用、WebSocket 连接成功 */
  private String subType;
}

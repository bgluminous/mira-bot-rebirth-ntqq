package ink.on.central.bot.entity.event.notice;

import ink.on.central.bot.entity.event.EventTypes;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群消息撤回事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E5%A5%BD%E5%8F%8B%E6%B6%88%E6%81%AF%E6%92%A4%E5%9B%9E">查看文档</a>
 * <br>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class FriendMessageRecallEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private EventTypes.NoticeTypes noticeType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 加入者 QQ 号 */
  private Long userId;
  /** 被撤回的消息 ID */
  private Long messageId;
}

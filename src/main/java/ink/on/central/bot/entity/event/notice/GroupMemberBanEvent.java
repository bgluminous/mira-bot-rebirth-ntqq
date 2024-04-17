package ink.on.central.bot.entity.event.notice;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群禁言事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E7%A6%81%E8%A8%80">查看文档</a>
 * <br>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupMemberBanEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private String noticeType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 事件子类型，分别表示禁言、解除禁言 */
  private String subType;
  /** 群号 */
  private Long groupId;
  /** 操作者 QQ 号（如果是主动退群，则和 user_id 相同） */
  private Long operatorId;
  /** 被禁言 QQ 号 */
  private Long userId;
  /** 禁言时长，单位秒 */
  private Long duration;
}

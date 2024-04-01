package ink.on.central.bot.entity.event.notice;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群成员减少事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E6%88%90%E5%91%98%E5%87%8F%E5%B0%91">查看文档</a>
 * <br>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupMemberDecreaseEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private String noticeType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 事件子类型，分别表示主动退群、成员被踢、登录号被踢 */
  private String subTypes;
  /** 群号 */
  private Long groupId;
  /** 操作者 QQ 号（如果是主动退群，则和 user_id 相同） */
  private Long operatorId;
  /** 离开者 QQ 号 */
  private Long userId;
}

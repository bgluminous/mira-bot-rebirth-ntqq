package ink.on.central.bot.entity.event.notice;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群成员增加事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E6%88%90%E5%91%98%E5%A2%9E%E5%8A%A0">查看文档</a>
 * <br>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupMemberIncreaseEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private String noticeType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;


  /** 事件子类型，分别表示管理员已同意入群、管理员邀请入群 */
  private String subTypes;
  /** 群号 */
  private Long groupId;
  /** 操作者 QQ 号（如果是主动退群，则和 user_id 相同） */
  private Long operatorId;
  /** 加入者 QQ 号 */
  private Long userId;
}

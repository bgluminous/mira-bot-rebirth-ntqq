package ink.on.central.bot.entity.event.notice;

import ink.on.central.bot.entity.event.EventTypes;
import ink.on.central.bot.entity.event.notice.types.GroupMemberHonorTypes;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群成员荣誉变更事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E6%88%90%E5%91%98%E8%8D%A3%E8%AA%89%E5%8F%98%E6%9B%B4">查看文档</a>
 * <br>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupMemberHonorChangedEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private EventTypes.NoticeTypes noticeType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 提示类型 ,目前只有 honor */
  private String subType;
  /** 群号 */
  private Long groupId;
  /** 荣誉类型，分别表示龙王、群聊之火、快乐源泉 */
  private GroupMemberHonorTypes honorType;
  /** 成员 QQ 号 */
  private Long userId;
}

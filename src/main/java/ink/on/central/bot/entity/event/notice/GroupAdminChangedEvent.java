package ink.on.central.bot.entity.event.notice;

import ink.on.central.bot.entity.event.EventTypes;
import ink.on.central.bot.entity.event.notice.types.GroupAdminChangedSubTypes;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群管理员变动事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E7%AE%A1%E7%90%86%E5%91%98%E5%8F%98%E5%8A%A8">查看文档</a>
 * <br>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupAdminChangedEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private EventTypes.NoticeTypes noticeType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 事件子类型，分别表示设置和取消管理员 */
  private GroupAdminChangedSubTypes subTypes;
  /** 群号 */
  private Long groupId;
  /** 管理员 QQ 号 */
  private Long userId;
}

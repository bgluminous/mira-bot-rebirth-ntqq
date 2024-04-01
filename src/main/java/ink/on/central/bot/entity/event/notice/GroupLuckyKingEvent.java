package ink.on.central.bot.entity.event.notice;

import ink.on.central.bot.entity.event.EventTypes;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群红包运气王事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E7%BA%A2%E5%8C%85%E8%BF%90%E6%B0%94%E7%8E%8B">查看文档</a>
 * <br>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupLuckyKingEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private EventTypes.NoticeTypes noticeType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 提示类型 ,目前只有 lucky_king */
  private String subType;
  /** 群号 */
  private Long groupId;
  /** 发送者 QQ 号 */
  private Long userId;
  /** 运气王 QQ 号 */
  private Long targetId;
}

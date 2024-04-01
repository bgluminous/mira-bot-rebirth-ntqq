package ink.on.central.bot.entity.event.notice;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群内戳一戳事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E5%86%85%E6%88%B3%E4%B8%80%E6%88%B3">查看文档</a>
 * <br>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupNotifyEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private String noticeType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 提示类型 ,目前只有 poke */
  private String subType;
  /** 群号 */
  private Long groupId;
  /** 发送者 QQ 号 */
  private Long userId;
  /** 被戳者 QQ 号 */
  private Long targetId;
  /** 荣誉类型，分别表示龙王、群聊之火、快乐源泉 */
  private String honorType;
}

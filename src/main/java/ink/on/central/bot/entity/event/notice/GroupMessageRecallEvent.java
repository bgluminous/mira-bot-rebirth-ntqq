package ink.on.central.bot.entity.event.notice;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群消息撤回事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E6%B6%88%E6%81%AF%E6%92%A4%E5%9B%9E">查看文档</a>
 * <br>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupMessageRecallEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private String noticeType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 群号 */
  private Long groupId;
  /** 消息发送者 QQ 号 */
  private Long userId;
  /** 操作者 QQ 号 */
  private Long operatorId;
  /** 被撤回的消息 ID */
  private Long messageId;
}

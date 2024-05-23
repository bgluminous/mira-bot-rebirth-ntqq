package ink.on.central.bot.entity.event.notice;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class GroupCardChangedEvent {
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
  /** 管理员 QQ 号 */
  private Long userId;

  /** 旧名片 */
  private String cardOld;
  /** 新名片 */
  private String cardNew;
}

package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群组单人禁言载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#set_group_kick-%E7%BE%A4%E7%BB%84%E8%B8%A2%E4%BA%BA">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGroupBan {
  /** 要踢成员的 QQ 号 */
  private Long userId;
  /** 群号 */
  private Long groupId;
  /** 禁言时长，单位秒，0 表示取消禁言 */
  private Integer duration;
}

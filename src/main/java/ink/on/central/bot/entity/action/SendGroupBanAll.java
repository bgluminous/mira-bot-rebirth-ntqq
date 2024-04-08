package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群组全员禁言载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#set_group_whole_ban-%E7%BE%A4%E7%BB%84%E5%85%A8%E5%91%98%E7%A6%81%E8%A8%80">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGroupBanAll {
  /** 群号 */
  private Long groupId;
  /** 是否禁言 */
  private Boolean enable;
}

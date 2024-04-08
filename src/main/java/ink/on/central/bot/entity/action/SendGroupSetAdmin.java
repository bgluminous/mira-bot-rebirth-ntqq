package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群组设置管理员载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#set_group_admin-%E7%BE%A4%E7%BB%84%E8%AE%BE%E7%BD%AE%E7%AE%A1%E7%90%86%E5%91%98">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGroupSetAdmin {
  /** 要设置管理员的 QQ 号 */
  private Long userId;
  /** 群号 */
  private Long groupId;
  /** true 为设置，false 为取消 */
  private Boolean enable;
}

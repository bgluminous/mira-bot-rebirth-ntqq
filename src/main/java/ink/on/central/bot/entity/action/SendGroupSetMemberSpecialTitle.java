package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 设置群组专属头衔载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#set_group_special_title-%E8%AE%BE%E7%BD%AE%E7%BE%A4%E7%BB%84%E4%B8%93%E5%B1%9E%E5%A4%B4%E8%A1%94">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGroupSetMemberSpecialTitle {
  /** 要设置的 QQ 号 */
  private Long userId;
  /** 群号 */
  private Long groupId;
  /** 专属头衔，不填或空字符串表示删除专属头衔 */
  private String specialTitle;
}

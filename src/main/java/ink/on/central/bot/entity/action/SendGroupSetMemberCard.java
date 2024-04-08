package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 设置群名片（群备注）载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#set_group_card-%E8%AE%BE%E7%BD%AE%E7%BE%A4%E5%90%8D%E7%89%87%E7%BE%A4%E5%A4%87%E6%B3%A8">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGroupSetMemberCard {
  /** 要设置的 QQ 号 */
  private Long userId;
  /** 群号 */
  private Long groupId;
  /** 群名片内容，不填或空字符串表示删除群名片 */
  private String card;
}

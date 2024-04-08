package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 设置群名载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#set_group_name-%E8%AE%BE%E7%BD%AE%E7%BE%A4%E5%90%8D">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGroupSetName {
  /** 群号 */
  private Long groupId;
  /** 新群名 */
  private String groupName;
}

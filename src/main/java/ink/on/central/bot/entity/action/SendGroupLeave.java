package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 退出群组载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#set_group_leave-%E9%80%80%E5%87%BA%E7%BE%A4%E7%BB%84">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGroupLeave {
  /** 群号 */
  private Long groupId;
  /** 是否解散，如果登录号是群主，则仅在此项为 true 时能够解散 */
  private String isDismiss;
}

package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群组开启匿名载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#set_group_anonymous-%E7%BE%A4%E7%BB%84%E5%8C%BF%E5%90%8D">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGroupSetEnableAnonymous {
  /** 群号 */
  private Long groupId;
  /** 是否允许匿名聊天 */
  private Boolean enable;
}

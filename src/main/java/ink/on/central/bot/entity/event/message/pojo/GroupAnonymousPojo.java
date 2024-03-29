package ink.on.central.bot.entity.event.message.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群消息匿名发送者 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/message.md#%E7%BE%A4%E6%B6%88%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-03-29 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupAnonymousPojo {
  /** 匿名用户 ID */
  private Long id;
  /** 匿名用户名称 */
  private String name;
  /** 匿名用户 flag，在调用禁言 API 时需要传入 */
  private String flag;
}

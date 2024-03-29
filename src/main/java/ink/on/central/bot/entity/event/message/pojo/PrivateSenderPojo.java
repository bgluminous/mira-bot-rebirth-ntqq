package ink.on.central.bot.entity.event.message.pojo;

import ink.on.central.bot.entity.event.message.types.SexTypes;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 私信发送者 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/message.md#%E7%A7%81%E8%81%8A%E6%B6%88%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-03-29 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class PrivateSenderPojo {
  /** 发送者 QQ 号 */
  private Long userId;
  /** 昵称 */
  private String nickname;
  /** 性别，male 或 female 或 unknown */
  private SexTypes sex;
  /** 年龄 */
  private String age;
}

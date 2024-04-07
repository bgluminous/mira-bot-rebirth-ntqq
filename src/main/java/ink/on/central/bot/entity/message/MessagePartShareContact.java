package ink.on.central.bot.entity.message;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class MessagePartShareContact {
  /** 联系人类型 qq / group */
  private String type;
  /** id qq号 / 群号 */
  private String id;
}

package ink.on.central.bot.entity.message;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class MessagePartShareLocation {
  /** 纬度 */
  private String lat;
  /** 经度 */
  private String lon;
  /** 位置名称 */
  private String title;
  /** 位置描述 */
  private String content;
}

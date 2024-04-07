package ink.on.central.bot.entity.message;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class MessagePartShareLink {
  /** 标题 */
  private String title;
  /** URL */
  private String url;
  /** 发送时可选，内容描述 */
  private String content;
  /** 封面 */
  private String image;
}

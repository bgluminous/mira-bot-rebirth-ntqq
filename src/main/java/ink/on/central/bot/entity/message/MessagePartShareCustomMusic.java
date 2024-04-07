package ink.on.central.bot.entity.message;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class MessagePartShareCustomMusic {
  /** 表示音乐自定义分享 */
  private String type;
  /** 点击后跳转目标 URL */
  private String url;
  /** 音乐 URL */
  private String audio;
  /** 标题 */
  private String title;
  /** 发送时可选，内容描述 */
  private String content;
  /** 发送时可选，图片 URL */
  private String image;
}

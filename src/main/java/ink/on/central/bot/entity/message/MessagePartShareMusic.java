package ink.on.central.bot.entity.message;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors
@Data
public class MessagePartShareMusic {
  /** qq 163 xm 分别表示使用 QQ 音乐、网易云音乐、虾米音乐 */
  private String type;
  /** 歌曲 ID */
  private String id;
}

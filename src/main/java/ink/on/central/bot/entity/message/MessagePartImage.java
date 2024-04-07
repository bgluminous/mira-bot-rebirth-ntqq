package ink.on.central.bot.entity.message;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class MessagePartImage {
  /** 图片文件名 */
  private String file;
  /** 图片类型，flash 表示闪照，无此参数表示普通图片 */
  private String type;
  /** 图片 URL */
  private String url;
  /** 只在通过网络 URL 发送时有效，表示是否使用已缓存的文件，默认 1 */
  private Integer cache;
  /** 只在通过网络 URL 发送时有效，表示是否通过代理下载文件（需通过环境变量或配置文件配置代理），默认 1 */
  private Integer proxy;
  /** 只在通过网络 URL 发送时有效，单位秒，表示下载网络文件的超时时间，默认不超时 */
  private Integer timeout;
}

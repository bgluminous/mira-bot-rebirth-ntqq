package ink.on.central.bot.entity.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 获取版本信息返回实体
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#get_version_info-%E8%8E%B7%E5%8F%96%E7%89%88%E6%9C%AC%E4%BF%A1%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class ResponseGetVersionInfo {
  /** 应用标识 */
  private String appName;
  /** 应用版本 */
  private String appVersion;
  /** OneBot 标准版本 */
  private String protocolVersion;
}

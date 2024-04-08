package ink.on.central.bot.entity.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 获取 QQ 相关接口凭证返回实体
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#get_credentials-%E8%8E%B7%E5%8F%96-qq-%E7%9B%B8%E5%85%B3%E6%8E%A5%E5%8F%A3%E5%87%AD%E8%AF%81">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class ResponseGetCredentials {
  /** Cookies */
  private String cookies;
  /** CSRF Token */
  private Integer csrfToken;
}

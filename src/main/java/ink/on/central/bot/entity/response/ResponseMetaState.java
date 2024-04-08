package ink.on.central.bot.entity.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 检查是否可以发送 图片 / 语音 返回实体
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#can_send_image-%E6%A3%80%E6%9F%A5%E6%98%AF%E5%90%A6%E5%8F%AF%E4%BB%A5%E5%8F%91%E9%80%81%E5%9B%BE%E7%89%87">查看文档</a>
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#can_send_record-%E6%A3%80%E6%9F%A5%E6%98%AF%E5%90%A6%E5%8F%AF%E4%BB%A5%E5%8F%91%E9%80%81%E8%AF%AD%E9%9F%B3">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class ResponseMetaState {
  /** 是或否 */
  private Boolean yes;
}

package ink.on.central.bot.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Socket通信 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/communication/ws.md">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendSocketWrap {
  /** 用于指定要调用的 API */
  private String action;
  /** 用于传入参数 */
  private Object params;
  /** 用于唯一标识一次请求 */
  private String echo;
}

package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 发送群消息载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#send_group_msg-%E5%8F%91%E9%80%81%E7%BE%A4%E6%B6%88%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGroupMessage {
  /** 群号 */
  private Long groupId;
  /** 要发送的内容 */
  private List<?> message;
  /** 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效 */
  private Boolean autoEscape;
}

package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 发送消息载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#send_private_msg-%E5%8F%91%E9%80%81%E7%A7%81%E8%81%8A%E6%B6%88%E6%81%AF">查看文档</a>
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
public class SendMessage {
  /** 消息类型，支持 private、group，分别对应私聊、群组，如不传入，则根据传入的 *_id 参数判断 */
  private String messageType;
  /** 对方 QQ 号（消息类型为 private 时需要） */
  private Long userId;
  /** 群号（消息类型为 group 时需要） */
  private Long groupId;
  /** 要发送的内容 */
  private Object message;
  /** 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效 */
  private Boolean autoEscape;
}

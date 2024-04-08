package ink.on.central.bot.entity.event.message;

import ink.on.central.bot.entity.event.message.pojo.SenderPojo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * 私信 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/message.md#%E7%A7%81%E8%81%8A%E6%B6%88%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-03-29 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class PrivateMessageEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private String messageType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 消息子类型，如果是好友则是 friend，如果是群临时会话则是 group */
  private String subType;
  /** 消息格式 (文档中没有说明) */
  private String messageFormat;
  /** 消息 ID */
  private Integer messageId;
  /** 未知属性 (文档中没有说明) */
  private Long realId;
  /** 发送者 QQ 号 */
  private Long userId;
  /** 消息内容 */
  private List<Map<String, Object>> message;
  /** 原始消息内容 */
  private String rawMessage;
  /** 字体 */
  private Integer font;
  /** 发送人信息 */
  private SenderPojo sender;
}

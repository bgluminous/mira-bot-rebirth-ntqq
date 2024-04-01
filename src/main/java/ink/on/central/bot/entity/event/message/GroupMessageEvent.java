package ink.on.central.bot.entity.event.message;

import ink.on.central.bot.entity.event.message.pojo.GroupAnonymousPojo;
import ink.on.central.bot.entity.event.message.pojo.GroupSenderPojo;
import ink.on.central.bot.entity.event.message.types.GroupMessageSubTypes;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群消息 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/message.md#%E7%BE%A4%E6%B6%88%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-03-29 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupMessageEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private String messageType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;
  /** 消息子类型，正常消息是 normal，匿名消息是 anonymous，系统提示（如「管理员已禁止群内匿名聊天」）是 notice */
  private GroupMessageSubTypes subType;
  /** 消息 ID */
  private Integer messageId;
  /** 群号 */
  private Long groupId;
  /** 发送者 QQ 号 */
  private Long userId;
  /** 匿名发送人信息，如果不是匿名消息则为 null */
  private GroupAnonymousPojo anonymous;
  /** 消息内容 TODO: 待解析 */
  private Object message;
  /** 原始消息内容 */
  private String rawMessage;
  /** 字体 */
  private Integer font;
  /** 发送人信息 */
  private GroupSenderPojo sender;
}

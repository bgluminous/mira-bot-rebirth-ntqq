package ink.on.central.bot.entity.event.request;

import ink.on.central.bot.entity.event.EventTypes;
import ink.on.central.bot.entity.event.request.types.GroupJoinRequestSubTypes;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群邀请事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/request.md#%E5%8A%A0%E7%BE%A4%E8%AF%B7%E6%B1%82%E9%82%80%E8%AF%B7">查看文档</a>
 * <br>
 * Create Time: 2024-03-29 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupJoinRequestEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private EventTypes.RequestTypes requestType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 请求子类型，分别表示加群请求、邀请登录号入群 */
  private GroupJoinRequestSubTypes subType;
  /** 群号 */
  private Long groupId;
  /** 发送请求的 QQ 号 */
  private Long userId;
  /** 验证信息 */
  private String comment;
  /** 请求 flag，在调用处理请求的 API 时需要传入 */
  private String flag;
}

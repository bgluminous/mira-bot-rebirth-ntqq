package ink.on.central.bot.entity.event.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 好友请求事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/request.md#%E5%8A%A0%E5%A5%BD%E5%8F%8B%E8%AF%B7%E6%B1%82">查看文档</a>
 * <br>
 * Create Time: 2024-03-29 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class FriendJoinRequestEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private String requestType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 发送请求的 QQ 号 */
  private Long userId;
  /** 验证信息 */
  private String comment;
  /** 请求 flag，在调用处理请求的 API 时需要传入 */
  private String flag;
}

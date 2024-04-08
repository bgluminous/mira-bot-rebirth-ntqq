package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 处理加好友请求载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#set_friend_add_request-%E5%A4%84%E7%90%86%E5%8A%A0%E5%A5%BD%E5%8F%8B%E8%AF%B7%E6%B1%82">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendFriendAddResponse {
  /** 加好友请求的 flag（需从上报的数据中获得） */
  private String flag;
  /** 是否同意请求 */
  private Boolean approve;
  /** 添加后的好友备注（仅在同意时有效） */
  private String remark;
}

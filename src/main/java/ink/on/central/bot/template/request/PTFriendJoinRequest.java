package ink.on.central.bot.template.request;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.request.FriendJoinRequestEvent;
import ink.on.central.bot.template.ProcessorTemplate;


/**
 * 好友请求事件 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/request.md#%E5%8A%A0%E5%A5%BD%E5%8F%8B%E8%AF%B7%E6%B1%82">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class PTFriendJoinRequest extends ProcessorTemplate<FriendJoinRequestEvent> {

  public PTFriendJoinRequest(BotInstance instance) {
    super(instance, "request", "friend");
  }

}

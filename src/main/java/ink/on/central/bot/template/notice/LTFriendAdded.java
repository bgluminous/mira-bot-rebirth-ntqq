package ink.on.central.bot.template.notice;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.notice.FriendAddedEvent;
import ink.on.central.bot.template.ListenerTemplate;

/**
 * 好友添加事件 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E5%A5%BD%E5%8F%8B%E6%B7%BB%E5%8A%A0">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class LTFriendAdded extends ListenerTemplate<FriendAddedEvent> {

  public LTFriendAdded(BotInstance instance) {
    super(instance, "notice", "friend_add");
  }

}

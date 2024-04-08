package ink.on.central.bot.template.notice;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.notice.FriendMessageRecallEvent;
import ink.on.central.bot.template.ProcessorTemplate;
import ink.on.central.bot.utils.SenderUtil;

/**
 * 群消息撤回事件 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E6%B6%88%E6%81%AF%E6%92%A4%E5%9B%9E">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class PTFriendMessageRecall extends ProcessorTemplate<FriendMessageRecallEvent> {

  public PTFriendMessageRecall(BotInstance instance, SenderUtil sender) {
    super(instance, sender, "notice", "friend_recall");
  }

}

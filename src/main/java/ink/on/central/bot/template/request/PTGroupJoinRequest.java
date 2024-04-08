package ink.on.central.bot.template.request;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.request.GroupJoinRequestEvent;
import ink.on.central.bot.template.ProcessorTemplate;
import ink.on.central.bot.utils.SenderUtil;

/**
 * 群邀请事件 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/request.md#%E5%8A%A0%E7%BE%A4%E8%AF%B7%E6%B1%82%E9%82%80%E8%AF%B7">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class PTGroupJoinRequest extends ProcessorTemplate<GroupJoinRequestEvent> {

  public PTGroupJoinRequest(BotInstance instance, SenderUtil sender) {
    super(instance, sender, "request", "group");
  }

}

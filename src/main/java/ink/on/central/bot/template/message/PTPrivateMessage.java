package ink.on.central.bot.template.message;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.message.PrivateMessageEvent;
import ink.on.central.bot.template.ProcessorTemplate;
import ink.on.central.bot.utils.SenderUtil;

/**
 * 私信 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/message.md#%E7%A7%81%E8%81%8A%E6%B6%88%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class PTPrivateMessage extends ProcessorTemplate<PrivateMessageEvent> {

  public PTPrivateMessage(BotInstance instance, SenderUtil sender) {
    super(instance, sender, "message", "private");
  }

}

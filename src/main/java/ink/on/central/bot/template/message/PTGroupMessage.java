package ink.on.central.bot.template.message;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.message.GroupMessageEvent;
import ink.on.central.bot.template.ProcessorTemplate;

/**
 * 群消息 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/message.md#%E7%BE%A4%E6%B6%88%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class PTGroupMessage extends ProcessorTemplate<GroupMessageEvent> {

  public PTGroupMessage(BotInstance instance) {
    super(instance,"message", "group");
  }

}

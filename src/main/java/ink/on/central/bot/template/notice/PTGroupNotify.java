package ink.on.central.bot.template.notice;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.template.ProcessorTemplate;
import ink.on.central.bot.utils.SenderUtil;


@SuppressWarnings("unused")
public class PTGroupNotify extends ProcessorTemplate<PTGroupNotify> {

  public PTGroupNotify(BotInstance instance, SenderUtil sender) {
    super(instance, sender, "notice", "notify");
  }

}

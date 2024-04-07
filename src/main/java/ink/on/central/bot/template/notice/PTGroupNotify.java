package ink.on.central.bot.template.notice;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.template.ProcessorTemplate;


@SuppressWarnings("unused")
public class PTGroupNotify extends ProcessorTemplate<PTGroupNotify> {

  public PTGroupNotify(BotInstance instance) {
    super(instance, "notice", "notify");
  }

}

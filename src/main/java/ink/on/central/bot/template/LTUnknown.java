package ink.on.central.bot.template;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.UnknownEvent;

@SuppressWarnings("unused")
public class LTUnknown extends ListenerTemplate<UnknownEvent> {

  /**
   * 构造方法
   *
   * @param instance      机器人实例
   */
  public LTUnknown(BotInstance instance) {
    super(instance, "unknown", "unknown");
  }

}

package ink.on.central.bot.template.meta;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.meta.LifecycleEvent;
import ink.on.central.bot.template.ListenerTemplate;

/**
 * 生命周期事件 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/meta.md#%E7%94%9F%E5%91%BD%E5%91%A8%E6%9C%9F">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class LTLifecycle extends ListenerTemplate<LifecycleEvent> {

  public LTLifecycle(BotInstance instance) {
    super(instance, "meta_event", "lifecycle");
  }

}

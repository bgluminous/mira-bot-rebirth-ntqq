package ink.on.central.bot.template.meta;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.meta.LifecycleEvent;
import ink.on.central.bot.template.ProcessorTemplate;
import ink.on.central.bot.utils.SenderUtil;

/**
 * 心跳检查事件 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/meta.md#%E5%BF%83%E8%B7%B3">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class PTLifecycle extends ProcessorTemplate<LifecycleEvent> {

  public PTLifecycle(BotInstance instance, SenderUtil sender) {
    super(instance, sender, "meta_event", "lifecycle");
  }

}

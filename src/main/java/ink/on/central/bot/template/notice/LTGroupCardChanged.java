package ink.on.central.bot.template.notice;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.notice.GroupCardChangedEvent;
import ink.on.central.bot.template.ListenerTemplate;

/**
 * 群名片修改事件 处理器模板
 * Create Time: 2024-06-05 Last Update:
 *
 * @author BGLuminous
 * @since 1.7.1
 */
@SuppressWarnings("unused")
public class LTGroupCardChanged extends ListenerTemplate<GroupCardChangedEvent> {

  /**
   * 构造方法
   *
   * @param instance 机器人实例
   */
  public LTGroupCardChanged(BotInstance instance) {
    super(instance, "notice", "group_card");
  }

}

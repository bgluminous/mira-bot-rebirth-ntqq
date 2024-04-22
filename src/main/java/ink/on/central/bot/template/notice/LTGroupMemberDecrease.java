package ink.on.central.bot.template.notice;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.notice.GroupMemberDecreaseEvent;
import ink.on.central.bot.template.ListenerTemplate;

/**
 * 群成员减少事件 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E6%88%90%E5%91%98%E5%87%8F%E5%B0%91">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update: 2024-04-12
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class LTGroupMemberDecrease extends ListenerTemplate<GroupMemberDecreaseEvent> {

  public LTGroupMemberDecrease(BotInstance instance) {
    super(instance, "notice", "group_decrease");
  }

}

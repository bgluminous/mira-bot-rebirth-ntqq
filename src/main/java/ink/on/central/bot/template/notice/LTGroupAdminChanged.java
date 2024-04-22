package ink.on.central.bot.template.notice;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.notice.GroupAdminChangedEvent;
import ink.on.central.bot.template.ListenerTemplate;

/**
 * 群管理员变动事件 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E7%AE%A1%E7%90%86%E5%91%98%E5%8F%98%E5%8A%A8">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class LTGroupAdminChanged extends ListenerTemplate<GroupAdminChangedEvent> {

  public LTGroupAdminChanged(BotInstance instance) {
    super(instance, "notice", "group_admin");
  }

}

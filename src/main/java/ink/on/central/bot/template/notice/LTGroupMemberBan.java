package ink.on.central.bot.template.notice;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.notice.GroupMemberBanEvent;
import ink.on.central.bot.template.ListenerTemplate;

/**
 * 群禁言事件 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E7%A6%81%E8%A8%80">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update: 2024-04-12
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class LTGroupMemberBan extends ListenerTemplate<GroupMemberBanEvent> {

  public LTGroupMemberBan(BotInstance instance) {
    super(instance, "notice", "group_ban");
  }

}

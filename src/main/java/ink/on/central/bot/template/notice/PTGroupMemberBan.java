package ink.on.central.bot.template.notice;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.template.ProcessorTemplate;
import ink.on.central.bot.utils.SenderUtil;

/**
 * 群禁言事件 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E7%A6%81%E8%A8%80">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class PTGroupMemberBan extends ProcessorTemplate<PTGroupMemberBan> {

  public PTGroupMemberBan(BotInstance instance, SenderUtil sender) {
    super(instance, sender, "notice", "group_ban");
  }

}

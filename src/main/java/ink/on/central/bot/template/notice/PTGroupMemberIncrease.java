package ink.on.central.bot.template.notice;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.template.ProcessorTemplate;

/**
 * 群成员增加事件 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E6%88%90%E5%91%98%E5%A2%9E%E5%8A%A0">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class PTGroupMemberIncrease extends ProcessorTemplate<PTGroupMemberIncrease> {

  public PTGroupMemberIncrease(BotInstance instance) {
    super(instance, "notice", "group_increase");
  }

}

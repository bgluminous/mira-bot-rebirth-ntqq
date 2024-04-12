package ink.on.central.bot.template.notice;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.notice.GroupNotifyEvent;
import ink.on.central.bot.template.ProcessorTemplate;

/**
 * 群内戳一戳事件 / 群红包运气王 / 群成员荣誉变更 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E5%86%85%E6%88%B3%E4%B8%80%E6%88%B3">查看文档</a>
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E7%BA%A2%E5%8C%85%E8%BF%90%E6%B0%94%E7%8E%8B">查看文档</a>
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E6%88%90%E5%91%98%E8%8D%A3%E8%AA%89%E5%8F%98%E6%9B%B4">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update: 2024-04-12
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class PTGroupNotify extends ProcessorTemplate<GroupNotifyEvent> {

  public PTGroupNotify(BotInstance instance) {
    super(instance, "notice", "notify");
  }

}

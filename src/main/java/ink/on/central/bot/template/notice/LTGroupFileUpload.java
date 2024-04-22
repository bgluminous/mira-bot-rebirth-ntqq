package ink.on.central.bot.template.notice;

import ink.on.central.bot.BotInstance;
import ink.on.central.bot.entity.event.notice.GroupFileUploadEvent;
import ink.on.central.bot.template.ListenerTemplate;

/**
 * 群上传文件事件 处理器模板
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E6%96%87%E4%BB%B6%E4%B8%8A%E4%BC%A0">查看文档</a>
 * <br>
 * Create Time: 2024-04-07 Last Update: 2024-04-12
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class LTGroupFileUpload extends ListenerTemplate<GroupFileUploadEvent> {

  public LTGroupFileUpload(BotInstance instance) {
    super(instance, "notice", "group_upload");
  }

}

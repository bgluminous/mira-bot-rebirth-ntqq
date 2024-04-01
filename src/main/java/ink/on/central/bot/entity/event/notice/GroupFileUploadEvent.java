package ink.on.central.bot.entity.event.notice;

import ink.on.central.bot.entity.event.notice.pojo.GroupFilePojo;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群上传文件事件 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E6%96%87%E4%BB%B6%E4%B8%8A%E4%BC%A0">查看文档</a>
 * <br>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupFileUploadEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private String noticeType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 群号 */
  private Long groupId;
  /** 发送者 QQ 号 */
  private Long userId;
  /** 文件信息 */
  private GroupFilePojo file;
}

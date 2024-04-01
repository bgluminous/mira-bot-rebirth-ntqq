package ink.on.central.bot.entity.event.notice.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群上传文件 实体类
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
public class GroupFilePojo {
  /** 文件 ID */
  private String id;
  /** 文件名 */
  private String name;
  /** 文件大小（字节数） */
  private Long size;
  /** busid（目前不清楚有什么作用） */
  private Long busid;
}

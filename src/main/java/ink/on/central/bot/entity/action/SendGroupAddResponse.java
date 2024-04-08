package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 处理加群请求／邀请载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#set_group_add_request-%E5%A4%84%E7%90%86%E5%8A%A0%E7%BE%A4%E8%AF%B7%E6%B1%82%E9%82%80%E8%AF%B7">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGroupAddResponse {
  /** 加群请求的 flag（需从上报的数据中获得） */
  private String flag;
  /** add 或 invite，请求类型（需要和上报消息中的 sub_type 字段相符） */
  private String type;
  /** 是否同意请求 */
  private Boolean approve;
  /** 拒绝理由（仅在拒绝时有效） */
  private String remark;
}

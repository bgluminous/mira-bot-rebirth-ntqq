package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群组匿名用户禁言载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#set_group_anonymous_ban-%E7%BE%A4%E7%BB%84%E5%8C%BF%E5%90%8D%E7%94%A8%E6%88%B7%E7%A6%81%E8%A8%80">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGroupBanAnonymous {
  /** 群号 */
  private Long groupId;
  /** 要禁言的匿名用户的 flag（需从群消息上报的数据中获得） */
  private String flag;
  /** 禁言时长，单位秒，0 表示取消禁言 */
  private Integer duration;
}

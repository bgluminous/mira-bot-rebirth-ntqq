package ink.on.central.bot.entity.response.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群龙王荣誉实体
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#get_group_honor_info-%E8%8E%B7%E5%8F%96%E7%BE%A4%E8%8D%A3%E8%AA%89%E4%BF%A1%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupHonorCurrentTalkative {
  /** QQ 号 */
  private String userId;
  /** 昵称 */
  private String nickname;
  /** 头像 URL */
  private String avatar;
  /** 持续天数 */
  private Integer dayCount;
}

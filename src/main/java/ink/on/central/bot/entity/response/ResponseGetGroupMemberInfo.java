package ink.on.central.bot.entity.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 获取群成员信息返回实体
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#get_group_member_info-%E8%8E%B7%E5%8F%96%E7%BE%A4%E6%88%90%E5%91%98%E4%BF%A1%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class ResponseGetGroupMemberInfo {
  /** 群号 */
  private Long groupId;
  /** 发送者 QQ 号 */
  private Long userId;
  /** 昵称 */
  private String nickname;
  /** 群名片／备注 */
  private String card;
  /** 性别，male 或 female 或 unknown */
  private String sex;
  /** 年龄 */
  private String age;
  /** 地区 */
  private String area;
  /** 加群时间戳 */
  private Integer joinTime;
  /** 最后发言时间戳 */
  private Integer lastSentTime;
  /** 成员等级 */
  private String level;
  /** 角色，owner 或 admin 或 member */
  private String role;
  /** 是否不良记录成员 */
  private Boolean unfriendly;
  /** 专属头衔 */
  private String title;
  /** 专属头衔过期时间戳 */
  private Integer titleExpireTime;
  /** 是否允许修改群名片 */
  private Boolean cardChangeable;
}

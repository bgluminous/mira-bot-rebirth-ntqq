package ink.on.central.bot.entity.event.message.pojo;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 群消息发送者 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/message.md#%E7%BE%A4%E6%B6%88%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-03-29 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupSenderPojo {
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
  /** 成员等级 */
  private String level;
  /** 角色，owner 或 admin 或 member */
  private String role;
  /** 专属头衔 */
  private String title;
}

package ink.on.central.bot.entity.event.notice;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群内戳一戳事件 / 群红包运气王 / 群成员荣誉变更 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E5%86%85%E6%88%B3%E4%B8%80%E6%88%B3">查看文档</a>
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E7%BA%A2%E5%8C%85%E8%BF%90%E6%B0%94%E7%8E%8B">查看文档</a>
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/event/notice.md#%E7%BE%A4%E6%88%90%E5%91%98%E8%8D%A3%E8%AA%89%E5%8F%98%E6%9B%B4">查看文档</a>
 * <br>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class GroupNotifyEvent {
  /** 上报类型 */
  private String postType;
  /** 请求类型 */
  private String noticeType;

  /** 事件发生的时间戳 */
  private Long time;
  /** 收到事件的机器人 QQ 号 */
  private Long selfId;

  /** 提示类型 poke lucky_king honor */
  private String subType;
  /** 群号 */
  private Long groupId;
  /** 事件来源 QQ (当subType为honor时为影响的对象) */
  private Long userId;
  /** 事件目标 QQ 号 */
  private Long targetId;
  /** 荣誉类型，分别表示龙王、群聊之火、快乐源泉 (只当subType为honor时存在) */
  private String honorType;
}

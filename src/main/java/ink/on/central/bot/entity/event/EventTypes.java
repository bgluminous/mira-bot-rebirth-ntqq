package ink.on.central.bot.entity.event;

public class EventTypes {

  /**
   * 消息事件类型枚举
   *
   * @author BGLuminous
   * @since 1.0.0
   */
  public enum MessageTypes {
    PRIVATE,
    GROUP,
  }

  /**
   * 元事件类型枚举
   *
   * @author BGLuminous
   * @since 1.0.0
   */
  public enum MetaEventTypes {
    LIFECYCLE,
    HEARTBEAT,
  }

  /**
   * 通知事件类型枚举
   *
   * @author BGLuminous
   * @since 1.0.0
   */
  public enum NoticeTypes {
    GROUP_UPLOAD,
    GROUP_ADMIN,
    GROUP_DECREASE,
    GROUP_INCREASE,
    GROUP_BAN,
    FRIEND_ADD,
    GROUP_RECALL,
    FRIEND_RECALL,
    NOTIFY,
  }

  /**
   * 请求事件类型枚举
   *
   * @author BGLuminous
   * @since 1.0.0
   */
  public enum RequestTypes {
    FRIEND,
    GROUP
  }

}

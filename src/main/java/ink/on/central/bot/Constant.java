package ink.on.central.bot;

/**
 * 常量存放类
 * <p>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
public class Constant {
  public static final String PRIVATE = "private";
  public static final String GROUP = "group";

  /** API Action */
  public static class API {
    /** 发送消息 合并了 [send_private_msg 发送私聊消息] 和 [send_group_msg 发送群消息] */
    public static final String SEND_MSG = "send_msg";
    /** 撤回消息 */
    public static final String DELETE_MSG = "delete_msg";
    /** 获取消息 */
    public static final String GET_MSG = "get_msg";
    /** 获取合并转发消息 */
    public static final String GET_FORWARD_MSG = "get_forward_msg";
    /** 发送好友赞 */
    public static final String SEND_LIKE = "send_like";
    /** 群组踢人 */
    public static final String SET_GROUP_KICK = "set_group_kick";
    /** 群组单人禁言 */
    public static final String SET_GROUP_BAN = "set_group_ban";
    /** 群组匿名用户禁言 */
    public static final String SET_GROUP_ANONYMOUS_BAN = "set_group_anonymous_ban";
    /** 群组全员禁言 */
    public static final String SET_GROUP_WHOLE_BAN = "set_group_whole_ban";
    /** 群组设置管理员 */
    public static final String SET_GROUP_ADMIN = "set_group_admin";
    /** 群组匿名 */
    public static final String SET_GROUP_ANONYMOUS = "set_group_anonymous";
    /** 设置群名片（群备注） */
    public static final String SET_GROUP_CARD = "set_group_card";
    /** 设置群名 */
    public static final String SET_GROUP_NAME = "set_group_name";
    /** 退出群组 */
    public static final String SET_GROUP_LEAVE = "set_group_leave";
    /** 设置群组专属头衔 */
    public static final String SET_GROUP_SPECIAL_TITLE = "set_group_special_title";
    /** 处理加好友请求 */
    public static final String SET_FRIEND_ADD_REQUEST = "set_friend_add_request";
    /** 处理加群请求／邀请 */
    public static final String SET_GROUP_ADD_REQUEST = "set_group_add_request";
    /** 获取登录号信息 */
    public static final String GET_LOGIN_INFO = "get_login_info";
    /** 获取陌生人信息 */
    public static final String GET_STRANGER_INFO = "get_stranger_info";
    /** 获取好友列表 */
    public static final String GET_FRIEND_LIST = "get_friend_list";
    /** 获取群信息 */
    public static final String GET_GROUP_INFO = "get_group_info";
    /** 获取群列表 */
    public static final String GET_GROUP_LIST = "get_group_list";
    /** 获取群成员信息 */
    public static final String GET_GROUP_MEMBER_INFO = "get_group_member_info";
    /** 获取群成员列表 */
    public static final String GET_GROUP_MEMBER_LIST = "get_group_member_list";
    /** 获取群荣誉信息 */
    public static final String GET_GROUP_HONOR_INFO = "get_group_honor_info";
    /** 获取 QQ 相关接口凭证 */
    public static final String GET_CREDENTIAL = "get_credentials";
    /** 获取语音 */
    public static final String GET_RECORD = "get_record";
    /** 获取图片 */
    public static final String GET_IMAGE = "get_image";
    /** 检查是否可以发送图片 */
    public static final String CAN_SEND_IMAGE = "can_send_image";
    /** 检查是否可以发送语音 */
    public static final String CAN_SEND_VOICE = "can_send_voice";
    /** 获取运行状态 */
    public static final String GET_STATUS = "get_status";
    /** 获取版本信息 */
    public static final String GET_VERSION_INFO = "get_version_info";
    /** 重启 OneBot 实现 */
    public static final String SET_RESTART = "set_restart";
    /** 清理缓存 */
    public static final String CLEAN_CACHE = "clean_cache";

    /** 私有构造方法 */
    private API() {
    }
  }

  /** 私有构造方法 */
  private Constant() {
  }
}

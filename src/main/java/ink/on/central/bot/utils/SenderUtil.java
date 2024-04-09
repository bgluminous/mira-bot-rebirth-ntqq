package ink.on.central.bot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import ink.ik.tools.toys.IkToySnowflakeSingleton;
import ink.on.central.bot.Constant;
import ink.on.central.bot.entity.SendSocketWrap;
import ink.on.central.bot.entity.action.*;
import ink.on.central.bot.entity.message.MessagePart;
import org.java_websocket.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 发送工具类
 * <p>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class SenderUtil {
  private static final Logger log = LoggerFactory.getLogger(SenderUtil.class);

  /** 当前事件的连接 */
  private final WebSocket connect;

  /** 构造函数 */
  public SenderUtil(WebSocket currentConn) {
    this.connect = currentConn;
  }

  /**
   * 创建API请求实体包装
   *
   * @param action 目标API
   * @param params 请求参数
   * @param echo   回调ID
   *
   * @return API请求实体包装
   */
  private static SendSocketWrap createWrap(String action, Object params, Long echo) {
    return new SendSocketWrap().setAction(action).setParams(params).setEcho(String.valueOf(echo));
  }

  /**
   * 发送API请求
   *
   * @param wrap API请求实体包装
   *
   * @throws JsonProcessingException 序列化异常
   */
  private void send(SendSocketWrap wrap) throws JsonProcessingException {
    String dataJsonStr = JacksonUtil.toJsonString(wrap);
    log.debug("发送数据! {}", dataJsonStr);
    connect.send(dataJsonStr);
  }

  /**
   * 发送自定义包
   *
   * @param action     目标API
   * @param paramsJson 请求参数
   * @param echo       回调ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendRaw(String action, String paramsJson, Long echo) throws JsonProcessingException {
    SendSocketWrap wrap = createWrap(action, paramsJson, echo);
    connect.send(JacksonUtil.toJsonString(wrap));
  }

  /**
   * 发送私聊消息
   *
   * @param qqId            目标QQ
   * @param messagePartList 消息片列表
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendPrivateMessage(Long qqId, List<MessagePart<?>> messagePartList)
    throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    SendMessage message = new SendMessage()
      .setMessageType(Constant.PRIVATE)
      .setUserId(qqId)
      .setMessage(messagePartList)
      .setAutoEscape(false);
    send(createWrap(Constant.API.SEND_MSG, message, id));
    return id;
  }

  /**
   * 发送私聊消息
   *
   * @param qqId          目标QQ
   * @param singleMessage 单个消息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendPrivateMessage(Long qqId, Map<String, String> singleMessage)
    throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    SendMessage message = new SendMessage()
      .setMessageType(Constant.PRIVATE)
      .setUserId(qqId)
      .setMessage(singleMessage)
      .setAutoEscape(false);
    send(createWrap(Constant.API.SEND_MSG, message, id));
    return id;
  }

  /**
   * 发送私聊消息
   *
   * @param qqId          目标QQ
   * @param cqCodeMessage CQ码消息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendPrivateMessage(Long qqId, String cqCodeMessage) throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    SendMessage message = new SendMessage()
      .setMessageType(Constant.PRIVATE)
      .setUserId(qqId)
      .setMessage(cqCodeMessage)
      .setAutoEscape(true);
    send(createWrap(Constant.API.SEND_MSG, message, id));
    return id;
  }

  /**
   * 发送群聊消息
   *
   * @param groupId         目标群
   * @param messagePartList 消息片列表
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGroupMessage(Long groupId, List<MessagePart<?>> messagePartList)
    throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    SendMessage message = new SendMessage()
      .setMessageType(Constant.GROUP)
      .setGroupId(groupId)
      .setMessage(messagePartList)
      .setAutoEscape(false);
    send(createWrap(Constant.API.SEND_MSG, message, id));
    return id;
  }

  /**
   * 发送群聊消息
   *
   * @param groupId       目标群
   * @param singleMessage 单个消息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGroupMessage(Long groupId, Map<String, String> singleMessage)
    throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    SendMessage message = new SendMessage()
      .setMessageType(Constant.GROUP)
      .setGroupId(groupId)
      .setMessage(singleMessage)
      .setAutoEscape(false);
    send(createWrap(Constant.API.SEND_MSG, message, id));
    return id;
  }

  /**
   * 发送群聊消息
   *
   * @param groupId       目标群
   * @param cqCodeMessage CQ码消息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGroupMessage(Long groupId, String cqCodeMessage) throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    SendMessage message = new SendMessage()
      .setMessageType(Constant.GROUP)
      .setGroupId(groupId)
      .setMessage(cqCodeMessage)
      .setAutoEscape(true);
    send(createWrap(Constant.API.SEND_MSG, message, id));
    return id;
  }

  /**
   * 撤回消息
   *
   * @param messageId 消息ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendDeleteMessage(Integer messageId) throws JsonProcessingException {
    send(
      createWrap(Constant.API.DELETE_MSG, new SendDeleteMessage().setMessageId(messageId), 0L)
    );
  }

  /**
   * 获取消息
   *
   * @param messageId 消息ID
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long getMessage(Integer messageId) throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(
      createWrap(Constant.API.GET_MSG, new SendGetMessage().setMessageId(messageId), id)
    );
    return id;
  }

  /**
   * 获取合并转发消息
   *
   * @param messageId 消息ID
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long getForwardMessage(Integer messageId) throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(
      createWrap(
        Constant.API.GET_FORWARD_MSG, new SendGetForwardMessage().setMessageId(messageId), id
      )
    );
    return id;
  }

  /**
   * 赞
   *
   * @param like 赞
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendLike(SendLike like) throws JsonProcessingException {
    send(createWrap(Constant.API.SEND_LIKE, like, 0L));
  }

  /**
   * 群聊踢人
   *
   * @param kick 踢人
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendGroupKick(SendGroupKick kick) throws JsonProcessingException {
    send(createWrap(Constant.API.SET_GROUP_KICK, kick, 0L));
  }

  /**
   * 设置群聊禁言用户
   *
   * @param ban 禁言
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendGroupBan(SendGroupBan ban) throws JsonProcessingException {
    send(createWrap(Constant.API.SET_GROUP_BAN, ban, 0L));
  }

  /**
   * 设置群聊禁言匿名用户
   *
   * @param ban 禁言
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendGroupBanAnonymous(SendGroupBanAnonymous ban) throws JsonProcessingException {
    send(createWrap(Constant.API.SET_GROUP_ANONYMOUS_BAN, ban, 0L));
  }

  /**
   * 设置群聊全体禁言
   *
   * @param ban 禁言
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendGroupBanAll(SendGroupBanAll ban) throws JsonProcessingException {
    send(createWrap(Constant.API.SET_GROUP_WHOLE_BAN, ban, 0L));
  }

  /**
   * 设置群聊管理员
   *
   * @param admin 管理员
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendGroupAdmin(SendGroupSetAdmin admin) throws JsonProcessingException {
    send(createWrap(Constant.API.SET_GROUP_ADMIN, admin, 0L));
  }

  /**
   * 设置允许匿名
   *
   * @param anonymous 匿名
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendGroupAnonymous(SendGroupSetEnableAnonymous anonymous)
    throws JsonProcessingException {
    send(createWrap(Constant.API.SET_GROUP_ANONYMOUS, anonymous, 0L));
  }

  /**
   * 设置群聊群名片
   *
   * @param card 群名片
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendGroupCard(SendGroupSetMemberCard card) throws JsonProcessingException {
    send(createWrap(Constant.API.SET_GROUP_CARD, card, 0L));
  }

  /**
   * 设置群聊群名
   *
   * @param name 群名
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendGroupName(SendGroupSetName name) throws JsonProcessingException {
    send(createWrap(Constant.API.SET_GROUP_NAME, name, 0L));
  }

  /**
   * 退出群聊
   *
   * @param leave 退出
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendGroupLeave(SendGroupLeave leave) throws JsonProcessingException {
    send(createWrap(Constant.API.SET_GROUP_LEAVE, leave, 0L));
  }

  /**
   * 设置群聊群头衔
   *
   * @param title 群头衔
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendSetGroupSpecialTitle(SendGroupSetMemberSpecialTitle title)
    throws JsonProcessingException {
    send(createWrap(Constant.API.SET_GROUP_SPECIAL_TITLE, title, 0L));
  }

  /**
   * 添加好友反馈
   *
   * @param request 好友请求
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendFriendAddRequest(SendFriendAddResponse request) throws JsonProcessingException {
    send(createWrap(Constant.API.SET_FRIEND_ADD_REQUEST, request, 0L));
  }

  /**
   * 添加群聊反馈
   *
   * @param request 群聊请求
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendGroupAddRequest(SendGroupAddResponse request) throws JsonProcessingException {
    send(createWrap(Constant.API.SET_GROUP_ADD_REQUEST, request, 0L));
  }

  /**
   * 获取登录信息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetLoginInfo() throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_LOGIN_INFO, Collections.emptyMap(), id));
    return id;
  }

  /**
   * 获取陌生人信息
   *
   * @param info 陌生人信息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetStrangerInfo(SendGetStrangerInfo info) throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_STRANGER_INFO, info, id));
    return id;
  }

  /**
   * 获取好友列表
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetFriendList() throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_FRIEND_LIST, Collections.emptyMap(), id));
    return id;
  }

  /**
   * 获取群列表
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetGroupList() throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_GROUP_LIST, Collections.emptyMap(), id));
    return id;
  }

  /**
   * 获取群信息
   *
   * @param info 群聊信息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetGroupInfo(SendGetGroupInfo info) throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_GROUP_INFO, info, id));
    return id;
  }

  /**
   * 获取群成员信息
   *
   * @param info 群成员信息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetGroupMemberInfo(SendGetGroupMemberInfo info) throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_GROUP_MEMBER_INFO, info, id));
    return id;
  }

  /**
   * 获取群成员列表
   *
   * @param list 群成员列表
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetGroupMemberList(SendGetGroupMemberList list) throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_GROUP_MEMBER_LIST, list, id));
    return id;
  }

  /**
   * 获取群荣誉信息
   *
   * @param honorInfo 群荣誉信息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetGroupHonorInfo(SendGetGroupHonorInfo honorInfo)
    throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_GROUP_HONOR_INFO, honorInfo, id));
    return id;
  }

  /**
   * 获取凭证信息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetCredentials() throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_CREDENTIAL, Collections.emptyMap(), id));
    return id;
  }

  /**
   * 获取语音信息
   *
   * @param voice 语音信息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetRecord(SendGetRecord voice) throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_RECORD, voice, id));
    return id;
  }

  /**
   * 获取图片信息
   *
   * @param image 图片信息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetImage(SendGetImage image) throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_IMAGE, image, id));
    return id;
  }

  /**
   * 检查是否可以发送图片
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendCanSendImage() throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.CAN_SEND_IMAGE, Collections.emptyMap(), id));
    return id;
  }

  /**
   * 检查是否可以发送语音
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendCanSendVoice() throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.CAN_SEND_VOICE, Collections.emptyMap(), id));
    return id;
  }

  /**
   * 获取运行状态
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetStatus() throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_STATUS, Collections.emptyMap(), id));
    return id;
  }

  /**
   * 获取版本信息
   *
   * @return 请求ID
   *
   * @throws JsonProcessingException 序列化异常
   */
  public Long sendGetVersionInfo() throws JsonProcessingException {
    Long id = IkToySnowflakeSingleton.getInstance().nextId();
    send(createWrap(Constant.API.GET_VERSION_INFO, Collections.emptyMap(), id));
    return id;
  }

  /**
   * 重启
   *
   * @param restart 重启
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendSystemRestart(SendSystemRestart restart) throws JsonProcessingException {
    send(createWrap(Constant.API.SET_RESTART, restart, 0L));
  }

  /**
   * 清理缓存
   *
   * @throws JsonProcessingException 序列化异常
   */
  public void sendSystemCleanCache() throws JsonProcessingException {
    send(createWrap(Constant.API.CLEAN_CACHE, Collections.emptyMap(), 0L));
  }

}

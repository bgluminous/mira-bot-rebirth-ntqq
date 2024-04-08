package ink.on.central.bot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import ink.ik.tools.toys.IkToySnowflakeSingleton;
import ink.on.central.bot.BotInstance;
import ink.on.central.bot.Constant;
import ink.on.central.bot.entity.SendSocketWrap;
import ink.on.central.bot.entity.action.*;
import ink.on.central.bot.entity.message.MessagePart;

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

  private final BotInstance instance;

  public SenderUtil(BotInstance instance) {
    this.instance = instance;
  }

  private static SendSocketWrap createWrap(String action, Object params, Long echo) {
    return new SendSocketWrap().setAction(action).setParams(params).setEcho(String.valueOf(echo));
  }

  private void send(SendSocketWrap wrap) throws JsonProcessingException {
    instance.getConnect().send(JacksonUtil.toJsonString(wrap));
  }

  public void sendRaw(String action, String paramsJson, Long echo) throws JsonProcessingException {
    SendSocketWrap wrap = createWrap(action, paramsJson, echo);
    instance.getConnect().send(JacksonUtil.toJsonString(wrap));
  }

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

  public void sendDeleteMessage(Integer messageId) throws JsonProcessingException {
    send(
      createWrap(Constant.API.DELETE_MSG, new SendDeleteMessage().setMessageId(messageId), 0L)
    );
  }

  public void getMessage(Integer messageId) throws JsonProcessingException {
    send(
      createWrap(Constant.API.GET_MSG, new SendGetMessage().setMessageId(messageId), 0L)
    );
  }


  public void getForwardMessage(Integer id) throws JsonProcessingException {
    send(
      createWrap(Constant.API.GET_FORWARD_MSG, new SendGetForwardMessage().setMessageId(id), 0L)
    );
  }

  public void sendLike(SendLike like) throws JsonProcessingException {
    send(
      createWrap(Constant.API.SEND_LIKE, like, 0L)
    );
  }


}

package ink.on.central.bot.utils;

import ink.on.central.bot.entity.message.MessagePart;
import ink.on.central.bot.entity.message.MessagePartImage;
import ink.on.central.bot.entity.message.MessagePartVideo;

import java.util.List;
import java.util.Map;

/**
 * 消息转换工具类
 * <p>
 * Create Time: 2024-04-12 Last Update:
 *
 * @author BGLuminous
 * @since 1.2.0
 */
@SuppressWarnings("unused")
public class MessageConvertUtil {

  private MessageConvertUtil() {
  }

  /**
   * 将消息数据转换为消息对象
   *
   * @param messageData 消息数据
   *
   * @return 消息对象
   */
  @SuppressWarnings("all")
  public static List<MessagePart<?>> toMessageMap(List<Map<String, Object>> messageData) {
    MessageBuilder builder = new MessageBuilder();
    for (Map<String, Object> messageDatum : messageData) {
      MessagePart<?> messagePart = fromMessage(messageDatum);
      if (messagePart != null) {
        builder.add(messagePart);
      }
    }
    return builder.getMessagePartList();
  }

  @SuppressWarnings("all")
  public static MessagePart<?> fromMessage(Map<String, Object> messageMap) {
    Object type = messageMap.get("type");
    Map<String, String> dataMap = (Map<String, String>) messageMap.get("data");
    if (type.equals("text")) {
      return MessageBuilder.text(dataMap.get("text"));
    }
    if (messageMap.get("tpye").equals("face")) {
      return MessageBuilder.face(dataMap.get("id"));
    }
    if (type.equals("at")) {
      return MessageBuilder.at(dataMap.get("qqid"));
    }
    if (type.equals("reply")) {
      return MessageBuilder.reply(dataMap.get("id"));
    }
    if (type.equals("image")) {
      return MessageBuilder.image(new MessagePartImage()
        .setFile(dataMap.get("file"))
        .setUrl(dataMap.get("url"))
      );
    }
    if (type.equals("video")) {
      return MessageBuilder.video(new MessagePartVideo()
        .setFile(dataMap.get("file"))
        .setUrl(dataMap.get("url"))
      );
    }
    return null;
  }

}

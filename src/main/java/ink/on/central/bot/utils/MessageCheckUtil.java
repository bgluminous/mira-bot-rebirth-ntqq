package ink.on.central.bot.utils;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 消息快速验证工具
 * <p>
 * Create Time: 2024-04-01 Last Update: 2024-04-12
 *
 * @author BGLuminous
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class MessageCheckUtil {

  private MessageCheckUtil() {
  }


  /**
   * 断是否为纯文本消息
   *
   * @param messageList 消息列表
   *
   * @return 是否为纯文本消息
   */
  public static boolean isPureTextMessage(List<Map<String, Object>> messageList) {
    return messageList.size() == 1 && messageList.get(0).get("type").equals("text");
  }

  /**
   * 判断是否为纯文本消息并验证消息内容
   *
   * @param messageList 消息列表
   * @param message     消息内容
   *
   * @return 是否为纯文本消息且验证通过
   */
  public static boolean isPureTextMessageEquals(
    List<Map<String, Object>> messageList, String message
  ) {
    return isPureTextMessage(messageList)
      && messageList.get(0).get("data").equals(Map.of("text", message));
  }

  /**
   * 判断是否为纯文本消息并满足正则表达式
   *
   * @param messageList 消息列表
   * @param regex       正则表达式
   *
   * @return --
   */
  public static boolean isPureTextMessageRegex(List<Map<String, Object>> messageList, String regex) {
    if (!isPureTextMessage(messageList)) {
      return false;
    }
    return Pattern.matches(regex, getPureTextMessage(messageList));
  }

  /**
   * 判断是否为at某人
   *
   * @param messageList 消息列表
   * @param qqid        QQID
   *
   * @return --
   */
  public static boolean isAtSomeOne(List<Map<String, Object>> messageList, String qqid) {
    for (Map<String, Object> stringObjectMap : messageList) {
      if (
        stringObjectMap.get("type").equals("at")
          && stringObjectMap.get("data").equals(Map.of("qq", qqid))
      ) {
        return true;
      }
    }
    return false;
  }

  /**
   * 获取纯文本消息 (会过滤掉其他内容)
   *
   * @param messageList 消息列表
   *
   * @return 过滤后的纯文本信息
   */
  @SuppressWarnings("unchecked")
  public static String getPureTextMessage(List<Map<String, Object>> messageList) {
    StringBuilder sb = new StringBuilder();
    for (Map<String, Object> stringObjectMap : messageList) {
      if (stringObjectMap.get("type").equals("text")) {
        sb.append(((Map<String, String>) stringObjectMap.get("data")).get("text"));
      }
    }
    return sb.toString();
  }

}

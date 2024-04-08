package ink.on.central.bot.utils;

import java.util.List;
import java.util.Map;

/**
 * 消息快速验证工具
 * <p>
 * Create Time: 2024-04-01 Last Update:
 *
 * @version 1.0.0
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class MessageCheckUtil {

  private MessageCheckUtil() {
  }

  /**
   * 判断是否为纯文本消息并验证消息内容
   *
   * @param messageList 消息列表
   * @param message     消息内容
   *
   * @return 是否为纯文本消息且验证通过
   */
  public static boolean isPureTextMessage(List<Map<String, Object>> messageList, String message) {
    return messageList.size() == 1
      && messageList.get(0).get("type").equals("text")
      && messageList.get(0).get("data").equals(Map.of("text", message));
  }

}

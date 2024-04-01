package ink.on.central.bot.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import ink.on.central.bot.constant.EventEntityMapper;
import ink.on.central.bot.utils.JacksonUtil;

import java.util.Map;

public class EventAdapter {

  private EventAdapter() {
  }

  public static Object analyzer(String json) {
    try {
      System.out.println("Received Event Json: %s".formatted(json));
      Map<String, Object> nodeMap = JacksonUtil.getNodeMap(json);
      String eventType = nodeMap.get("post_type").toString();
      String subType;
      switch (eventType) {
        case "meta_event" -> subType = nodeMap.get("meta_event_type").toString();
        case "notice" -> subType = nodeMap.get("notice_type").toString();
        case "request" -> subType = nodeMap.get("request_type").toString();
        case "message" -> subType = nodeMap.get("message_type").toString();
        default -> {
          System.out.println("未知的事件类型! [%s]".formatted(eventType));
          return null;
        }
      }
      Class<?> eventEntityClass = EventEntityMapper.getEventEntity(eventType, subType);
      if (eventEntityClass == null) {
        System.err.println("未实现的事件类型! [%s> %s]".formatted(eventType, subType));
        return null;
      }
      Object eventEntity = JacksonUtil.parse(json, eventEntityClass);
      System.out.println(eventEntity);
      return eventEntity;
    } catch (JsonProcessingException ex) {
      System.out.println(
        "解析事件Json失败... [%s]".formatted(ex.getMessage().replace("\n", ""))
      );
      return null;
    }
  }

}

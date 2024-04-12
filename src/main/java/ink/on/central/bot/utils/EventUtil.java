package ink.on.central.bot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import ink.on.central.bot.EventEntityMapper;
import ink.on.central.bot.entity.event.AnalyzedEvent;
import ink.on.central.bot.exception.MiraBotException;

import java.util.Map;

/**
 * 事件实体分析工具
 * <p>
 * Create Time: 2024-03-29 Last Update: 2024-04-12
 *
 * @author BGLuminous
 * @since 1.0.0
 */
public class EventUtil {

  private EventUtil() {
  }

  /**
   * 解析事件Json并转换为实体类
   *
   * @param json 事件json
   *
   * @return 事件实体
   *
   * @throws MiraBotException        找不到事件实体映射
   * @throws JsonProcessingException 解析事件Json失败
   */
  public static AnalyzedEvent analyzer(String json)
    throws MiraBotException, JsonProcessingException {
    Map<String, Object> nodeMap = JacksonUtil.getNodeMap(json);
    // 处理API调用返回信息
    if (nodeMap.get("retcode") != null) {
      return new AnalyzedEvent()
        .setEventType("retcode")
        .setData(JacksonUtil.toJsonString(nodeMap.get("data")))
        .setResponseId(nodeMap.get("echo").toString());
    }
    String eventType = nodeMap.get("post_type").toString();
    String subType;
    switch (eventType) {
      case "meta_event" -> subType = nodeMap.get("meta_event_type").toString();
      case "notice" -> subType = nodeMap.get("notice_type").toString();
      case "request" -> subType = nodeMap.get("request_type").toString();
      case "message" -> subType = nodeMap.get("message_type").toString();
      default -> throw new MiraBotException("未知的事件类型! [%s]".formatted(eventType));
    }
    Class<?> eventEntityClass = EventEntityMapper.getEventEntity(eventType, subType);
    if (eventEntityClass == null) {
      throw new MiraBotException("未实现的事件类型! [%s > %s]".formatted(eventType, subType));
    }
    Object data = JacksonUtil.parse(json, eventEntityClass);
    return new AnalyzedEvent()
      .setEventType(eventType)
      .setSubType(subType)
      .setData(data);
  }

}

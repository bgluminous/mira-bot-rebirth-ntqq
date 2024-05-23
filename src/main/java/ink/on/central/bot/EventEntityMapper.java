package ink.on.central.bot;

import ink.on.central.bot.entity.event.message.GroupMessageEvent;
import ink.on.central.bot.entity.event.message.PrivateMessageEvent;
import ink.on.central.bot.entity.event.meta.HeartbeatEvent;
import ink.on.central.bot.entity.event.meta.LifecycleEvent;
import ink.on.central.bot.entity.event.notice.*;
import ink.on.central.bot.entity.event.request.FriendJoinRequestEvent;
import ink.on.central.bot.entity.event.request.GroupJoinRequestEvent;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实体类与事件映射关系管理
 * <p>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
public class EventEntityMapper {
  private static final org.slf4j.Logger log = LoggerFactory.getLogger(EventEntityMapper.class);

  /** 事件与实体映射关系 */
  private static final Map<String, Map<String, Class<?>>> MAPPER = new HashMap<>();

  /* 注入官方实现*/
  static {
    // 注入消息事件实体映射
    Map<String, Class<?>> messageEventMapper = new HashMap<>();
    messageEventMapper.put("group", GroupMessageEvent.class);
    messageEventMapper.put("private", PrivateMessageEvent.class);
    MAPPER.put("message", messageEventMapper);
    // 注入元事件实体映射
    Map<String, Class<?>> metaEventMapper = new HashMap<>();
    metaEventMapper.put("heartbeat", HeartbeatEvent.class);
    metaEventMapper.put("lifecycle", LifecycleEvent.class);
    MAPPER.put("meta_event", metaEventMapper);
    // 注入通知事件实体映射
    Map<String, Class<?>> noticeEventMapper = new HashMap<>();
    noticeEventMapper.put("friend_add", FriendAddedEvent.class);
    noticeEventMapper.put("friend_recall", FriendMessageRecallEvent.class);
    noticeEventMapper.put("group_upload", GroupFileUploadEvent.class);
    noticeEventMapper.put("group_admin", GroupAdminChangedEvent.class);
    noticeEventMapper.put("group_decrease", GroupMemberDecreaseEvent.class);
    noticeEventMapper.put("group_increase", GroupMemberIncreaseEvent.class);
    noticeEventMapper.put("group_ban", GroupMemberBanEvent.class);
    noticeEventMapper.put("group_recall", GroupMessageRecallEvent.class);
    noticeEventMapper.put("group_card", GroupCardChangedEvent.class);
    noticeEventMapper.put("notify", GroupNotifyEvent.class);
    MAPPER.put("notice", noticeEventMapper);
    // 注入请求事件实体映射
    Map<String, Class<?>> requestEventMapper = new HashMap<>();
    requestEventMapper.put("friend", FriendJoinRequestEvent.class);
    requestEventMapper.put("group", GroupJoinRequestEvent.class);
    MAPPER.put("request", requestEventMapper);
  }

  private EventEntityMapper() {
  }

  /**
   * 获取事件实体映射
   *
   * @param eventType    事件类型
   * @param subEventType 子事件类型
   *
   * @return 事件实体类
   */
  public static Class<?> getEventEntity(String eventType, String subEventType) {
    return MAPPER.get(eventType).get(subEventType);
  }


  /**
   * 注册新的事件实体映射, 如果已经存在则直接覆盖
   *
   * @param eventType    事件类型
   * @param subEventType 子事件类型
   * @param eventEntity  事件实体类
   */
  @SuppressWarnings("unused")
  public static void registerNewEventEntity(
    String eventType, String subEventType, Class<?> eventEntity
  ) {
    log.info(
      "正在 注册 / 重写 新的事件实体映射 [{} -> {} => {}.class]",
      eventType, subEventType, eventEntity.getSimpleName()
    );
    MAPPER.get(eventType).put(subEventType, eventEntity);
  }

  /**
   * 移除事件实体映射
   *
   * @param eventType    事件类型
   * @param subEventType 子事件类型
   *
   * @return 是否移除成功
   */
  @SuppressWarnings("unused")
  public static boolean removeEventEntity(String eventType, String subEventType) {
    Map<String, Class<?>> someTypeEventMapper = MAPPER.get(eventType);
    if (someTypeEventMapper == null) {
      log.warn("无法找到主要事件类型: {}", eventType);
      return false;
    }
    return someTypeEventMapper.remove(subEventType) != null;
  }

}

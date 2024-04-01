package ink.on.central.bot.constant;

import ink.on.central.bot.entity.event.meta.HeartbeatEvent;
import ink.on.central.bot.entity.event.meta.LifecycleEvent;
import ink.on.central.bot.entity.event.notice.*;
import ink.on.central.bot.entity.event.request.FriendJoinRequestEvent;
import ink.on.central.bot.entity.event.request.GroupJoinRequestEvent;

import java.util.HashMap;
import java.util.Map;

public class EventEntityMapper {

  private EventEntityMapper() {
  }

  private static final Map<String, Map<String, Class<?>>> MAPPER = new HashMap<>();

  static {
    // 注入消息事件实体映射
    Map<String, Class<?>> messageEventMapper = new HashMap<>();
    //TODO: 消息事件映射未添加 (消息的实体解未完成)
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
    noticeEventMapper.put("notify", GroupNotifyEvent.class);
    MAPPER.put("notice", noticeEventMapper);
    // 注入请求事件实体映射
    Map<String, Class<?>> requestEventMapper = new HashMap<>();
    requestEventMapper.put("friend", FriendJoinRequestEvent.class);
    requestEventMapper.put("group", GroupJoinRequestEvent.class);
    MAPPER.put("request", requestEventMapper);
  }

  public static Class<?> getEventEntity(String eventType, String subEventType) {
    return MAPPER.get(eventType).get(subEventType);
  }

}

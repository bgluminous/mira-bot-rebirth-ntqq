package ink.on.central.bot.utils;

import ink.on.central.bot.entity.message.*;

import java.util.*;

/**
 * 消息构造工具类
 * <p>
 * Create Time: 2024-04-12 Last Update:
 *
 * @author BGLuminous
 * @since 1.2.0
 */
@SuppressWarnings("all")
public class MessageBuilder {
  /** 消息片段列表 */
  private List<MessagePart<?>> messagePartList = new ArrayList<>();

  /** 构造函数 */
  public MessageBuilder() {
  }

  /**
   * 获取消息片段列表
   *
   * @return 消息片段列表
   */
  public List<MessagePart<?>> getMessagePartList() {
    return messagePartList;
  }

  /**
   * 合并消息片段列表
   *
   * @param messagePartList 消息片段列表
   *
   * @return 消息构造器
   */
  public MessageBuilder merge(List<MessagePart<?>> messagePartList) {
    this.messagePartList.addAll(messagePartList);
    return this;
  }

  /**
   * 合并消息构造器
   *
   * @param builder 消息构造器
   *
   * @return 消息构造器
   */
  public MessageBuilder merge(MessageBuilder builder) {
    merge(builder.getMessagePartList());
    return this;
  }

  /**
   * 添加消息片段
   *
   * @param messagePart 消息片段
   *
   * @return 消息构造器
   */
  public MessageBuilder add(MessagePart<?> messagePart) {
    messagePartList.add(messagePart);
    return this;
  }

  /**
   * 添加文本消息片段
   *
   * @param text 文本
   *
   * @return 消息构造器
   */
  public MessageBuilder addText(String text) {
    messagePartList.add(text(text));
    return this;
  }

  /**
   * 构建文本消息片段
   *
   * @param text 文本
   *
   * @return 文本消息片段
   */
  public static MessagePart<Map<String, String>> text(String text) {
    Map<String, String> dataMap = new HashMap<>(1);
    dataMap.put("text", text);
    return new MessagePart<Map<String, String>>()
      .setType("text")
      .setData(dataMap);
  }

  /**
   * 添加表情消息片段
   *
   * @param faceId 表情id
   *
   * @return 消息构造器
   */
  public MessageBuilder addFace(String faceId) {
    messagePartList.add(face(faceId));
    return this;
  }

  /**
   * 构建表情消息片段
   *
   * @param faceId 表情id <a href="https://github.com/richardchien/coolq-http-api/wiki/%E8%A1%A8%E6%83%85-CQ-%E7%A0%81-ID-%E8%A1%A8">表情ID表</a>
   *
   * @return 消息片段
   */
  public static MessagePart<?> face(String faceId) {
    Map<String, String> dataMap = new HashMap<>(1);
    dataMap.put("id", faceId);
    return new MessagePart<Map<String, String>>()
      .setType("face")
      .setData(dataMap);
  }

  /**
   * 添加at消息片段
   *
   * @param qqid qqid
   *
   * @return 消息构造器
   */
  public MessageBuilder addAt(String qqid) {
    messagePartList.add(at(qqid));
    return this;
  }

  public MessageBuilder addAt(long qqid) {
    messagePartList.add(at(String.valueOf(qqid)));
    return this;
  }

  public MessageBuilder addLineBreak() {
    messagePartList.add(text("\n"));
    return this;
  }

  /**
   * 构建at消息片段
   *
   * @param qqid qqid
   *
   * @return 消息片段
   */
  public static MessagePart<?> at(String qqid) {
    Map<String, String> dataMap = new HashMap<>(1);
    dataMap.put("qq", qqid);
    return new MessagePart<Map<String, String>>()
      .setType("at")
      .setData(dataMap);
  }

  public static MessagePart<?> at(long qqid) {
    return at(String.valueOf(qqid));
  }

  /**
   * 添加回复消息片段
   *
   * @param id 回复消息id
   *
   * @return 消息构造器
   */
  public MessageBuilder addReply(String id) {
    Map<String, String> dataMap = new HashMap<>(1);
    dataMap.put("id", id);
    messagePartList.add(
      new MessagePart<Map<String, String>>()
        .setType("reply")
        .setData(dataMap)
    );
    return this;
  }

  /**
   * 构建回复消息片段
   *
   * @param id 回复消息id
   *
   * @return 消息片段
   */
  public static MessagePart<?> reply(String id) {
    Map<String, String> dataMap = new HashMap<>(1);
    dataMap.put("id", id);
    return
      new MessagePart<Map<String, String>>()
        .setType("reply")
        .setData(dataMap);
  }

  /**
   * 添加图片消息片段
   *
   * @param image 图片消息实体
   *
   * @return 消息构造器
   */
  public MessageBuilder addImage(MessagePartImage image) {
    messagePartList.add(image(image));
    return this;
  }

  /**
   * 构建图片消息片段
   *
   * @param image 图片消息实体
   *
   * @return 消息片段
   */
  public static MessagePart<?> image(MessagePartImage image) {
    return new MessagePart<MessagePartImage>()
      .setType("image")
      .setData(image);
  }

  /**
   * 添加视频消息片段
   *
   * @param video 视频消息实体
   *
   * @return 消息构造器
   */
  public MessageBuilder addVideo(MessagePartVideo video) {
    messagePartList.add(video(video));
    return this;
  }

  /**
   * 构建视频消息片段
   *
   * @param video 视频消息实体
   *
   * @return 消息片段
   */
  public static MessagePart<?> video(MessagePartVideo video) {
    return new MessagePart<MessagePartVideo>()
      .setType("video")
      .setData(video);
  }

  /**
   * 构建语音消息
   *
   * @param voice 语音消息实体
   *
   * @return 语音消息片段
   */
  public static MessagePart<?> voice(MessagePartVoice voice) {
    return new MessagePart<MessagePartVoice>()
      .setType("record")
      .setData(voice);
  }

  /**
   * 构建分享链接消息
   *
   * @param share 分享消息实体
   *
   * @return 分享链接消息
   */
  public static MessagePart<?> shareLink(MessagePartShareLink share) {
    return new MessagePart<MessagePartShareLink>()
      .setType("share")
      .setData(share);
  }

  /**
   * 构建分享联系人消息
   *
   * @param share 分享联系人实体
   *
   * @return 分享联系人消息
   */
  public static MessagePart<?> shareContact(MessagePartShareContact share) {
    return new MessagePart<MessagePartShareContact>()
      .setType("contact")
      .setData(share);
  }

  /**
   * 构建分享位置消息
   *
   * @param location 位置信息实体类
   *
   * @return 分享位置消息
   */
  public static MessagePart<?> shareLocation(MessagePartShareLocation location) {
    return new MessagePart<MessagePartShareLocation>()
      .setType("location")
      .setData(location);
  }

  /**
   * 构建分享音乐消息
   *
   * @param music 音乐信息实体类
   *
   * @return 分享音乐消息
   */
  public static MessagePart<?> shareMusic(MessagePartShareMusic music) {
    return new MessagePart<MessagePartShareMusic>()
      .setType("music")
      .setData(music);
  }

  /**
   * 构建分享自定义音乐消息
   *
   * @param music 自定义音乐信息实体类
   *
   * @return 分享自定义音乐消息
   */
  public static MessagePart<?> shareCustomMusic(
    MessagePartShareCustomMusic music
  ) {
    return new MessagePart<MessagePartShareCustomMusic>()
      .setType("music")
      .setData(music);
  }

  /**
   * 构建转发消息
   *
   * @param id 消息ID
   *
   * @return 转发消息
   */
  public static MessagePart<?> forward(String id) {
    Map<String, String> dataMap = new HashMap<>(1);
    dataMap.put("id", id);
    return new MessagePart<Map<String, String>>()
      .setType("forward")
      .setData(dataMap);
  }

  /**
   * 构建合并转发节点消息
   *
   * @param id 消息ID
   *
   * @return 合并转发节点消息
   */
  public static MessagePart<?> node(String id) {
    Map<String, String> dataMap = new HashMap<>(1);
    dataMap.put("id", id);
    return new MessagePart<Map<String, String>>()
      .setType("node")
      .setData(dataMap);
  }

  /**
   * 构建XML消息
   *
   * @param xml XML字符串
   *
   * @return XML消息
   */
  public static MessagePart<?> xml(String xml) {
    Map<String, String> dataMap = new HashMap<>(1);
    dataMap.put("data", xml);
    return new MessagePart<Map<String, String>>()
      .setType("xml")
      .setData(dataMap);
  }

  /**
   * 构建JSON消息
   *
   * @param json JSON字符串
   *
   * @return JSON消息
   */
  public static MessagePart<?> json(String json) {
    Map<String, String> dataMap = new HashMap<>(1);
    dataMap.put("data", json);
    return new MessagePart<Map<String, String>>()
      .setType("json")
      .setData(dataMap);
  }

  /**
   * 构建猜拳消息
   *
   * @return 猜拳消息
   */
  public static MessagePart<?> rps() {
    return new MessagePart<Map<Object, Object>>()
      .setType("rps")
      .setData(Collections.emptyMap());
  }

  /**
   * 构建骰子消息
   *
   * @return 骰子消息
   */
  public static MessagePart<?> dice() {
    return new MessagePart<Map<Object, Object>>()
      .setType("dice")
      .setData(Collections.emptyMap());
  }

  /**
   * 构建戳一戳消息
   *
   * @return 戳一戳消息
   */
  public static MessagePart<?> shake() {
    return new MessagePart<Map<Object, Object>>()
      .setType("shake")
      .setData(Collections.emptyMap());
  }

  /** 构建匿名消息 (暂不支持) */
  public static MessagePart<Object> anonymous() {
    throw new UnsupportedOperationException("暂不支持匿名消息!");
  }

  /** 构建自定义节点消息 (暂不支持) */
  public static MessagePart<Object> customNode() {
    throw new UnsupportedOperationException("暂不支持自定义节点!");
  }

}

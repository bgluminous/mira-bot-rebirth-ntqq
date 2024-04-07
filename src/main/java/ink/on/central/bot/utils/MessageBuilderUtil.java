package ink.on.central.bot.utils;

import ink.on.central.bot.entity.message.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 消息构造工具类
 * <p>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class MessageBuilderUtil {

  /** 私有构造方法 */
  private MessageBuilderUtil() {
  }

  /** 分片消息部分 */
  public static class Part {

    /** 私有构造方法 */
    private Part() {
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
     * 构建表情消息片段
     *
     * @param faceId 表情id <a href="https://github.com/richardchien/coolq-http-api/wiki/%E8%A1%A8%E6%83%85-CQ-%E7%A0%81-ID-%E8%A1%A8">表情ID表</a>
     *
     * @return 表情消息片段
     */
    public static MessagePart<Map<String, String>> face(String faceId) {
      Map<String, String> dataMap = new HashMap<>(1);
      dataMap.put("id", faceId);
      return new MessagePart<Map<String, String>>()
        .setType("face")
        .setData(dataMap);
    }

    /**
     * 构建at消息片段
     *
     * @param qqid qqid
     *
     * @return at消息片段
     */
    public static MessagePart<Map<String, String>> at(String qqid) {
      Map<String, String> dataMap = new HashMap<>(1);
      dataMap.put("qq", qqid);
      return new MessagePart<Map<String, String>>()
        .setType("at")
        .setData(dataMap);
    }

    /**
     * 构建回复消息片段
     *
     * @param id 回复消息id
     *
     * @return 回复消息片段
     */
    public static MessagePart<Map<String, String>> reply(String id) {
      Map<String, String> dataMap = new HashMap<>(1);
      dataMap.put("id", id);
      return new MessagePart<Map<String, String>>()
        .setType("reply")
        .setData(dataMap);
    }

    /**
     * 构建图片消息片段
     *
     * @param image 图片消息实体
     *
     * @return 图片消息片段
     */
    public static MessagePart<MessagePartImage> image(MessagePartImage image) {
      return new MessagePart<MessagePartImage>()
        .setType("image")
        .setData(image);
    }

    /**
     * 构建视频消息片段
     *
     * @param video 视频消息实体
     *
     * @return 视频消息片段
     */
    public static MessagePart<MessagePartVideo> video(MessagePartVideo video) {
      return new MessagePart<MessagePartVideo>()
        .setType("video")
        .setData(video);
    }

  }

  /** 单体消息部分 */
  public static class Single {

    /** 私有构造方法 */
    private Single() {
    }

    /**
     * 构建语音消息
     *
     * @param voice 语音消息实体
     *
     * @return 语音消息片段
     */
    public static MessagePart<MessagePartVoice> voice(MessagePartVoice voice) {
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
    public static MessagePart<MessagePartShareLink> shareLink(MessagePartShareLink share) {
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
    public static MessagePart<MessagePartShareContact> shareContact(MessagePartShareContact share) {
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
    public static MessagePart<MessagePartShareLocation> shareLocation(MessagePartShareLocation location) {
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
    public static MessagePart<MessagePartShareMusic> shareMusic(MessagePartShareMusic music) {
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
    public static MessagePart<MessagePartShareCustomMusic> shareCustomMusic(
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
    public static MessagePart<Map<String, String>> forward(String id) {
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
    public static MessagePart<Map<String, String>> node(String id) {
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
    public static MessagePart<Map<String, String>> xml(String xml) {
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
    public static MessagePart<Map<String, String>> json(String json) {
      Map<String, String> dataMap = new HashMap<>(1);
      dataMap.put("data", json);
      return new MessagePart<Map<String, String>>()
        .setType("json")
        .setData(dataMap);
    }

  }

  /** 动作消息部分 */
  public static class Action {

    /** 私有构造方法 */
    private Action() {
    }

    /**
     * 构建猜拳消息
     *
     * @return 猜拳消息
     */
    public static MessagePart<Map<Object, Object>> rps() {
      return new MessagePart<Map<Object, Object>>()
        .setType("rps")
        .setData(Collections.emptyMap());
    }

    /**
     * 构建骰子消息
     *
     * @return 骰子消息
     */
    public static MessagePart<Map<Object, Object>> dice() {
      return new MessagePart<Map<Object, Object>>()
        .setType("dice")
        .setData(Collections.emptyMap());
    }

    /**
     * 构建戳一戳消息
     *
     * @return 戳一戳消息
     */
    public static MessagePart<Map<Object, Object>> shake() {
      return new MessagePart<Map<Object, Object>>()
        .setType("shake")
        .setData(Collections.emptyMap());
    }

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

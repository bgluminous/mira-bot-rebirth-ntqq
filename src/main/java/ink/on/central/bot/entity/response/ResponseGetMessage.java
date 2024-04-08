package ink.on.central.bot.entity.response;

import ink.on.central.bot.entity.event.message.pojo.SenderPojo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * 获取消息返回实体
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#get_msg-%E8%8E%B7%E5%8F%96%E6%B6%88%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class ResponseGetMessage {
  /** 事件发生的时间戳 */
  private Long time;
  /** 请求类型 */
  private String messageType;
  /** 消息 ID */
  private Integer messageId;
  /** 未知属性 (文档中没有说明) */
  private Long realId;
  /** 发送人信息 */
  private SenderPojo sender;
  /** 消息内容 */
  private List<Map<String, Object>> message;
}

package ink.on.central.bot.entity.event;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 接受到的事件经过首次分析后用于暂存的实体类
 * <br>
 * Create Time: 2024-04-07 Last Update: 2024-04-12
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class AnalyzedEvent {
  /** 事件主要类型 对应 post_type */
  private String eventType;
  /** 事件类型 */
  private String subType;
  /** 事件信息载体（已经转换为实体类） */
  private Object data;
  /** 返回信息ID 只有调用 API 返回事件会有这个值 */
  private String responseId;

  public String getEventId() {
    return eventType + subType;
  }
}

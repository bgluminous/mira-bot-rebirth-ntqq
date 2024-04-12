package ink.on.central.bot.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * API返回包装类
 * <p>
 * Create Time: 2024-04-12 Last Update:
 *
 * @author BGLuminous
 * @since 1.2.0
 */
@Accessors(chain = true)
@Data
public class ResponseManageWrap {
  /** 返回数据json */
  private Object data;
  /** 接受到的返回时间 */
  private Long trackTime;

  /**
   * 判断是否过期 (默认30S)
   *
   * @return --
   */
  public boolean expire() {
    return System.currentTimeMillis() - trackTime > 30 * 1000L;
  }

}

package ink.on.central.bot.entity.config;

import lombok.Data;

import java.util.List;

/**
 * Bot配置文件
 * <p>
 * Create Time: 2024-04-01 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Data
public class BotConfig {
  /** Bot正向Socket地址 */
  private String url;
  /** token */
  private String token;
  /** 是否重连 */
  private Boolean reconnect;
  /** 重连延迟 单位秒 */
  private Integer reconnectDelayTime;
  /** 重连尝试次数 */
  private Integer reconnectTryTimes;
  /** extra processor package 路径加载列表 */
  private List<String> extraProcessorPackage;
  /** 严格模式 */
  private Boolean strict;

  public BotConfig() {
    // 写入默认配置
    this.reconnectDelayTime = 10;
    this.reconnectTryTimes = 3;
    this.strict = true;
  }

}

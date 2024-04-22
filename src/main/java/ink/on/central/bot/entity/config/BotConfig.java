package ink.on.central.bot.entity.config;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Bot配置文件
 * <p>
 * Create Time: 2024-04-01 Last Update: 2024-04-12
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Data
public class BotConfig {
  /** Bot正向Socket地址 */
  private String url;
  /** 监听端口 */
  private Integer port;
  /** token */
  private String token;
  /** 是否重连 */
  private Boolean reconnect;
  /** 重连延迟 单位秒 */
  private Integer reconnectDelayTime;
  /** 重连尝试次数 */
  private Integer reconnectTryTimes;
  /** extra listener package 路径加载列表 */
  private List<String> extraListenerPackage;
  /** 严格模式 */
  private Boolean strict;

  private Map<String, String> custom;

  public BotConfig() {
    // 写入默认配置
    this.reconnectDelayTime = 10;
    this.reconnectTryTimes = 3;
    this.strict = true;
  }

}

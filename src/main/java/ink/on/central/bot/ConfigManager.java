package ink.on.central.bot;

import ink.ik.tools.wrapper.IkWrapperSnakeYaml;
import ink.ik.tools.wrapper.IkWrapperToml;
import ink.on.central.bot.entity.config.BotConfig;
import ink.on.central.bot.exception.MiraBotError;
import ink.on.central.bot.utils.JacksonUtil;

import java.io.InputStream;

/**
 * 配置管理器
 * <p>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
public class ConfigManager {
  /** 配置 */
  private final BotConfig config;

  public ConfigManager() {
    InputStream is;
    // 加载Json配置文件
    try {
      is = ConfigManager.class.getClassLoader().getResourceAsStream("config.json");
      if (is != null) {
        config = JacksonUtil.parse(is, BotConfig.class);
        return;
      }
      // 加载Yaml配置文件
      is = ConfigManager.class.getClassLoader().getResourceAsStream("config.json");
      if (is != null) {
        config = new IkWrapperSnakeYaml().parse(is, BotConfig.class);
        return;
      }
      is = ConfigManager.class.getClassLoader().getResourceAsStream("config.toml");
      // 加载Toml配置文件
      if (is != null) {
        config = new IkWrapperToml().parse(is, BotConfig.class);
        return;
      }
    } catch (Exception ex) {
      throw new MiraBotError("发现配置文件但是解析失败! 错误信息[%s]".formatted(ex.getMessage()));
    }
    throw new MiraBotError("找不到配置文件!");
  }

  public static BotConfig getConfig() {
    return Holder.INSTANCE.config;
  }

  public static void check() {
    if (Holder.INSTANCE.config.getUrl() == null && Holder.INSTANCE.config.getPort() == null) {
      throw new MiraBotError("配置文件错误! url 和 port 至少需要一个参数");
    }
  }

  private static class Holder {
    private static final ConfigManager INSTANCE = new ConfigManager();
  }

}

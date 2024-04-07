package ink.on.central.bot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.heavenark.infrastructure.log.LogFactory;
import com.heavenark.infrastructure.log.Logger;
import ink.ik.tools.wrapper.IkWrapperJackson;
import ink.ik.tools.wrapper.IkWrapperSnakeYaml;
import ink.ik.tools.wrapper.IkWrapperToml;
import ink.on.central.bot.entity.config.BotConfig;
import ink.on.central.bot.exception.MiraBotError;

import java.io.InputStream;

public class MainStarter {
  private static final Logger LOGGER = LogFactory.getLogger(MainStarter.class);

  public static void main(String[] args) {
    BotConfig config = initConfig();
    try {
      new BotInstance(true, config.getBotSocketUrl(), "").boot();
    } catch (Exception ex) {
      LOGGER.err(ex);
    }
  }

  /**
   * 初始化配置文件
   *
   * @return Bot配置信息
   */
  private static BotConfig initConfig() {
    InputStream is;
    BotConfig config;
    // 加载Json配置文件
    try {
      is = MainStarter.class.getClassLoader().getResourceAsStream("config.json");
      if (is != null) {
        config = new IkWrapperJackson().parse(is, new TypeReference<>() {
        });
        return config;
      }
      // 加载Yaml配置文件
      is = MainStarter.class.getClassLoader().getResourceAsStream("config.json");
      if (is != null) {
        config = new IkWrapperSnakeYaml().parse(is, BotConfig.class);
        return config;
      }
      is = MainStarter.class.getClassLoader().getResourceAsStream("config.toml");
      // 加载Toml配置文件
      if (is != null) {
        config = new IkWrapperToml().parse(is, BotConfig.class);
        return config;
      }
    } catch (Exception ex) {
      throw new MiraBotError("发现配置文件但是解析失败! 错误信息[%s]".formatted(ex.getMessage()));
    }
    throw new MiraBotError("找不到配置文件!");
  }
}

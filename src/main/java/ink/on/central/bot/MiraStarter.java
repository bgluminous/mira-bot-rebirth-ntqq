package ink.on.central.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class MiraStarter {
  private static final Logger log = LoggerFactory.getLogger(MiraStarter.class);

  private MiraStarter() {
  }

  public static void run(Class<?> clz) {
    // 检查并加载事件处理器列表
    ProcessorManager.prepare(clz);
    // 初始化Bot
    BotInstance botInstance = new BotInstance();
    // 注册事件处理器
    ProcessorManager.registerProcessor(botInstance);
    // 启动WS连接
    botInstance.connect();
  }

}
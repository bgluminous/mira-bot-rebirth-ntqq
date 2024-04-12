package ink.on.central.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 启动器
 * <p>
 * Create Time: 2024-04-08 Last Update: 2024-04-12
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class MiraStarter {
  private static final Logger log = LoggerFactory.getLogger(MiraStarter.class);

  private MiraStarter() {
  }

  /**
   * 启动器方法
   *
   * @param clz 启动目标类
   */
  public static void run(Class<?> clz) {
    // 加载配置管理器并检查配置文件
    ConfigManager.check();
    // 检查并加载事件处理器列表
    ProcessorManager.prepare(clz);
    // 初始化Bot
    BotInstance botInstance = new BotInstance();
    // 注册事件处理器
    ProcessorManager.registerProcessor(botInstance);
    // 初始化线程池
    ThreadPoolManger.prepare();
    // 初始化API返回管理器清理线程
    ResponseManager.prepare();
    // 启动WS连接
    botInstance.connect();
  }

}

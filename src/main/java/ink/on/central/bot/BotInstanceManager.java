package ink.on.central.bot;

import org.java_websocket.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * BOT连接实例管理器
 * <p>
 * Create Time: 2024-04-18 Last Update:
 *
 * @author BGLuminous
 * @since 1.3.0
 */
public class BotInstanceManager {
  private static final Logger log = LoggerFactory.getLogger(BotInstanceManager.class);

  /** Bot Socket Map */
  private final Map<String, WebSocket> socketMap = new HashMap<>();

  /**
   * 注册Bot Socket
   *
   * @param botId  Bot ID
   * @param socket Bot Socket
   */
  public static void regSocket(String botId, WebSocket socket) {
    log.debug("正在注册Bot Socket! ID: {}...", botId);
    Holder.INSTANCE.socketMap.put(botId, socket);
  }

  /**
   * 获取Bot Socket
   *
   * @param botId Bot ID
   *
   * @return Bot Socket
   */
  public static WebSocket getSocket(String botId) {
    return Holder.INSTANCE.socketMap.get(botId);
  }

  /**
   * 删除Bot Socket
   *
   * @param botId Bot ID
   */
  public static void remove(String botId) {
    log.debug("正在删除Bot Instance! ID: {}...", botId);
    Holder.INSTANCE.socketMap.remove(botId);
  }

  /**
   * 获取Bot Socket List
   *
   * @return Bot Socket List
   */
  public static Collection<WebSocket> getList() {
    log.debug("正在获取Bot Instance List...");
    return Holder.INSTANCE.socketMap.values();
  }

  /** 内部静态类 */
  private static class Holder {
    private static final BotInstanceManager INSTANCE = new BotInstanceManager();
  }

}

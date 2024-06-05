package ink.on.central.bot;

import com.fasterxml.jackson.core.JsonProcessingException;
import ink.on.central.bot.entity.config.BotConfig;
import ink.on.central.bot.entity.event.AnalyzedEvent;
import ink.on.central.bot.exception.MiraBotException;
import ink.on.central.bot.utils.EventUtil;
import lombok.Getter;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.server.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * BOT连接实例
 * <p>
 * Create Time: 2024-04-07 Last Update: 2024-04-18
 *
 * @author BGLuminous
 * @since 1.0.0
 */
public class BotInstance {
  private static final Logger log = LoggerFactory.getLogger(BotInstance.class);

  /** socket 客户端 */
  @Getter
  private BotSocketClient client = null;
  /** socket 服务器 */
  @Getter
  private BotSocketServer server = null;

  /** 配置信息 */
  private final BotConfig config = ConfigManager.getConfig();

  /** 构造函数 */
  public BotInstance() {
    if (config.getPort() != null) {
      server = new BotSocketServer(new InetSocketAddress(config.getPort()));
    }
    if (config.getUrl() != null) {
      client = new BotSocketClient(URI.create(config.getUrl()));
      // 注入 Token
      if (config.getToken() != null) {
        client.addHeader("Authorization", "Bearer %s".formatted(config.getToken()));
      }
    }
  }

  /** 启动BOT */
  public void connect() {
    if (client != null) {
      client.connect();
    }
    if (server != null) {
      server.start();
    }
  }

  /** Bot Socket 客户端 */
  public class BotSocketClient extends WebSocketClient {

    /** 已经尝试的重连次数 */
    private Integer retriedTimes = -1;
    /** 是否从重连中恢复 */
    private boolean isReconnect = false;
    /** 重连钩子 */
    private final List<Runnable> reconnectHook = new ArrayList<>();
    /** 断开钩子 */
    private final List<Runnable> closeHook = new ArrayList<>();

    /**
     * 构造函数
     *
     * @param serverUri 连接地址
     */
    public BotSocketClient(URI serverUri) {
      super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
      log.info("连接到到Bot连接 ~");
      BotInstanceManager.regSocket("default", this);
      retriedTimes = 0;
      if (this.isReconnect) {
        reconnectHook.forEach(Runnable::run);
        isReconnect = false;
      }
    }

    @Override
    public void onMessage(String data) {
      onEvent(data, this.getConnection());
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
      closeHook.forEach(Runnable::run);
      processClose(code, reason, remote);
    }

    @Override
    public void onError(Exception ex) {
      log.warn("Socket处理过程出错! 错误信息:{}", ex.getMessage());
    }

    public void addReconnectHook(Runnable runnable) {
      reconnectHook.add(runnable);
    }

    public void addCloseHook(Runnable runnable) {
      closeHook.add(runnable);
    }

    /**
     * 处理关闭事件和重连逻辑
     *
     * @param code   返回代码
     * @param reason 关闭原因
     * @param remote 是否是远程关闭
     */
    private void processClose(int code, String reason, boolean remote) {
      //从 socket 管理器中删除实例
      BotInstanceManager.remove("default");
      retriedTimes++;
      log.warn("连接关闭! code:{} reason:{} 来源:{}", code, reason, remote ? "远程主机" : "本机");
      // 关闭所有正在处理中的事件
      ThreadPoolManger.cleanAndReinit();
      // 重新初始化 API调用返回管理器的清理线程
      ResponseManager.prepare();
      if (
        Boolean.TRUE.equals(config.getReconnect())
          && retriedTimes <= config.getReconnectTryTimes()
      ) {
        log.info("{}秒后开始重连...", config.getReconnectDelayTime());
        try {
          Thread.sleep(config.getReconnectDelayTime() * 1000L);
        } catch (InterruptedException ex) {
          log.error("线程睡眠过程发生错误! 错误信息:{}", ex.getMessage());
          Thread.currentThread().interrupt();
        }
        client.close();
        if (!client.isOpen()) {
          isReconnect = true;
          new Thread(client::reconnect).start();
        }
      }
    }

  }

  /** Bot Socket Server */
  public class BotSocketServer extends WebSocketServer {

    public BotSocketServer(InetSocketAddress address) {
      super(address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
      String botId = handshake.getFieldValue("X-Self-ID");
      log.info("接收到Bot {}连接 ~~", botId);
      conn.setAttachment(botId);
      // 如果没有加密Token则直接结束open过程
      if (config.getToken() == null) {
        return;
      }
      // 验证Token
      String token = handshake.getFieldValue("Authorization");
      if (token == null || !token.equals("Bearer %s".formatted(config.getToken()))) {
        conn.close(-1, "Token Error");
      }
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
      BotInstanceManager.remove(conn.getAttachment());
      log.warn(
        "连接 {} 关闭~ code:{} reason:{} 来源:{}",
        conn.getRemoteSocketAddress(), code, reason, remote ? "远程主机" : "本机"
      );
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
      onEvent(message, conn);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
      log.warn(
        "Socket服务器处理过程出错! 来源:{} 错误信息:{}",
        conn.getResourceDescriptor(), ex.getMessage()
      );
    }

    @Override
    public void onStart() {
      log.info("开始监听端口 {}~", config.getPort());
    }
  }

  /**
   * 处理事件逻辑
   *
   * @param data        事件Json
   * @param currentConn 当前连接
   */
  private void onEvent(String data, WebSocket currentConn) {
    ThreadPoolManger.push(() -> {
      Long receivedTime = System.currentTimeMillis();
      log.debug("接收到事件Json: {}", data);
      try {
        AnalyzedEvent analyzedEvent = EventUtil.analyzer(data);
        // 处理API调用返回信息
        if (Objects.equals(analyzedEvent.getEventType(), "retcode")) {
          ResponseManager.pushResponse(analyzedEvent.getResponseId(), analyzedEvent.getData());
          log.trace("解析到API返回实体: {}", analyzedEvent);
          return;
        }
        // 处理接收事件信息
        log.debug("解析到事件实体: {}", analyzedEvent);
        ListenerManager.pushEvent(analyzedEvent, receivedTime, currentConn);
      } catch (JsonProcessingException | MiraBotException ex) {
        if (ex instanceof MiraBotException) {
          log.error(ex.getMessage(), ex);
          return;
        }
        log.error(
          "解析事件Json失败... 错误信息:{}", ex.getMessage().replace("\n", "")
        );
      }
    });
  }

}

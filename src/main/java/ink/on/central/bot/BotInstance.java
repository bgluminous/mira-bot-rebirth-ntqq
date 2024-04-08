package ink.on.central.bot;

import com.fasterxml.jackson.core.JsonProcessingException;
import ink.on.central.bot.entity.config.BotConfig;
import ink.on.central.bot.entity.event.AnalyzedEvent;
import ink.on.central.bot.exception.MiraBotException;
import ink.on.central.bot.utils.EventUtil;
import ink.on.central.bot.utils.SenderUtil;
import lombok.Getter;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Objects;

/**
 * BOT连接实例
 * <p>
 * Create Time: 2024-04-07 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
public class BotInstance {
  private static final Logger log = LoggerFactory.getLogger(BotInstance.class);

  /** socket连接 */
  @Getter
  private final BotSocketClient connect;
  /** 动作发送器 */
  @Getter
  private final SenderUtil sender;

  /** 配置信息 */
  private final BotConfig config = ConfigManager.getConfig();

  /** 构造函数 */
  public BotInstance() {
    connect = new BotSocketClient(URI.create(config.getUrl()));
    // 注入 Token
    if (config.getToken() != null) {
      connect.addHeader("Authorization", "Bearer %s".formatted(config.getToken()));
    }
    sender = new SenderUtil(this);
  }

  /** 启动BOT */
  public void connect() {
    connect.connect();
  }


  /** Bot Socket 客户端 */
  public class BotSocketClient extends WebSocketClient {

    /** 已经尝试的重连次数 */
    private Integer retriedTimes = -1;

    /**
     * 构造函数
     *
     * @param serverUri 连接地址
     */
    public BotSocketClient(URI serverUri) {
      super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakeData) {
      log.info("连接成功~~");
      retriedTimes = 0;
    }

    @Override
    public void onMessage(String data) {
      onEvent(data);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
      processClose(code, reason, remote);
    }

    @Override
    public void onError(Exception ex) {
      log.warn("Socket处理过程出错! 错误信息:{}", ex.getMessage());
    }

    /**
     * 处理事件逻辑
     *
     * @param data 事件Json
     */
    private void onEvent(String data) {
      Long receivedTime = System.currentTimeMillis();
      log.trace("接收到事件Json: {}", data);
      try {
        AnalyzedEvent analyzedEvent = EventUtil.analyzer(data);
        if (Objects.equals(analyzedEvent.getEventType(), "retcode")) {
          // 暂不处理retcode类型
          log.debug("{}", analyzedEvent);
          return;
        }
        log.trace("解析到事件实体: {}", analyzedEvent);
        ProcessorManager.pushEvent(analyzedEvent, receivedTime);
      } catch (JsonProcessingException | MiraBotException ex) {
        if (ex instanceof MiraBotException) {
          log.error(ex.getMessage(), ex);
          return;
        }
        log.error(
          "解析事件Json失败... 错误信息:{}", ex.getMessage().replace("\n", "")
        );
      }
    }

    /**
     * 处理关闭事件,和重连逻辑
     *
     * @param code   返回代码
     * @param reason 关闭原因
     * @param remote 是否是远程关闭
     */
    private void processClose(int code, String reason, boolean remote) {
      retriedTimes++;
      log.warn("连接已关闭! code:{} reason:{} 来源:{}", code, reason, remote ? "远程主机" : "本机");
      if (
        Boolean.TRUE.equals(config.getReconnect())
          && retriedTimes <= config.getReconnectTryTimes()
      ) {
        log.info("{}秒后开始重连...", config.getReconnectDelayTime());
        try {
          Thread.sleep(config.getReconnectDelayTime() * 1000L);
        } catch (InterruptedException ex) {
          Thread.currentThread().interrupt();
          log.error("线程睡眠过程发生错误! 错误信息:{}", ex.getMessage());
        }
        connect.close();
        if (!connect.isOpen()) {
          new Thread(connect::reconnect).start();
        }
      }
    }

  }

}

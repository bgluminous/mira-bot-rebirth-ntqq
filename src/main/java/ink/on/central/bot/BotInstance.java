package ink.on.central.bot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.heavenark.infrastructure.log.LogFactory;
import com.heavenark.infrastructure.log.Logger;
import ink.on.central.bot.entity.event.AnalyzedEvent;
import ink.on.central.bot.entity.event.message.GroupMessageEvent;
import ink.on.central.bot.exception.MiraBotException;
import ink.on.central.bot.trys.CustomGroupMsgProcessor;
import ink.on.central.bot.utils.EventEntityUtil;
import lombok.Getter;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

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
  private static final Logger LOGGER = LogFactory.getLogger(BotInstance.class);

  /** Bot正向docket地址 */
  private final String socketUrl;
  /** Token TODO: 待实现 */
  @SuppressWarnings("all")
  private final String token;
  /** 是否自动重连 */
  private final boolean reconnect;

  /** socket连接 */
  @Getter
  private WebSocketClient connect;

  /**
   * 构造函数
   *
   * @param reconnect 是否自动重连
   * @param socketUrl 监听地址
   * @param token     令牌
   */
  public BotInstance(boolean reconnect, String socketUrl, String token) {
    this.reconnect = reconnect;
    this.socketUrl = socketUrl;
    this.token = token;
  }

  /**
   * 启动BOT
   */
  public void boot() {
    CustomGroupMsgProcessor processor = new CustomGroupMsgProcessor(this);
    connect = new WebSocketClient(URI.create(socketUrl)) {
      @Override
      public void onOpen(ServerHandshake handshakeData) {
        LOGGER.inf("新连接已打开");
      }

      @Override
      public void onMessage(String data) {
        Long receivedTime = System.currentTimeMillis();
        LOGGER.ver("Received Event Json: %s".formatted(data));
        try {
          AnalyzedEvent analyzedEvent = EventEntityUtil.analyzer(data);
          if (Objects.equals(analyzedEvent.getEventType(), "return")) {
            // 其他事件暂不处理
            LOGGER.deb(analyzedEvent);
            return;
          }
          if (
            Objects.equals(analyzedEvent.getEventType(), "message")
              && Objects.equals(analyzedEvent.getSubType(), "group")
          ) {
            processor.process((GroupMessageEvent) analyzedEvent.getData(), receivedTime);
          }
          LOGGER.ver("解析到事件实体: %s".formatted(analyzedEvent));
        } catch (JsonProcessingException | MiraBotException ex) {
          if (ex instanceof MiraBotException) {
            LOGGER.err(ex);
            return;
          }
          LOGGER.err(
            "解析事件Json失败... [%s]".formatted(ex.getMessage().replace("\n", ""))
          );
        }
      }

      @Override
      public void onClose(int code, String reason, boolean remote) {
        LOGGER.war("连接已关闭:[%s] 来源:[%s]".formatted(reason, remote ? "远程主机" : "本机"));
        if (reconnect) {
          this.reconnect();
        }
      }

      @Override
      public void onError(Exception ex) {
        LOGGER.war("Socket处理过程出错! 错误信息: [%s]".formatted(ex.getMessage()));
      }

    };
    connect.connect();
  }

}

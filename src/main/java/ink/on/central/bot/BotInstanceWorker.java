package ink.on.central.bot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.heavenark.infrastructure.log.LogFactory;
import com.heavenark.infrastructure.log.Logger;
import ink.on.central.bot.exception.MiraBotException;
import ink.on.central.bot.utils.EventEntityUtil;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class BotInstanceWorker extends WebSocketClient {
  private static final Logger LOGGER = LogFactory.getLogger(BotInstanceWorker.class);

  public BotInstanceWorker(URI serverUri) {
    super(serverUri);
  }

  @Override
  public void onOpen(ServerHandshake handshakeData) {
    LOGGER.inf("新连接已打开");
  }

  @Override
  public void onMessage(String data) {
    LOGGER.ver("Received Event Json: %s".formatted(data));
    try {
      Object eventEntity = EventEntityUtil.analyzer(data);
      LOGGER.ver("解析到事件实体: %s".formatted(eventEntity));
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
  }

  @Override
  public void onError(Exception ex) {
    LOGGER.err(ex);
  }

}

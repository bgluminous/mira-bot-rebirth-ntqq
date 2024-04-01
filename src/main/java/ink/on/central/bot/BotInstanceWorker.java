package ink.on.central.bot;

import ink.on.central.bot.adapter.EventAdapter;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class BotInstanceWorker extends WebSocketClient {

  public BotInstanceWorker(URI serverUri) {
    super(serverUri);
  }

  @Override
  public void onOpen(ServerHandshake handshakedata) {
    System.out.println("新连接已打开");
  }

  @Override
  public void onMessage(String message) {
    EventAdapter.analyzer(message);
  }

  @Override
  public void onClose(int code, String reason, boolean remote) {
    System.out.println("连接已关闭");
  }

  @Override
  public void onError(Exception ex) {
    ex.printStackTrace();
  }

}

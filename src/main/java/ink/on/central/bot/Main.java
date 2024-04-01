package ink.on.central.bot;

import java.net.URI;

public class Main {
  private static final String BOT_WS_URL = "ws://host.mmd.ink:4000/";

  @SuppressWarnings("all")
  public static void main(String[] args) {
    try {
      new BotInstanceWorker(new URI(BOT_WS_URL)).connect();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}

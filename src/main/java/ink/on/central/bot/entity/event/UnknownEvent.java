package ink.on.central.bot.entity.event;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UnknownEvent {
  private String raw;
}

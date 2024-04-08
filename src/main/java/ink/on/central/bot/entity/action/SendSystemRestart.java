package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 重启 OneBot 实现载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#set_restart-%E9%87%8D%E5%90%AF-onebot-%E5%AE%9E%E7%8E%B0">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendSystemRestart {
  /** 要延迟的毫秒数，如果默认情况下无法重启，可以尝试设置延迟为 2000 左右 */
  private Long delay;
}

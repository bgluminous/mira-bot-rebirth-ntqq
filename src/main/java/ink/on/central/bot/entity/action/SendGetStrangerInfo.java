package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 获取陌生人信息载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#get_stranger_info-%E8%8E%B7%E5%8F%96%E9%99%8C%E7%94%9F%E4%BA%BA%E4%BF%A1%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGetStrangerInfo {
  /** QQ 号 */
  private Long userId;
  /** 是否不使用缓存（使用缓存可能更新不及时，但响应更快） */
  private Boolean noCache;
}

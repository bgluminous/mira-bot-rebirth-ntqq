package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 获取图片载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#get_image-%E8%8E%B7%E5%8F%96%E5%9B%BE%E7%89%87">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGetImage {
  /** 收到的图片文件名（消息段的 file 参数），如 6B4DE3DFD1BD271E3297859D41C530F5.jpg */
  private String file;
}

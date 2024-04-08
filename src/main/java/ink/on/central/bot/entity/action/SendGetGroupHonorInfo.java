package ink.on.central.bot.entity.action;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 获取群荣誉信息载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#get_group_honor_info-%E8%8E%B7%E5%8F%96%E7%BE%A4%E8%8D%A3%E8%AA%89%E4%BF%A1%E6%81%AF">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class SendGetGroupHonorInfo {
  /** 群号 */
  private Long groupId;
  /**
   * 要获取的群荣誉类型，
   * 可传入 talkative performer legend strong_newbie emotion以分别获取单个类型的群荣誉数据，
   * 或传入 all 获取所有数据
   */
  private String type;
}

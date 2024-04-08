package ink.on.central.bot.entity.response;

import ink.on.central.bot.entity.response.pojo.GroupHonorCurrentTalkative;
import ink.on.central.bot.entity.response.pojo.GroupHonorOtherInfo;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 获取群荣誉信息返回实体
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
public class ResponseGetGroupHonorInfo {
  /** 群号 */
  private Long groupId;
  /** 当前龙王，仅 type 为 talkative 或 all 时有数据 */
  private GroupHonorCurrentTalkative currentTalkative;
  /** 历史龙王，仅 type 为 talkative 或 all 时有数据 */
  private GroupHonorOtherInfo[] talkativeList;
  /** 群聊之火，仅 type 为 performer 或 all 时有数据 */
  private GroupHonorOtherInfo[] performList;
  /** 群聊炽焰，仅 type 为 legend 或 all 时有数据 */
  private GroupHonorOtherInfo[] legendList;
  /** 冒尖小春笋，仅 type 为 strong_newbie 或 all 时有数据 */
  private GroupHonorOtherInfo[] strongNewbieList;
  /** 快乐之源，仅 type 为 emotion 或 all 时有数据 */
  private GroupHonorOtherInfo[] emotionList;
}

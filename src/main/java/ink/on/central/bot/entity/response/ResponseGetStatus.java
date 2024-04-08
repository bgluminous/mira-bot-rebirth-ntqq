package ink.on.central.bot.entity.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 获取运行状态返回实体
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#get_status-%E8%8E%B7%E5%8F%96%E8%BF%90%E8%A1%8C%E7%8A%B6%E6%80%81">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@Accessors(chain = true)
@Data
public class ResponseGetStatus {
  /** 当前 QQ 在线，null 表示无法查询到在线状态 */
  private Boolean online;
  /** 状态符合预期，意味着各模块正常运行、功能正常，且 QQ 在线 */
  private Boolean good;
}

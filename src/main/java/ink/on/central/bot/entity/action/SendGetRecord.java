package ink.on.central.bot.entity.action;

/**
 * 获取语音载体 实体类
 * <br>
 * <a href="https://github.com/botuniverse/onebot-11/blob/master/api/public.md#get_record-%E8%8E%B7%E5%8F%96%E8%AF%AD%E9%9F%B3">查看文档</a>
 * <br>
 * Create Time: 2024-04-08 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class SendGetRecord {
  /** 收到的语音文件名（消息段的 file 参数），如 0B38145AA44505000B38145AA4450500.silk */
  private String file;
  /** 要转换到的格式，目前支持 mp3、amr、wma、m4a、spx、ogg、wav、flac */
  private String outFormat;
}

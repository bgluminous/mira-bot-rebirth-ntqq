package ink.on.central.bot.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import java.util.Map;

/**
 * jackson工具类
 * <p>
 * Create Time: 2024-03-29 Last Update:
 *
 * @author BGLuminous
 * @since 1.0.0
 */
public class JacksonUtil {

  private final ObjectMapper objectMapper;

  private JacksonUtil() {
    objectMapper = new ObjectMapper();
    // 驼峰转下划线
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
  }

  /**
   * 获取json中某个节点的map
   *
   * @param jsonStr json字符串
   *
   * @return map
   *
   * @throws JsonProcessingException json解析异常
   */
  public static Map<String, Object> getNodeMap(String jsonStr) throws JsonProcessingException {
    return Holder.INSTANCE.objectMapper.readValue(jsonStr, new TypeReference<>() {
    });
  }

  /**
   * json字符串转对象
   *
   * @param json      json字符串
   * @param typeClass 对象类型
   *
   * @return 对象
   *
   * @throws JsonProcessingException json解析异常
   */
  public static <T> T parse(String json, Class<T> typeClass) throws JsonProcessingException {
    return Holder.INSTANCE.objectMapper.readValue(json, typeClass);
  }

  /**
   * 静态内部类
   */
  private static class Holder {
    private static final JacksonUtil INSTANCE = new JacksonUtil();
  }
}

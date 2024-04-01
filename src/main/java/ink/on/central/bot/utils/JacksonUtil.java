package ink.on.central.bot.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import java.util.Map;

public class JacksonUtil {

  private final ObjectMapper objectMapper;

  private JacksonUtil() {
    objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
  }

  public static Map<String, Object> getNodeMap(String jsonStr) throws JsonProcessingException {
    return Holder.INSTANCE.objectMapper.readValue(jsonStr, new TypeReference<>() {
    });
  }

  public static <T> T parse(String json, Class<T> typeClass) throws JsonProcessingException {
    return Holder.INSTANCE.objectMapper.readValue(json, typeClass);
  }

  private static class Holder {
    private static final JacksonUtil INSTANCE = new JacksonUtil();
  }
}

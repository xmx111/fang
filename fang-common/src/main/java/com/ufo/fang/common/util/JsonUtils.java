package com.ufo.fang.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/2/26
 */
public class JsonUtils {

    public static final ObjectMapper JSON_MAPPER = newObjectMapper();

    public JsonUtils() {
    }

    private static ObjectMapper newObjectMapper() {
        ObjectMapper result = new ObjectMapper();
        result.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        result.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        result.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        result.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        result.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        result.setDateFormat(sdf);
        return result;
    }

    /**
     * Json换对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String json, Class<T> clazz){
        if (!StringUtils.startsWith(json, "{"))
            return null;
        try {
            return JSON_MAPPER.readValue(json, clazz);
        } catch (IOException e){
            return null;
        }
    }

    /**
     * Json转List
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String json, Class<T> clazz){
        if (!StringUtils.startsWith(json, "["))
            return null;
        try {
            return (List<T>) JSON_MAPPER.readValue(json, JSON_MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e){
            return null;
        }
    }

    /**
     * Json转为Map
     * @param json
     * @param mapClass
     * @param keyClass
     * @param valueClass
     * @return
     * @throws IOException
     */
    public static <T> T jsonToMap(String json, Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
        if(json == null) {
            return null;
        } else {
            try {
                return JSON_MAPPER.readValue(json, JSON_MAPPER.getTypeFactory().constructMapType(mapClass, keyClass, valueClass));
            } catch (IOException var5) {
                throw new IllegalStateException(var5);
            }
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static String writeValueAsString(Object value) {
        try {
            return value == null ? null:JSON_MAPPER.writeValueAsString(value);
        } catch (IOException var2) {
            throw new IllegalArgumentException(var2);
        }
    }

    public static <T> T readValue(String content) {
        if(StringUtils.isEmpty(content)) {
            return null;
        } else {
            char ch = content.charAt(0);

            try {
                return ch == 91?(T)JSON_MAPPER.readValue(content, List.class):(T)JSON_MAPPER.readValue(content, Map.class);
            } catch (IOException var3) {
                throw new IllegalStateException(var3);
            }
        }
    }

    public static <T> T readValue(String content, Class<T> type) {
        if(content == null) {
            return null;
        } else {
            try {
                return JSON_MAPPER.readValue(content, type);
            } catch (IOException var3) {
                throw new IllegalStateException(var3);
            }
        }
    }

    public static <T> T readValue(byte[] content, Class<T> type) {
        if(content == null) {
            return null;
        } else {
            try {
                return JSON_MAPPER.readValue(content, type);
            } catch (IOException var3) {
                throw new IllegalStateException(var3);
            }
        }
    }

    public static Map<String, Object> toMap(Object value) throws IllegalArgumentException {
        return (Map)convertValue(value, Map.class);
    }

    public static <T> T convertValue(Object value, Class<T> clazz) throws IllegalArgumentException {
        if(StringUtils.isEmpty(value)) {
            return null;
        } else {
            try {
                if(value instanceof String) {
                    value = JSON_MAPPER.readTree((String)value);
                }
                return JSON_MAPPER.convertValue(value, clazz);
            } catch (IOException var3) {
                throw new IllegalArgumentException(var3);
            }
        }
    }

    public static <T> List<T> readListValue(String content, Class<T> elementClass) {
        if(StringUtils.isEmpty(content)) {
            return null;
        } else {
            try {
                return (List)JSON_MAPPER.readValue(content, JSON_MAPPER.getTypeFactory().constructCollectionType(List.class, elementClass));
            } catch (IOException var3) {
                throw new IllegalStateException(var3);
            }
        }
    }
}

package com.mingbao.easy.tool;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * GSON工具类
 *
 * @author peter.bao
 * @since 2023/12/8
 */
public class GsonUtil {

    private static final Gson GSON;

    private static final Type MAP_LIST_TYPE;

    private GsonUtil() {

    }

    static {
        GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        MAP_LIST_TYPE = new TypeToken<List<Map<String, Object>>>(){}.getType();
    }

    /**
     * 对象转JSON字符串
     */
    public static String toJsonString(Object o) {
        return GSON.toJson(o);
    }

    /**
     * JSON字符串转对象
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }

    /**
     * JsonObject转对象
     */
    public static <T> T toObject(JsonObject jsonObject, Class<T> clazz) {
        return GSON.fromJson(jsonObject, clazz);
    }

    /**
     * JSON字符串转List
     */
    public static <T> List<T> toList(String json, Class<T> clazz) {
        return GSON.fromJson(json, TypeToken.getParameterized(List.class, clazz).getType());
    }

    /**
     * JsonArray转List
     */
    public static <T> List<T> toList(JsonArray jsonArray, Class<T> clazz) {
        return GSON.fromJson(jsonArray, TypeToken.getParameterized(List.class, clazz).getType());
    }

    /**
     * JSON字符串转Map
     */
    public static <T> Map<String, T> toMap(String json, Class<T> clazz) {
        return GSON.fromJson(json, TypeToken.getParameterized(Map.class, String.class, clazz).getType());
    }

    /**
     * 对象转Map
     */
    public static <T> Map<String, T> toMap(Object o, Class<T> clazz) {
        return GSON.fromJson(GSON.toJsonTree(o), TypeToken.getParameterized(Map.class, String.class, clazz).getType());
    }

    /**
     * 对象List转MapList
     */
    public static List<Map<String, Object>> toMapList(List<?> list) {
        return GSON.fromJson(GSON.toJsonTree(list), MAP_LIST_TYPE);
    }

    /**
     * List列表转JsonArray
     */
    public static JsonArray toJsonArray(List<?> list) {
        return GSON.toJsonTree(list).getAsJsonArray();
    }
}

package io.github.maidoubaobao.easy.tool;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * GSON工具类
 *
 * @author ming
 * @since 2023/12/8
 */
public class GsonUtil {

    static final Gson GSON;

    private GsonUtil() {

    }

    static {
        GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    /**
     * 对象转 JSON 字符串
     *
     * @param o 待转换的对象
     * @return 转换后的 json 字符串
     */
    public static String toJsonString(Object o) {
        return GSON.toJson(o);
    }

    /**
     * JSON 字符串转对象
     *
     * @param json  待转换的 json 字符串
     * @param clazz 自定义转换后的类型
     * @param <T>   泛型，对应入参 clazz 的类型
     * @return 转换后的对象
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }

    /**
     * JSON 字符串转 json 对象
     *
     * @param json 待转换的 json 字符串
     * @return 转换后的 json 对象
     */
    public static JsonObject toJsonObject(String json) {
        return toObject(json, JsonObject.class);
    }

    /**
     * JsonObject 转对象
     *
     * @param jsonObject 待转换的 json 对象
     * @param clazz      自定义转换后的类型
     * @param <T>        泛型，对应入参 clazz 的类型
     * @return 转换后的对象
     */
    public static <T> T toObject(JsonObject jsonObject, Class<T> clazz) {
        return GSON.fromJson(jsonObject, clazz);
    }

    /**
     * JSON 字符串转 List
     *
     * @param json  待转换的 json 字符串
     * @param clazz 自定义转换后 List 中元素的类型
     * @param <T>   泛型，对应入参 clazz 的类型
     * @return 转换后的 List 对象
     */
    public static <T> List<T> toList(String json, Class<T> clazz) {
        return GSON.fromJson(json, TypeToken.getParameterized(List.class, clazz).getType());
    }

    /**
     * JsonArray 转 List
     *
     * @param jsonArray 待转换的 json 集合对象
     * @param clazz     自定义转换后 List 中元素的类型
     * @param <T>       泛型，对应入参 clazz 的类型
     * @return 转换后的 List 对象
     */
    public static <T> List<T> toList(JsonArray jsonArray, Class<T> clazz) {
        return GSON.fromJson(jsonArray, TypeToken.getParameterized(List.class, clazz).getType());
    }

    /**
     * List 列表转 JsonArray
     *
     * @param list 待转换的 List 对象
     * @return 转换后的 json 集合对象
     */
    public static JsonArray toJsonArray(List<?> list) {
        return GSON.toJsonTree(list).getAsJsonArray();
    }
}

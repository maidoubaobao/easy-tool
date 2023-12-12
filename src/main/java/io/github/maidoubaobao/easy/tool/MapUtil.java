package io.github.maidoubaobao.easy.tool;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Map工具类
 *
 * @author ming
 * @since 2023/12/12
 */
public class MapUtil {

    private static final Type MAP_LIST_TYPE;

    private MapUtil() {

    }

    static {
        MAP_LIST_TYPE = new TypeToken<List<Map<String, Object>>>() {
        }.getType();
    }

    /**
     * JSON 字符串转 Map
     *
     * @param json  待转换的 json 字符串
     * @param clazz 自定义转换后 Map 中 value 的类型
     * @param <T>   泛型，对应入参 clazz 的类型
     * @return 转换后的 Map 对象
     */
    public static <T> Map<String, T> toMap(String json, Class<T> clazz) {
        return GsonUtil.GSON.fromJson(json, TypeToken.getParameterized(Map.class, String.class, clazz).getType());
    }

    /**
     * JSON 字符串转 Map
     *
     * @param json 待转换的 json 字符串
     * @return 转换后的 Map 对象
     */
    public static Map<String, Object> toMap(String json) {
        return toMap(json, Object.class);
    }

    /**
     * 对象转 Map
     * 注意：Collection 子类不可转
     *
     * @param o     待转换的对象
     * @param clazz 自定义转换后 Map 中 value 的类型
     * @param <T>   泛型，对应入参 clazz 的类型
     * @return 转换后的 Map 对象
     */
    public static <T> Map<String, T> toMap(Object o, Class<T> clazz) {
        return GsonUtil.GSON.fromJson(GsonUtil.GSON.toJsonTree(o), TypeToken.getParameterized(Map.class, String.class, clazz).getType());
    }

    /**
     * 对象转 Map
     * 注意：Collection 子类不可转
     *
     * @param o 待转换的对象
     * @return 转换后的 Map 对象
     */
    public static Map<String, Object> toMap(Object o) {
        return toMap(o, Object.class);
    }

    /**
     * 对象 List 转 MapList
     *
     * @param list 待转换的 List
     * @return 转换后的 List 对象
     */
    public static List<Map<String, Object>> toMapList(List<?> list) {
        return GsonUtil.GSON.fromJson(GsonUtil.GSON.toJsonTree(list), MAP_LIST_TYPE);
    }
}

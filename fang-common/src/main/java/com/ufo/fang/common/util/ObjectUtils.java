package com.ufo.fang.common.util;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/12
 */
public class ObjectUtils {

    public static Long toLong(Object value) {
        if(value == null) {
            return null;
        } else if(value instanceof Long) {
            return (Long)value;
        } else if(value instanceof Number) {
            return Long.valueOf(((Number)value).longValue());
        } else {
            String v = value.toString();
            return v.isEmpty()?null:Long.valueOf(Long.parseLong(v));
        }
    }
}

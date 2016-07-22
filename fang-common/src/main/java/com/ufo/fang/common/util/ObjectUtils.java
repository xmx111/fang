package com.ufo.fang.common.util;

import java.lang.reflect.Field;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/12
 */
public class ObjectUtils {



    public static <T> T getFieldValue(Object bean, String fieldName) {
        if(bean == null) {
            return null;
        } else {
            Class clazz = bean.getClass();

            try {
                Field e = getField(clazz, fieldName);
                if(!e.isAccessible()) {
                    e.setAccessible(true);
                }

                return (T)e.get(bean);
            } catch (IllegalAccessException var4) {
                throw new IllegalArgumentException("在 " + bean + " 中找不到field：" + fieldName, var4);
            }
        }
    }

    private static Field getField(Class<?> clazz, String fieldName) throws IllegalArgumentException {
        if(fieldName != null && !fieldName.isEmpty()) {
            if(clazz.isInterface()) {
                throw new IllegalArgumentException(clazz + " not found fieldName=" + fieldName);
            } else {
                Field[] var5;
                int var4 = (var5 = clazz.getDeclaredFields()).length;

                for(int var3 = 0; var3 < var4; ++var3) {
                    Field superClass = var5[var3];
                    if(superClass.getName().equals(fieldName)) {
                        return superClass;
                    }
                }

                Class var6 = clazz.getSuperclass();
                if(var6 != null && !var6.isInterface()) {
                    return getField(var6, fieldName);
                } else {
                    throw new IllegalArgumentException(clazz + " not found fieldName=" + fieldName);
                }
            }
        } else {
            throw new IllegalArgumentException(clazz + " not found fieldName=" + fieldName);
        }
    }

    public static Integer toInteger(Object value) {
        return value == null?null:(value instanceof Integer?(Integer)value:(value instanceof Number?Integer.valueOf(((Number)value).intValue()):Integer.valueOf(Integer.parseInt(value.toString()))));
    }

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

    public static boolean equals(Object obj1, Object obj2) {
        return obj1 == obj2?true:(obj1 != null && obj2 != null?obj1.equals(obj2):false);
    }

    public static boolean equals(byte[] arr1, byte[] arr2) {
        if(arr1 == arr2) {
            return true;
        } else if(arr1 != null && arr2 != null && arr1.length == arr2.length) {
            for(int i = 0; i < arr1.length; ++i) {
                if(arr1[i] != arr2[i]) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public static int compare(Object obj1, Object obj2) {
        return obj1 == obj2?0:(obj1 == null?1:(obj2 == null?-1:(obj1 instanceof Comparable?((Comparable)obj1).compareTo(obj2):(obj2 instanceof Comparable?-((Comparable)obj2).compareTo(obj1):obj1.toString().compareTo(obj2.toString())))));
    }

    public static boolean isTrue(Boolean value) {
        return Boolean.TRUE.equals(value);
    }
}

package com.ufo.fang.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/***
 * Describe
 *
 * @author hekang
 * @version $Id:$
 * @created 2016/3/18
 */
public class InvokeUtils {

    private static Logger logger = LoggerFactory.getLogger(InvokeUtils.class);

    private static final Class<?>[] EMPTY_CLASS_ARRAY = new Class<?>[0];

    private static final String PREFIX_GET = "get";
    private static final String PREFIX_SET = "set";

    public static Object invokeMethod(Object object, String methodName,
                                      Object... args) throws NoSuchMethodException {
        Class<?>[] types = null;
        if (args != null) {
            types = new Class<?>[args.length];
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                if (arg == null) {
                    types[i] = null;
                } else {
                    types[i] = args[i].getClass();
                }
            }
        }
        return invokeMethod(object, methodName, args, types);
    }

    public static Object invokeMethod(Object obj, String methodName,
                                      Object[] args, Class<?>[] argTypes) throws NoSuchMethodException,
            IllegalArgumentException {
        Assert.notNull(obj);
        Assert.hasText(methodName);

        argumentSanityCheck(args, argTypes);

        Class<?> clazz = obj.getClass();
        Method method = findMatchingMethod(clazz, methodName, argTypes);
        if (method == null) {
            throw new NoSuchMethodException(String.format(
                    "No such method: %s.%s(%s)", clazz.getSimpleName(),
                    methodName, org.apache.commons.lang.StringUtils.join(argTypes, ", ")));
        }

        if (!Modifier.isPublic(method.getModifiers()) ||
                !Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
            method.setAccessible(true);
        }

        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            ReflectionUtils.handleReflectionException(e);
        }
        return null;
    }

    public static Object invokeMethod(Class<?> clazz, String methodName,
                                      Object... args) throws NoSuchMethodException {
        Class<?>[] types = null;
        if (args != null) {
            types = new Class<?>[args.length];
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                if (arg == null) {
                    types[i] = null;
                } else {
                    types[i] = args[i].getClass();
                }
            }
        }
        return invokeMethod(clazz, methodName, args, types);
    }

    public static Object invokeMethod(Class<?> clazz, String methodName,
                                      Object[] args, Class<?>[] argTypes) throws NoSuchMethodException,
            IllegalArgumentException {
        Assert.hasText(methodName);
        argumentSanityCheck(args, argTypes);

        Method method = findMatchingMethod(clazz, methodName, argTypes);
        if (method == null) {
            throw new NoSuchMethodException(String.format(
                    "No such method: %s.%s(%s)", clazz.getSimpleName(),
                    methodName, org.apache.commons.lang.StringUtils.join(argTypes, ", ")));
        }

        Object obj = null;
        if (!Modifier.isStatic(method.getModifiers())) {
            try {
                obj = clazz.newInstance();
            } catch (Exception e) {
                ReflectionUtils.handleReflectionException(e);
            }
        }

        if (!Modifier.isPublic(method.getModifiers()) ||
                !Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
            method.setAccessible(true);
        }

        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            ReflectionUtils.handleReflectionException(e);
        }
        return null;
    }

    /**
     * 获取反射时的具体对象：针对消息通知定时任务
     * @param paramsMap
     * @return
     * @author yinchangjiang.ht
     * @time 2011-4-6 下午03:30:59
     */
    public static Object getInvokeParamBean(Map<Object, Object> paramsMap){
        Object obj = null;
        String classNameKey = "className";
        try {
            if(paramsMap != null) {
                // 取出需要反射的具体对象
                String className = paramsMap.get("className").toString();
                Class<?> clazz = Class.forName(className);
                obj = clazz.newInstance();

                // 删除掉Map中的具体Class对象，只保留方法参数
                paramsMap.remove(classNameKey);

                // 循环参数列表
                Object[] keys = paramsMap.keySet().toArray();
                for(Object key : keys) {
                    Object value = paramsMap.get(key);

                    String method = PREFIX_GET + key;
                    Method getMethod = clazz.getMethod(method);
                    Class<?> type = getMethod.getReturnType();

                    Method setMethod = clazz.getMethod(PREFIX_SET + key, type);
                    setMethod.setAccessible(true);
                    setMethod.invoke(obj, value);
                }
            }
        } catch (Exception e) {
            logger.error("InvokeUtils.getInvokeParamBean 异常", e);
        }

        return obj;
    }

    /**
     * 获取反射时的具体对象
     * @param clazz
     * @param paramsMap
     * @return
     * @author hekang.ht
     * @time 2015-11-19 上午10:30:59
     */
    public static Object getInvokeMapToBean(Class clazz, Map<Object, Object> paramsMap){
        Object obj = null;
        try {
            if(paramsMap != null) {
                obj = clazz.newInstance();

                // 循环参数列表
                Object[] keys = paramsMap.keySet().toArray();

                for(Object key : keys) {
                    // 某个属性出错还会继续设置
                    try{
                        String method = PREFIX_GET + StringUtils.capitalize((String)key);
                        Method getMethod = clazz.getMethod(method);
                        Class<?> type = getMethod.getReturnType();

                        Method setMethod = clazz.getMethod(PREFIX_SET + StringUtils.capitalize((String)key), type);
                        setMethod.setAccessible(true);
                        setMethod.invoke(obj, invokeParamToMethodType(paramsMap.get(key), type));
                    } catch (Exception e) {
                        logger.debug("InvokeUtils.getInvokeParamBean 属性设值异常", e);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("InvokeUtils.getInvokeParamBean 异常", e);
        }

        return obj;
    }

    /**
     * 获取对象的get方法的值，转为属性Map
     * @param obj
     * @return
     * @author hekang.ht
     * @time 2015-11-19 上午10:30:59
     */
    public static Map<String, Object> getBeanGetMethonToPropMap(Object obj){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Class clazz = obj.getClass();
            Method[] methods = clazz.getMethods();
            String methodName = null;
            String propName = null;
            for(Method method : methods) {
                // 某个属性出错还会继续取值
                try{
                    methodName = method.getName();
                    if (methodName.startsWith("get")){
                        propName = StringUtils.uncapitalize(methodName.substring(3, propName.length()));
                        map.put(propName, method.invoke(obj));
                    }
                } catch (Exception e) {
                    logger.debug("InvokeUtils.getBeanPropertiesToMap 属性取值异常", e);
                }
            }
        } catch (Exception e) {
            logger.error("InvokeUtils.getBeanPropertiesToMap 异常", e);
        }

        return map;
    }

    /**
     * 参数转换为属性类型
     * @param value		参数
     * @param type		属性类型
     * @return
     */
    private static Object invokeParamToMethodType(Object value, Class<?> type) {
        if (value == null)
            return null;
        String strVal = String.valueOf(value);
        Object invokeObj = null;
        if (type.equals(Boolean.class))
            invokeObj = Boolean.valueOf(strVal);
        else if (type.equals(Integer.class))
            invokeObj = Integer.valueOf(strVal);
        else if (type.equals(Long.class))
            invokeObj = Long.valueOf(strVal);
        else if (type.equals(Float.class))
            invokeObj = Float.valueOf(strVal);
        else if (type.equals(Double.class))
            invokeObj = Double.valueOf(strVal);
        else if (type.equals(BigDecimal.class))
            invokeObj = new BigDecimal(strVal);
        else if (type.equals(String.class))
            invokeObj = strVal;
        else
            invokeObj = value;
        return invokeObj;
    }

    private static void argumentSanityCheck(Object[] args, Class<?>[] argTypes)
            throws IllegalArgumentException {
        Assert.notNull(args, "args should not be null");
        Assert.notNull(argTypes, "argTypes should not be null");
        Assert.isTrue(args.length == argTypes.length,
                "the arrays of arguments and types should have the same length");
        final int arrayLength = args.length;
        for (int i = 0; i < arrayLength; i++) {
            Class<?> argType = argTypes[i];
            Object arg = args[i];
            if (argType == null) {
                Assert.isTrue(arg == null || !arg.getClass().isPrimitive());
            } else {
                Assert.isTrue(arg == null || argType.isInstance(arg));
            }
        }
    }

    private static Method findMatchingMethod(Class<?> clazz, String methodName,
                                             Class<?>[] argTypes) throws SecurityException,
            NoSuchMethodException {
        Assert.notNull(clazz);
        Assert.hasText(methodName);
        if (argTypes == null) {
            argTypes = EMPTY_CLASS_ARRAY;
        }

        return clazz.getMethod(methodName, argTypes);
    }

}

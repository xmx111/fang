package com.ufo.fang.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.ufo.fang.common.cache.redis.service.RedisService;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 缓存服务工厂类
 * 此类只为Caches类服务
 * @Author qimao.huang
 * @CreateTime 2015年4月30日 下午5:06:28
 * @Company www.hitao.com
 */
public class CacheServerFactory {
    private final static String NO_CACHE_LEVEL = "no cache";//没有缓存
    private final static String LOCAL_CACHE_LEVEL = "local cache";//本地缓存
    private final static String REDIS_CACHE_LEVEL = "redis cache";//redis缓存

    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private final boolean isTrace = logger.isDebugEnabled();

    private RedisService redisService;

    private int cacheLevel;

    // 失效时间 单位：秒   如果为0，则表示永不失效
    private int expireTimeInSecondAfterWrite;

    protected CacheServerFactory() {
    }

    protected CacheServerFactory(int cacheLevel, int expireTimeInSecondAfterWrite, RedisService redisService) {
        this.cacheLevel = cacheLevel;
        this.expireTimeInSecondAfterWrite = expireTimeInSecondAfterWrite;
        this.redisService = redisService;
    }

    /**
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <K extends Serializable,V extends Serializable> CacheServer<K,V> createCacheServer(){
        if(cacheLevel>=2){
            logger.info("create "+REDIS_CACHE_LEVEL+",CACHE_LEVEL="+cacheLevel+",expireTimeInSecondAfterWrite="+expireTimeInSecondAfterWrite);
            CacheServer<String,V> cacheServer = createLevelTwo(expireTimeInSecondAfterWrite);
            return (CacheServer<K,V>)cacheServer;
        }else if(cacheLevel>=1){
            logger.info("create "+LOCAL_CACHE_LEVEL+",CACHE_LEVEL="+cacheLevel+",expireTimeInSecondAfterWrite="+expireTimeInSecondAfterWrite);
            return createLevelOne(expireTimeInSecondAfterWrite, true);
        }else{
            logger.info("create "+NO_CACHE_LEVEL+",CACHE_LEVEL="+cacheLevel+",expireTimeInSecondAfterWrite="+expireTimeInSecondAfterWrite);
            return createEmptyCacheServer();
        }

    }

    private final <K,V> CacheServer<K,V> createEmptyCacheServer(){
        return new CacheServer<K, V>() {
            @Override
            public V get(K key, Class type) {
                if(isTrace)
                    logger.debug(NO_CACHE_LEVEL+" GET key="+key);
                return null;
            }

            @Override
            public V get(K key, Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
                return get(key, mapClass);
            }

            @Override
            public <T> List<T> getList(K key, Class type) {
                if(key == null)
                    return null;
                if(isTrace)
                    logger.debug(NO_CACHE_LEVEL+" GET keys="+key);
                List<T> list = new ArrayList<>();
                return list;
            }

            @Override
            public boolean put(K key, V value) {
                if(isTrace)
                    logger.debug(NO_CACHE_LEVEL+" PUT key="+key+",value="+getDebugString(value));
                return false;
            }

            @Override
            public boolean remove(K key) {
                if(isTrace)
                    logger.debug(NO_CACHE_LEVEL+" remove key="+key);
                return false;
            }

            @Override
            public Collection<K> keySet() {
                return Collections.emptyList();
            }

            @Override
            public boolean cleanUp() {
                if(isTrace)
                    logger.debug(NO_CACHE_LEVEL+" cleanUp");
                return false;
            }

            @Override
            public boolean cleanUp(String keyPrefix) {
                if(isTrace)
                    logger.debug(NO_CACHE_LEVEL+" cleanUp");
                return false;
            }
        };
    }

    private <K,V> CacheServer<K,V> createLevelOne(int expireTimeInSecond,boolean expireAfterWriteElseAccess){
        @SuppressWarnings({ "unchecked", "rawtypes" })
        final CacheBuilder<K,V> cb = (CacheBuilder) CacheBuilder.newBuilder();
        if(expireAfterWriteElseAccess){
            cb.expireAfterWrite(expireTimeInSecond, TimeUnit.SECONDS);
        }else{
            cb.expireAfterAccess(expireTimeInSecond, TimeUnit.SECONDS);
        }
        return new CacheServer<K, V>(){
            private Cache<K,V> cache = cb.build();
            @Override
            public V get(K key, Class type) {
                if(key==null)
                    return null;
                V v = cache.getIfPresent(key);
                if(isTrace)
                    logger.debug(LOCAL_CACHE_LEVEL+" GET key="+key+",value="+getDebugString(v));
                return v;
            }

            @Override
            @Deprecated
            public V get(K key, Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
                return get(key, mapClass);
            }

            @Override
            public boolean put(K key, V value) {
                if(key==null)
                    return false;
                cache.put(key, value);
                if(isTrace)
                    logger.debug(LOCAL_CACHE_LEVEL+" PUT key="+key+",value="+getDebugString(value));
                return true;
            }
            @Override
            public boolean remove(K key) {
                if(key==null)
                    return false;
                cache.invalidate(key);
                if(isTrace)
                    logger.debug(LOCAL_CACHE_LEVEL+" remove key="+key);
                return true;
            }
            @Override
            public Collection<K> keySet() {
                return cache.asMap().keySet();
            }

            @Override
            public <T> List<T> getList(K key, Class type) {
                if(key==null)
                    return null;
                Object v = cache.getIfPresent(key);
                if(isTrace)
                    logger.debug(LOCAL_CACHE_LEVEL+" get key="+key);
                return (List<T>)v;
            }

            @Override
            public boolean cleanUp() {
                try{
                    cache.cleanUp();
                    if(isTrace)
                        logger.debug(LOCAL_CACHE_LEVEL+" cleanUp");
                    return true;
                }catch(Throwable e){
                    return false;
                }
            }

            @Override
            public boolean cleanUp(String keyPrefix) {
                return cleanUp();
            }
        };
    }

    private <V extends Serializable> CacheServer<String,V> createLevelTwo(int expireTimeInSecondAfterWrite){
        String errorMessage = null;
        if(expireTimeInSecondAfterWrite > 30*24*60*60){
            errorMessage = "expireTimeInSecondAfterWrite is too big ,limit "+ 30*24*60*60+"(30 days), but in fact "+expireTimeInSecondAfterWrite+",application will use 30 days";
            logger.error(errorMessage);
            expireTimeInSecondAfterWrite = 30*24*60*60;
        }
        final int expireTimeInSecondAfterWrite_ = expireTimeInSecondAfterWrite;
        final RedisService rs = redisService;
        return new CacheServer<String,V>(){
            private RedisService redisService = rs;

            @SuppressWarnings("unchecked")
            @Override
            public V get(String key, Class type) {
                if(key == null)
                    return null;
                if(redisService == null){
                    logger.error(REDIS_CACHE_LEVEL+" redisService is null,get key="+key);
                    return null;
                }
                V v = (V)redisService.get(key, type);
                if(isTrace)
                    logger.debug(REDIS_CACHE_LEVEL+" GET key="+key+",value="+v);
                return v;
            }

            @SuppressWarnings("unchecked")
            @Override
            public V get(String key, Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
                if(key == null)
                    return null;
                if(redisService == null){
                    logger.error(REDIS_CACHE_LEVEL+" redisService is null,get key="+key);
                    return null;
                }
                V v = (V)redisService.get(key, mapClass, keyClass, valueClass);
                if(isTrace)
                    logger.debug(REDIS_CACHE_LEVEL+" GET key="+key+",value="+v);
                return v;
            }

            @Override
            public boolean put(String key, V value) {
                if(key == null)
                    return false;
                if(redisService == null){
                    logger.error(REDIS_CACHE_LEVEL+" redisService is null,put key="+key+",value="+getDebugString(value));
                    return false;
                }
                redisService.setex(key, expireTimeInSecondAfterWrite_, value);
                if(isTrace)
                    logger.debug(REDIS_CACHE_LEVEL+" SETEX key="+key+",value="+getDebugString(value));
                return true;
            }

            @Override
            public boolean remove(String key) {
                if(key == null)
                    return false;
                if(redisService == null){
                    logger.error(REDIS_CACHE_LEVEL+" redisService is null,remove key="+key);
                    return false;
                }
                redisService.delete(key);
                if(isTrace)
                    logger.debug(REDIS_CACHE_LEVEL+" delete key="+key);
                return true;
            }

            @Override
            public Collection<String> keySet() {
                logger.warn(REDIS_CACHE_LEVEL+" call keySet(),will return empty collection");
                return Collections.emptyList();
            }

            @Override
            public <T> List<T> getList(String key, Class type) {
                if(key == null)
                    return null;
                if(redisService == null){
                    logger.error(REDIS_CACHE_LEVEL+" redisService is null,gets key="+key);
                    return null;
                }
                List<T> list = (List<T>)redisService.gets(key, type);
                if(isTrace)
                    logger.debug(REDIS_CACHE_LEVEL+" gets key="+key);
                return list;
            }

            @Override
            @Deprecated
            public boolean cleanUp() {
                if(redisService == null){
                    logger.error(REDIS_CACHE_LEVEL+" redisService is null when cleanUp");
                    return false;
                }
                // redisService.flushDB();
                if(isTrace)
                    logger.debug(REDIS_CACHE_LEVEL+" flushDB");
                return true;
            }

            @Override
            public boolean cleanUp(String keyPrefix) {
                if(redisService == null){
                    logger.error(REDIS_CACHE_LEVEL+" redisService is null when cleanUp");
                    return false;
                }
                redisService.cleanUp(keyPrefix);
                if(isTrace)
                    logger.debug(REDIS_CACHE_LEVEL+" cleanUp " + keyPrefix);
                return true;
            }
        };
    }

    @SuppressWarnings({"unchecked" })
    private <K,V> List<V> wrapDatas(List<K> keys, boolean onlyHitValue, Map<?,?> datas){
        if(datas == null)
            datas = Collections.emptyMap();
        List<V> rs = new ArrayList<V>(onlyHitValue?datas.size():keys.size());
        V value = null;
        for(K key:keys){
            value = (V)datas.get(key);
            //有缓存值  添加之
            if(value !=null){
                rs.add(value);
                //无缓存值
            }else{
                //只要命中的值，进行下一次循环
                if(onlyHitValue)
                    continue;
                //未命中的值也要
                rs.add(null);
            }
        }
        return rs;
    }

    @SuppressWarnings({"rawtypes" })
    private final String getDebugString(Object value){
        if(value == null)
            return null;
        if(value instanceof Map)
            return value.getClass().getSimpleName()+"("+((Map)value).size()+")";
        if(value instanceof Collection)
            return value.getClass().getSimpleName()+"("+((Collection)value).size()+")";
        if(value instanceof Object[])
            return value.getClass().getSimpleName()+"("+((Object[])value).length+")";
        if(value.getClass().isArray())
            return value.getClass().getSimpleName()+"("+ Array.getLength(value)+")";
        String v = value.toString();
        if(v.length()<=40)
            return v.replaceAll("\\r*\\n"," ");
        else
            return (v.substring(0,20)+" ...... "+ v.substring(v.length()-20)).replaceAll("\\r*\\n"," ");
    }
}

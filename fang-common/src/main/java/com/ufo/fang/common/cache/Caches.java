package com.ufo.fang.common.cache;

import com.ufo.fang.common.cache.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 系统中所有的缓存容器
 * @Author qimao.huang
 * @CreateTime 2015年5月7日 下午3:14:02
 * @Company hitao.com
 */
@Component("demoCaches")
@Scope("singleton")
public class Caches implements ApplicationListener<ContextRefreshedEvent> {

    private AtomicBoolean inited = new AtomicBoolean(false);

    @Autowired
    RedisService redisService;

    @Value("${cache.level}")
    private int cacheLevel;

    /**
     * 五分钟的缓存
     */
    private CacheServer<String,Serializable> fiveMinuteCache;

    /**
     * 一小时的缓存
     */
    private CacheServer<String,Serializable> oneHourCache;
    /**
     * 四小时的缓存
     */
    private CacheServer<String,Serializable> fourHourCache;
    /**
     * 半天的缓存
     */
    private CacheServer<String,Serializable> twelveHourCache;
    /**
     * 一天的缓存
     */
    private CacheServer<String,Serializable> oneDayCache;
    /**
     * 30天时间的缓存
     *
     */
    private CacheServer<String,Serializable> defaultCache;
    /**
     * 30天时间的缓存
     */
    private CacheServer<String,Serializable> otherSysCache;

    public CacheServer<String, Serializable> getFiveMinuteCache() {
        return fiveMinuteCache;
    }

    public CacheServer<String, Serializable> getOneHourCache() {
        return oneHourCache;
    }

    public CacheServer<String, Serializable> getFourHourCache() {
        return fourHourCache;
    }

    public CacheServer<String, Serializable> getTwelveHourCache() {
        return twelveHourCache;
    }

    public CacheServer<String, Serializable> getOneDayCache() {
        return oneDayCache;
    }

    public CacheServer<String, Serializable> getDefaultCache() {
        return defaultCache;
    }

    public CacheServer<String, Serializable> getOtherSysCache() {
        return otherSysCache;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (inited.get())
            return;
        fiveMinuteCache = new CacheServerFactory(cacheLevel, 5*60, redisService).createCacheServer();
        oneHourCache =  new CacheServerFactory(cacheLevel, 3600, redisService).createCacheServer();
        fourHourCache =  new CacheServerFactory(cacheLevel, 4*3600, redisService).createCacheServer();
        twelveHourCache =  new CacheServerFactory(cacheLevel, 12*3600, redisService).createCacheServer();
        oneDayCache =  new CacheServerFactory(cacheLevel, 24*3600, redisService).createCacheServer();
        defaultCache =  new CacheServerFactory(cacheLevel, 30*24*3600, redisService).createCacheServer();
        otherSysCache =  new CacheServerFactory(cacheLevel, 30*24*3600, redisService).createCacheServer();
    }
}

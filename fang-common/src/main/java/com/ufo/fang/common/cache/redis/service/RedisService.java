package com.ufo.fang.common.cache.redis.service;

import com.ufo.fang.common.cache.ValueWrapper;
import com.ufo.fang.common.cache.impl.RedisCache;
import com.ufo.fang.common.util.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/1/28
 */
@Service
public class RedisService {

    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("demoRedisCache")
    private RedisCache redisCache;

    @Value("${redis.cache.time:864000}")
    private int redisCacheTime = 864000;

    @Value("${redis.project.prefix}")
    private String redisProjectPrefix; // redis前缀

    public boolean exists(String group, String id) {
        return this.redisCache.exists(this.getRedisPrefix(group, id));
    }

    public void lpush(String key, Object value) {
        this.redisCache.lpush(key, new String[]{JsonUtils.writeValueAsString(value)});
    }

    public <T> T rpop(String key, Class<T> clazz) {
        T data = null;

        try {
            String e = this.redisCache.getPool().getResource().rpop(key);
            if(StringUtils.isNotBlank(e)) {
                data = JsonUtils.readValue(e, clazz);
            }

            return data;
        } catch (Exception var5) {
            this.logger.error("redis get exception", var5);
            return data;
        }
    }

    public <T> Map<String, T> hgetall(String key, Class<T> clazz) {
        HashMap result = new HashMap();

        try {
            Map e = this.redisCache.hgetall(key);
            if(e.isEmpty()) {
                return result;
            } else {
                Iterator var6 = e.entrySet().iterator();

                while(var6.hasNext()) {
                    Map.Entry entry = (Map.Entry)var6.next();
                    if(StringUtils.isNotBlank((String)entry.getValue())) {
                        result.put((String)entry.getKey(), JsonUtils.readValue((String)entry.getValue(), clazz));
                    }
                }

                return result;
            }
        } catch (Exception var7) {
            this.logger.error("redis get exception", var7);
            return result;
        }
    }

    public Map<String, String> hgetall(String key) {
        try {
            Map e = this.redisCache.hgetall(key);
            return e;
        } catch (Exception var3) {
            this.logger.error("redis get exception", var3);
            return null;
        }
    }

    public <T> T hget(String key, String field, Class<T> clazz) {
        T data = null;

        try {
            String e = this.redisCache.hget(key, field);
            if(StringUtils.isNotBlank(e)) {
                data = JsonUtils.readValue(e, clazz);
            }

            return data;
        } catch (Exception var6) {
            this.logger.error("redis get exception", var6);
            return data;
        }
    }

    public String hget(String key, String field) {
        try {
            String e = this.redisCache.hget(key, field);
            return e;
        } catch (Exception var4) {
            this.logger.error("redis get exception", var4);
            return null;
        }
    }

    public void hset(String key, String field, Object value, Integer seconds) {
        this.redisCache.hset(key, field, JsonUtils.writeValueAsString(value));
        if(seconds != null) {
            this.redisCache.expire(key, seconds.intValue());
        }

    }

    public <T> T get(String group, String id, Class<T> clazz) {
        T data = null;

        try {
            ValueWrapper e = this.redisCache.getValueWrapper(this.getRedisPrefix(group, id), clazz);
            if(e != null) {
                data = e.getValue();
                this.logger.debug("redis get method, group={}, id={}, data={}", new Object[]{group, id, data});
            }
        } catch (Exception var6) {
            this.logger.error("redis get exception", var6);
        }

        return data;
    }

    public <T> T get(String key) {
        T data = null;

        try {
            String e = this.redisCache.get(getRedisPrefix(key));
            if(e != null) {
                data = JsonUtils.readValue(e);
                this.logger.debug("redis get method, key={},  data={}", new Object[]{key, data});
            }
        } catch (Exception var5) {
            this.logger.error("redis get exception", var5);
        }

        return data;
    }

    public <T> T get(String key, Class<T> clazz) {
        T data = null;

        try {
            String e = this.redisCache.get(getRedisPrefix(key));
            if(e != null) {
                data = JsonUtils.readValue(e, clazz);
                this.logger.debug("redis get method, key={},  data={}", new Object[]{key, data});
            }
        } catch (Exception var5) {
            this.logger.error("redis get exception", var5);
        }

        return data;
    }

    public <T> T get(String key, Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
        T data = null;

        try {
            String e = this.redisCache.get(getRedisPrefix(key));
            if(e != null) {
                data = JsonUtils.jsonToMap(e, mapClass, keyClass, valueClass);
                this.logger.debug("redis get method, key={},  data={}", new Object[]{key, data});
            }
        } catch (Exception var5) {
            this.logger.error("redis get exception", var5);
        }

        return data;
    }

    public <T> List<T> gets(String key, Class<?> clazz) {
        List<T> data = null;

        try {
            String e = this.redisCache.get(getRedisPrefix(key));
            if(e != null) {
                data = (List<T>) JsonUtils.readListValue(e, clazz);
                this.logger.debug("redis get method, key={},  data={}", new Object[]{key, data});
            }
        } catch (Exception var5) {
            this.logger.error("redis get exception", var5);
        }

        return data;
    }

    public String getOriginalValue(String group, String id) {
        return this.redisCache.get(this.getRedisPrefix(group, id));
    }

    public <T> List<T> getList(String id, Class<T> clazz) {
        List data = null;

        try {
            ValueWrapper e = this.redisCache.getListWrapper(this.getRedisPrefix(id), clazz);
            if(e != null) {
                data = (List)e.getValue();
                this.logger.debug("redis getList method, group={}, id={}, data={}", new Object[]{id, data});
            }
        } catch (Exception var6) {
            this.logger.error("redis get exception", var6);
        }

        return data;
    }

    public <T> List<T> getList(String group, String id, Class<T> clazz) {
        List data = null;

        try {
            ValueWrapper e = this.redisCache.getListWrapper(this.getRedisPrefix(group, id), clazz);
            if(e != null) {
                data = (List)e.getValue();
                this.logger.debug("redis getList method, group={}, id={}, data={}", new Object[]{group, id, data});
            }
        } catch (Exception var6) {
            this.logger.error("redis get exception", var6);
        }

        return data;
    }

    public <T> void set(String group, String id, T data, int seconds) {
        this.redisCache.setValueWrapper(this.getRedisPrefix(group, id), data, seconds);
        this.logger.debug("redis set method, group={}, id={}, data={}", new Object[]{group, id, data});
    }

    public <T> void set(String group, String id, T data) {
        this.redisCache.setValueWrapper(this.getRedisPrefix(group, id), data, this.redisCacheTime);
        this.logger.debug("redis set method, group={}, id={}, data={}", new Object[]{group, id, data});
    }

    public <T> void setex(String key, int seconds, T data) {
        this.redisCache.setex(getRedisPrefix(key), seconds, JsonUtils.writeValueAsString(data));
    }

    public void setx(String key, Object data, Integer seconds) {
        this.redisCache.set(key, JsonUtils.writeValueAsString(data));
        if(seconds != null) {
            this.redisCache.expire(key, seconds.intValue());
        }

    }

    public void delete(String group, String id) {
        this.redisCache.del(this.getRedisPrefix(group, id));
        this.logger.debug("redis delete method, group={}, id={}", new Object[]{group, id});
    }

    public void delete(String key) {
        this.redisCache.del(getRedisPrefix(key));
        this.logger.debug("redis delete method, key={}", new Object[]{key});
    }

    public long incr(String group, String id, int expire) {
        return this.redisCache.incr(this.getRedisPrefix(group, id), expire);
    }

    public long decr(String group, String id, int expire) {
        return this.redisCache.decr(this.getRedisPrefix(group, id), expire);
    }

    public long incrBy(String group, String id, Long integer, int expire) {
        return this.redisCache.incrBy(this.getRedisPrefix(group, id), integer, expire);
    }

    public long decrBy(String group, String id, Long integer, int expire) {
        return this.redisCache.decrBy(this.getRedisPrefix(group, id), integer, expire);
    }

    public String getRedisPrefix(String id) {
        return redisProjectPrefix + ":" + id;
    }

    public String getRedisPrefix(String group, String id) {
        return redisProjectPrefix + ":" + group + ":" + id;
    }

    public <T> boolean sismember(String group, String id, T data) {
        return this.redisCache.sismember(this.getRedisPrefix(group, id), JsonUtils.writeValueAsString(data));
    }

    public <T> void sadd(String group, String id, T data) {
        this.redisCache.sadd(this.getRedisPrefix(group, id), JsonUtils.writeValueAsString(data));
    }

    public void flushDB(){
        this.redisCache.getPool().getResource().flushDB();
    }

    public boolean cleanUp(String keyPrefix){
        boolean ret = true;
        try {
            Set<String> keys = this.redisCache.keys(getRedisPrefix(keyPrefix + "*"));
            if(keys != null) {
                for (String key : keys){
                    this.redisCache.del(key);
                }
            }
        } catch (Exception var5) {
            this.logger.error("redis clean exception", var5);
            ret = false;
        }
        return ret;
    }
}

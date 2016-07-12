package com.ufo.fang.common.cache.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

import com.ufo.fang.common.cache.ValueWrapper;
import com.ufo.fang.common.util.JsonUtils;
import com.ufo.fang.common.util.ObjectUtils;
import com.ufo.fang.common.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/12
 */
public class RedisCache {

    private JedisPool pool;

    public RedisCache() {
    }

    public JedisPool getPool() {
        return this.pool;
    }

    public void setPool(JedisPool pool) {
        this.pool = pool;
    }

    public Map<String, Map<String, String>> info(String section) throws Throwable {
        Jedis jedis = this.pool.getResource();

        String info;
        try {
            info = jedis.info(section != null && !section.isEmpty()?section:"default");
        } finally {
            this.pool.returnResource(jedis);
        }

        LinkedHashMap result = new LinkedHashMap();

        try {
            Throwable e = null;
            Object var6 = null;

            try {
                BufferedReader reader = new BufferedReader(new StringReader(info));

                try {
                    String key = null;
                    LinkedHashMap values = null;

                    String line;
                    while((line = reader.readLine()) != null) {
                        line = line.trim();
                        if(!line.isEmpty()) {
                            if(line.charAt(0) == 35) {
                                key = line.substring(1).trim();
                                values = new LinkedHashMap();
                                result.put(key, values);
                            } else {
                                String[] tmp = line.split(":", 2);
                                values.put(tmp[0], tmp.length == 1?null:tmp[1]);
                            }
                        }
                    }
                } finally {
                    if(reader != null) {
                        reader.close();
                    }

                }

                return result;
            } catch (Throwable var25) {
                if(e == null) {
                    e = var25;
                } else if(e != var25) {
                    e.addSuppressed(var25);
                }

                throw e;
            }
        } catch (IOException var26) {
            throw new IllegalArgumentException(var26);
        }
    }

    public boolean exists(String key) {
        Jedis jedis = this.pool.getResource();

        boolean var4;
        try {
            var4 = jedis.exists(key).booleanValue();
        } finally {
            this.pool.returnResource(jedis);
        }

        return var4;
    }

    public Long expire(String key, int seconds) {
        Jedis jedis = this.pool.getResource();

        Long var5;
        try {
            var5 = jedis.expire(key, seconds);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var5;
    }

    public Long pexpire(String key, int milliseconds) {
        Jedis jedis = this.pool.getResource();

        Long var5;
        try {
            var5 = jedis.pexpire(key, milliseconds);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var5;
    }

    public Long ttl(String key) {
        Jedis jedis = this.pool.getResource();

        Long var4;
        try {
            var4 = jedis.ttl(key);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var4;
    }

    public String get(String key) {
        Jedis jedis = this.pool.getResource();

        String var4;
        try {
            var4 = jedis.get(key);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var4;
    }

    public void set(String key, String value) {
        Jedis jedis = this.pool.getResource();

        try {
            jedis.set(key, value);
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public void setex(String key, int seconds, String value) {
        Jedis jedis = this.pool.getResource();

        try {
            jedis.setex(key, seconds, value);
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public void del(String key) {
        Jedis jedis = this.pool.getResource();

        try {
            jedis.del(key);
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public void del(String... key) {
        Jedis jedis = this.pool.getResource();

        try {
            jedis.del(key);
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public Set<String> keys(String pattern) {
        Jedis jedis = this.pool.getResource();

        Set var4;
        try {
            var4 = jedis.keys(pattern);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var4;
    }

    public Set<String> hkeys(String key) {
        Jedis jedis = this.pool.getResource();

        Set var4;
        try {
            var4 = jedis.hkeys(key);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var4;
    }

    public Map<String, String> hgetall(String key) {
        Jedis jedis = this.pool.getResource();

        Map var4;
        try {
            var4 = jedis.hgetAll(key);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var4;
    }

    public String hget(String key, String field) {
        Jedis jedis = this.pool.getResource();

        String var5;
        try {
            var5 = jedis.hget(key, field);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var5;
    }

    public <T> List<String> hmget(String key, T... fields) {
        ArrayList list = new ArrayList();
        Object[] var7 = fields;
        int var6 = fields.length;

        for(int var5 = 0; var5 < var6; ++var5) {
            Object jedis = var7[var5];
            list.add(StringUtils.toString(jedis));
        }

        Jedis var10 = this.pool.getResource();

        List var11;
        try {
            var11 = var10.hmget(key, (String[])list.toArray(new String[list.size()]));
        } finally {
            this.pool.returnResource(var10);
        }

        return var11;
    }

    public Long hdel(String key, String field) {
        Jedis jedis = this.pool.getResource();

        Long var5;
        try {
            var5 = jedis.hdel(key, new String[]{field});
        } finally {
            this.pool.returnResource(jedis);
        }

        return var5;
    }

    public void hmset(String key, Map<String, String> hash) {
        Jedis jedis = this.pool.getResource();

        try {
            jedis.hmset(key, hash);
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public void hset(String key, String field, String value) {
        Jedis jedis = this.pool.getResource();

        try {
            jedis.hset(key, field, value);
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public boolean hsetnx(String key, String field, String value) {
        Jedis jedis = this.pool.getResource();

        boolean var6;
        try {
            var6 = jedis.hsetnx(key, field, value).longValue() == 1L;
        } finally {
            this.pool.returnResource(jedis);
        }

        return var6;
    }

    public void lpush(String key, String... values) {
        Jedis jedis = this.pool.getResource();

        try {
            jedis.lpush(key, values);
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public void rpush(String key, String... values) {
        Jedis jedis = this.pool.getResource();

        try {
            jedis.rpush(key, values);
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public List<String> lrange(String key, int offset, int end) {
        Jedis jedis = this.pool.getResource();

        List var6;
        try {
            var6 = jedis.lrange(key, (long)offset, (long)end);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var6;
    }

    public Long llen(String key) {
        Jedis jedis = this.pool.getResource();

        Long var4;
        try {
            var4 = jedis.llen(key);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var4;
    }

    public String rpop(String key) {
        Jedis jedis = this.pool.getResource();

        String var4;
        try {
            var4 = jedis.rpop(key);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var4;
    }

    public String lpop(String key) {
        Jedis jedis = this.pool.getResource();

        String var4;
        try {
            var4 = jedis.lpop(key);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var4;
    }

    public void sadd(String key, String member) {
        Jedis jedis = this.pool.getResource();

        try {
            jedis.sadd(key, new String[]{member});
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public String spop(String key) {
        Jedis jedis = this.pool.getResource();

        String var4;
        try {
            var4 = jedis.spop(key);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var4;
    }

    public Long scard(String key) {
        Jedis jedis = this.pool.getResource();

        Long var4;
        try {
            var4 = jedis.scard(key);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var4;
    }

    public boolean sismember(String key, String member) {
        Jedis jedis = this.pool.getResource();

        boolean var5;
        try {
            var5 = jedis.sismember(key, member).booleanValue();
        } finally {
            this.pool.returnResource(jedis);
        }

        return var5;
    }

    public void zadd(String key, double score, String member) {
        Jedis jedis = this.pool.getResource();

        try {
            jedis.zadd(key, score, member);
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public Set<String> zrange(String key, int offset, int end) {
        Jedis jedis = this.pool.getResource();

        Set var6;
        try {
            var6 = jedis.zrange(key, (long)offset, (long)end);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var6;
    }

    public Set<String> zrevrange(String key, int offset, int end) {
        Jedis jedis = this.pool.getResource();

        Set var6;
        try {
            var6 = jedis.zrevrange(key, (long)offset, (long)end);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var6;
    }

    private static ValueWrapper toValueWrapper(String val, Class<?> clazz, boolean list) {
        if(val == null) {
            return null;
        } else if(val.equals("json")) {
            return new ValueWrapper((Object)null);
        } else {
            String json = val.substring("json".length());
            Object value = list? JsonUtils.readListValue(json, clazz):JsonUtils.readValue(json, clazz);
            return new ValueWrapper(value);
        }
    }

    private static String toJson(Object value) {
        return value == null?"json":"json" + JsonUtils.writeValueAsString(value);
    }

    public void setValueWrapper(String key, Object value, int seconds) {
        String val = toJson(value);
        if(seconds < 1) {
            this.set(key, val);
        } else {
            this.setex(key, seconds, val);
        }

    }

    public void setValueWrapper(String key, Object value) {
        this.setValueWrapper(key, value, -1);
    }

    public ValueWrapper getValueWrapper(String key, Class<?> clazz) {
        return toValueWrapper(this.get(key), clazz, false);
    }

    public ValueWrapper getListWrapper(String key, Class<?> elementClass) {
        return toValueWrapper(this.get(key), elementClass, true);
    }

    public void setIncludeEndTime(String key, Map<String, Object> map, int seconds) {
        if(map != null && map.get("_et") == null) {
            map.put("_et", Long.valueOf(System.currentTimeMillis() / 1000L + (long)seconds));
        }

        String json = JsonUtils.writeValueAsString(map);
        Jedis jedis = this.pool.getResource();

        try {
            jedis.setex(key, seconds, json);
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public Map<String, Object> getMapIncludeEndTime(String key) {
        String text = this.get(key);
        if(text == null) {
            return null;
        } else {
            Map map = JsonUtils.toMap(text);
            Long endTime = ObjectUtils.toLong(map.get("_et"));
            return endTime != null && endTime.longValue() < System.currentTimeMillis() / 1000L?null:map;
        }
    }

    public long incr(String key, int expire) {
        Jedis jedis = this.pool.getResource();

        long var7;
        try {
            long value = jedis.incr(key).longValue();
            if(expire != -1) {
                jedis.expire(key, expire);
            }

            var7 = value;
        } finally {
            this.pool.returnResource(jedis);
        }

        return var7;
    }

    public long incrBy(String key, Long integer, int expire) {
        Jedis jedis = this.pool.getResource();

        long var8;
        try {
            long value = jedis.incrBy(key, integer.longValue()).longValue();
            if(expire != -1) {
                jedis.expire(key, expire);
            }

            var8 = value;
        } finally {
            this.pool.returnResource(jedis);
        }

        return var8;
    }

    public long decr(String key, int expire) {
        Jedis jedis = this.pool.getResource();

        long var7;
        try {
            long value = jedis.decr(key).longValue();
            if(expire != -1) {
                jedis.expire(key, expire);
            }

            var7 = value;
        } finally {
            this.pool.returnResource(jedis);
        }

        return var7;
    }

    public long decrBy(String key, Long integer, int expire) {
        Jedis jedis = this.pool.getResource();

        long var8;
        try {
            long value = jedis.decrBy(key, integer.longValue()).longValue();
            if(expire != -1) {
                jedis.expire(key, expire);
            }

            var8 = value;
        } finally {
            this.pool.returnResource(jedis);
        }

        return var8;
    }

    public void pipeHmSet(String key, Map<String, String> hash, int expire) {
        Jedis jedis = this.pool.getResource();

        try {
            Pipeline pipeline = jedis.pipelined();
            pipeline.hmset(key, hash);
            if(-1 != expire) {
                pipeline.expire(key, expire);
            }

            pipeline.sync();
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public List<String> pipeHmGet(String key, String[] keys) {
        Jedis jedis = this.pool.getResource();

        List var7;
        try {
            Pipeline pipeline = jedis.pipelined();
            Response response = pipeline.hmget(key, keys);
            pipeline.sync();
            var7 = (List)response.get();
        } finally {
            this.pool.returnResource(jedis);
        }

        return var7;
    }

    public Long getHLeng(String key) {
        Jedis jedis = this.pool.getResource();

        Long var4;
        try {
            var4 = jedis.hlen(key);
        } finally {
            this.pool.returnResource(jedis);
        }

        return var4;
    }

    public List<String> pipeGet(String... keys) {
        Jedis jedis = this.pool.getResource();

        List var6;
        try {
            Pipeline pipeline = jedis.pipelined();
            Response response = pipeline.mget(keys);
            pipeline.sync();
            var6 = (List)response.get();
        } finally {
            this.pool.returnResource(jedis);
        }

        return var6;
    }

    public void pipeLpush(String key, String... keys) {
        Jedis jedis = this.pool.getResource();

        try {
            Pipeline pipeline = jedis.pipelined();
            pipeline.lpush(key, keys);
            pipeline.sync();
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public void pipeMset(String... keysvalues) {
        Jedis jedis = this.pool.getResource();

        try {
            Pipeline pipeline = jedis.pipelined();
            pipeline.mset(keysvalues);
            pipeline.sync();
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public void pipeDel(String... keys) {
        Jedis jedis = this.pool.getResource();

        try {
            Pipeline pipeline = jedis.pipelined();
            pipeline.del(keys);
            pipeline.sync();
        } finally {
            this.pool.returnResource(jedis);
        }

    }

    public void pipeDel(String key, String... fields) {
        Jedis jedis = this.pool.getResource();

        try {
            Pipeline pipeline = jedis.pipelined();
            pipeline.hdel(key, fields);
            pipeline.sync();
        } finally {
            this.pool.returnResource(jedis);
        }

    }
}

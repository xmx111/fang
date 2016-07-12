package com.ufo.fang.common.cache;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/12
 */
public interface Cache {

    String get(String var1);

    <T> ValueMap<T> get(String var1, TypeReference<ValueMap<T>> var2);

    void set(String var1, String var2);

    <T> void set(String var1, T var2);

    void del(String var1);

    void setIncludeEndTime(String var1, Map<String, Object> var2, int var3);

    Map<String, Object> getMapIncludeEndTime(String var1);

    void hset(String var1, String var2, String var3);

    <T> void hset(String var1, String var2, T var3);

    <T> ValueMap<T> hget(String var1, String var2, TypeReference<ValueMap<T>> var3);

    Set<String> hkeys(String var1);

    String hget(String var1, String var2);

    void lpush(String var1, String... var2);

    void rpush(String var1, String... var2);

    List<String> lrange(String var1, int var2, int var3);

    Long llen(String var1);

    String rpop(String var1);

    void zadd(String var1, double var2, String var4);

    Set<String> zrange(String var1, int var2, int var3);

    Set<String> zrevrange(String var1, int var2, int var3);

    void pipelined(Map<String, Object> var1);
}

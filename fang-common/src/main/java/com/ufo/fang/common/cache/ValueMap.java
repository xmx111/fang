package com.ufo.fang.common.cache;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/12
 */
public class ValueMap<T> {

    T data;

    Long datetime;

    public ValueMap() {
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getDatetime() {
        return this.datetime;
    }

    public void setDatetime(Long datetime) {
        this.datetime = datetime;
    }

}

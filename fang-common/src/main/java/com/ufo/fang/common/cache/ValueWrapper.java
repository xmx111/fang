package com.ufo.fang.common.cache;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/12
 */
public class ValueWrapper {
    private Object value;

    public ValueWrapper(Object value) {
        this.value = value;
    }

    public <T> T getValue() {
        return (T)this.value;
    }

    public boolean isNull() {
        return this.value == null;
    }
}

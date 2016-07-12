package com.ufo.fang.common.exceptions;

/**
 * MyBatis的异常
 * 数据库的异常
 * Created by huangqimao on 2016/2/19.
 */
public class MapperException extends Exception{

    public MapperException(String message) {
        super(message);
    }

    public MapperException(String message, Throwable e) {
        super(message, e);
    }
}

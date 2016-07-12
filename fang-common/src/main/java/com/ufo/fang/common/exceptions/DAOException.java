package com.ufo.fang.common.exceptions;

/**
 * 持久层异常
 * Created by huangqimao on 2016/2/19.
 */
public class DAOException extends Exception {

    public DAOException(String message){
        super(message);
    }

    public DAOException(String message,Throwable e){
        super(message,e);
    }
}

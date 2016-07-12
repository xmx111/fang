package com.ufo.fang.common.exceptions;

/**
 * 服务层异常
 * 对应的，它的下层的异常（如持久层），应继承于它
 * Created by huangqimao on 2016/2/19.
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = -8927384118950098357L;

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message,Throwable e){
        super(message,e);
    }
}
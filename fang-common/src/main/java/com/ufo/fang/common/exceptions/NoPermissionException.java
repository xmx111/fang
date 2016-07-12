package com.ufo.fang.common.exceptions;

/**
 * 无权限 异常
 * 表示当前操作者无权限进行此操作
 * Created by huangqimao on 2016/2/19.
 */
public class NoPermissionException extends RuntimeException {

    private static final long serialVersionUID = 9076851719500136692L;

    public NoPermissionException(String message){
        super(message);
    }

    public NoPermissionException(String message,Throwable e){
        super(message,e);
    }
}

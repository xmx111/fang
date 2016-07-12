package com.ufo.fang.common.exceptions;

/**
 * Created by huangqimao on 2016/3/2.
 */
public class LoginException extends Exception {

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message,Throwable e) {
        super(message,e);
    }
}

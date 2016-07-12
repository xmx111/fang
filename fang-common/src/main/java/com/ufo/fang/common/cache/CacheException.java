package com.ufo.fang.common.cache;

/**
 * @Author qimao.huang
 * @CreateTime 2015年5月4日 上午9:36:01
 * @Company hitao.com
 */
public class CacheException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CacheException(String message) {
        super(message);
    }


    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }
}

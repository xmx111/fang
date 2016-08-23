package com.ufo.fang.common.util;

import java.util.UUID;

/***
 * Describe
 *
 * @author hekang
 * @created 2016-08-23
 */
public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}

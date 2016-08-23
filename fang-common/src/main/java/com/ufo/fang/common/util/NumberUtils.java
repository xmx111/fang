package com.ufo.fang.common.util;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Date;

/***
 * 数据工具类
 *
 * @author hekang
 * @created 2016/7/14
 */
public class NumberUtils {

    private static long seq = 0l;
    private static final int lenght = 4;
    private static final int max = 9999;

    /**
     * 生成唯一的序列数
     * @return
     */
    public static synchronized String randomNumber() {
        seq++;
        String no = String.valueOf(seq);
        String next = StringUtils.leftPad(no, lenght, "0");
        seq = (seq >= max) ? 0 : seq;
        return DateUtils.formatDate(new Date(), DateUtils.TIME_PATTERN_SESSION) + next;
    }

    /**
     * 生成指定位数的随机数字
     * @param length
     * @return
     */
    public static String randomNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

}

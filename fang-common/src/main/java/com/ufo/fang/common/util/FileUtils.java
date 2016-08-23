package com.ufo.fang.common.util;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/***
 * 文件工具类
 *
 * @author hekang
 * @created 2016-08-17
 */
public class FileUtils {

    public static String getDateFolder(String path){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = StringUtils.leftPad(String.valueOf(calendar.get(Calendar.MONTH) + 1), 2, "0");
        String day = StringUtils.leftPad(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)), 2, "0");

        String datePath = path + year + File.separator + month + File.separator + day + File.separator;
        return datePath;
    }

    public static String getFileNameByUUID(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static String getFullFilePath(String path, String suffix){
        return getDateFolder(path) + UUID.randomUUID().toString().replace("-", "").toLowerCase() + "." + suffix;
    }

    public static String getFilePath(String path, String suffix){
        return path + UUIDUtils.getUUID() + "." + suffix;
    }
}

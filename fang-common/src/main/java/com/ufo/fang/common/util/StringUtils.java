package com.ufo.fang.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class StringUtils extends org.apache.commons.lang.StringUtils {

    /**
     * 合法手机号验证
     * 
     * @param mobile
     * @return
     */
    public static boolean isMoblile(String mobile) {
        String mobileString = "^0{0,1}(12[0-9]|13[0-9]|14[0-9]|15[0-9]|16[0-9]|17[0-9]|18[0-9]|19[0-9])[0-9]{8}$";
        return mobile.matches(mobileString);
    }

    /** 
     * 判断字符串编码
    * @param str
    * @param encode
    * @return
    */
    public static boolean isEncoding(String str, String encode) {
        try {
            encode = isBlank(encode) ? "utf-8" : encode;
            if (str.equals(new String(str.getBytes(encode), encode))) {
                return true;
            }
        } catch (Exception exception) {
        }
        return false;
    }

    public static boolean isEmpty(Object value) {
        return value == null || (value instanceof String?(String)value:value.toString()).isEmpty();
    }

    /**
     * DBC to SBC 
     * space SBC 12288 = DBC 32
     * other SBC(33-126) + 65248 = DBC(65281-65374)
     * @param input
     * @return
     */
    public static String toSBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 32) {
                c[i] = (char) 12288;
                continue;
            }
            if (c[i] < 127)
                c[i] = (char) (c[i] + 65248);
        }
        return new String(c);
    }

    /**  
     * SBC to DBC
     * @param input  
     * @return  
     */
    public static String toDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    /**
     * 字符转整型
     * @param str
     * @return
     */
    public static List<Integer> splitToInteger(String str) {
        return splitToInteger(str, ",");
    }

    /**
     * 字符转整型
     * @param str
     * @return
     */
    public static List<Integer> splitToInteger(String str, String separtor) {
        List<Integer> values = new ArrayList<Integer>();
        if (isEmpty(str)) {
            return values;
        }
        for (String value : split(str, separtor)) {
            values.add(Integer.valueOf(value));
        }
        return values;
    }

    /**
     * 数字补零
     * @param num
     * @param size
     * @return
     */
    public static String addZero(int num, int size){
        String str = String.valueOf(num);
        while (str.length() < size){
            str = "0" + str;
        }
        return str;
    }

    public static String toString(Object value) {
        return value == null?null:value.toString();
    }

    public static String md5(String... values) {
        return md5((Collection) Arrays.asList(values));
    }

    public static String md5(Collection<String> values) {
        MessageDigest messageDigest = getMessageDigest("MD5");
        Iterator var3 = values.iterator();

        while(var3.hasNext()) {
            String value = (String)var3.next();
            if(value != null) {
                messageDigest.update(value.getBytes(SysUtils.UTF_8));
            }
        }

        return toHexString(messageDigest.digest());
    }

    public static MessageDigest getMessageDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm.toUpperCase());
        } catch (NoSuchAlgorithmException var2) {
            throw new IllegalStateException("MD5 provider not exist!");
        }
    }

    public static String toHexString(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        int i = 0;

        for(int len = bytes.length; i < len; ++i) {
            int value = bytes[i] & 255;
            if(value < 16) {
                buf.append('0');
            }

            buf.append(Integer.toHexString(value));
        }

        return buf.toString();
    }

    public static List<String> splitToList(String text, char splitChar) {
        return splitToList(text, splitChar, true, Integer.valueOf(text.length() / 16));
    }

    public static List<String> splitToList(String text, char splitChar, boolean trim, Integer initialCapacity) {
        ArrayList result = initialCapacity != null && initialCapacity.intValue() >= 10?new ArrayList(initialCapacity.intValue()):new ArrayList();
        int start = 0;
        int len = text.length();

        for(int tmp = 0; tmp < len; ++tmp) {
            if(splitChar == text.charAt(tmp)) {
                String tmp1 = start == tmp?"":text.substring(start, tmp);
                result.add(trim?tmp1.trim():tmp1);
                start = tmp + 1;
            }
        }

        if(start <= len) {
            String var9 = text.substring(start);
            result.add(trim?var9.trim():var9);
        }

        return result;
    }
}

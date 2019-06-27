package com.education.supplier.util;

import java.util.Base64;

import static com.education.supplier.util.constants.Constants.PREFIX;

/**
 * Author： fanyafeng
 * Data： 2019-06-27 10:31
 * Email: fanyafeng@live.cn
 */
public class Base64Util {


    public static String encode(String src) {
        src = PREFIX + src;
        byte[] bytes = src.getBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String decode(String src) {
        byte[] decoded = Base64.getDecoder().decode(src);
        String out=new String(decoded);
        return out.substring(PREFIX.length());
    }

    public static String encodeToken(String src) {
        byte[] bytes = src.getBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String decodeToken(String src) {
        byte[] decoded = Base64.getDecoder().decode(src);
        return new String(decoded);
    }
}

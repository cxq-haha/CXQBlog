package com.hnie.blogbackstage.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/23 12:02
 */
public class MD5Util {
    /**
     * MD5加密
     * @param str 要加密的字符串
     * @return 加密后的字符串
     */
    public static String code(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] digest = md.digest();
            int i;
            StringBuffer stringBuffer = new StringBuffer("");
            for (int offset = 0; offset < digest.length; offset++) {
                i = digest[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            //32位加密
            return stringBuffer.toString();
            //64位加密
            //return stringBuffer.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

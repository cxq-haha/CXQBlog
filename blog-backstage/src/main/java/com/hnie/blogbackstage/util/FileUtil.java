package com.hnie.blogbackstage.util;

public class FileUtil {
    //获取文件后缀
    public static String getFilePostFix(String fileName) {
        if (!fileName.contains(".")) {
            throw new RuntimeException("file format error!");
        }
        return fileName.substring(fileName.lastIndexOf("."));
    }

    //去除文件后缀
    public static String removeFilePostFix(String fileName) {
        if (!fileName.contains(".")) {
            throw new RuntimeException("file format error!");
        }
        return fileName.substring(0, fileName.lastIndexOf("."));
    }
}

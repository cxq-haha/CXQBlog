package com.hnie.blogbackstage.util;

import org.junit.jupiter.api.Test;

public class FileUtilTest {
    @Test
    public void postFixTest() {
        String fileName = "3485asdfalfj.png";
        String postfix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        System.out.println(postfix);
    }
}

package com.hnie.blogbackstage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hnie.blogbackstage.mybatis.mapper")
public class BlogBackstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogBackstageApplication.class, args);
    }

}

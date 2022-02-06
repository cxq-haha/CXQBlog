package com.hnie.blogbackstage;

import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.mapper.BlogMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan("com.hnie.blogbackstage.mybatis.mapper")
public class BlogBackstageApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogBackstageApplication.class, args);
    }

}

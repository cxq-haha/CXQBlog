package com.hnie.blogbackstage;

import com.hnie.blogbackstage.service.BlogService;
import com.hnie.blogbackstage.service.impl.BlogServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.hnie.blogbackstage.mybatis.mapper")
public class BlogBackstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogBackstageApplication.class, args);
    }

}

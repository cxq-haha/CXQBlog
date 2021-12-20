package com.hnie.blogbackstage.mapper;

import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.service.BlogService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import com.hnie.blogbackstage.mybatis.mapper.BolgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/20 17:19
 */
@SpringBootTest
public class BlogMapperTest {
    @Autowired
    BlogService blogService;

    @Test
    public void getAllBlogTest() {
        blogService.showBlog();
    }
}

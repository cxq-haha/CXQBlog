package com.hnie.blogbackstage.mapper;

import com.hnie.blogbackstage.mybatis.entity.Blog;
import org.junit.jupiter.api.Test;
import com.hnie.blogbackstage.mybatis.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/20 17:19
 */
@SpringBootTest
public class BlogMapperTest {
    @Autowired
    BlogMapper blogMapper;

    @Test
    public void getAllBlogTest() {
        List<Blog> allBlog = blogMapper.getAllBlog();
        for (Blog blog : allBlog) {
            System.out.println(blog);
        }
    }
}

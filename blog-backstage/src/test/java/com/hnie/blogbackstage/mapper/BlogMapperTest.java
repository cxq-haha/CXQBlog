package com.hnie.blogbackstage.mapper;

import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.mapper.BlogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
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
    public void getBlogByIdTest() {
        Blog blog = blogMapper.getBlogById(1L);
        System.out.println(blog);
    }

    @Test
    public void getAllBlogTest() {
        List<Blog> blog = blogMapper.getAllBlog();
        for (Blog blog1 : blog) {
            System.out.println(blog1);
        }
    }

    @Test
    public void addBlogTest() {
        Blog blog = new Blog(2L, "博客2", "博客2内容", "picture", 5L, 6L, true, true, true, false, false, new Date(), new Date(), "描述", 1L, 1L, 1L);
        blogMapper.addBlog(blog);
    }

    @Test
    public void updateBlogTest() {
        Blog blog = new Blog(2L, "博客3", "kjhkjhklkjhjkl", "picture", 5L, 6L, true, true, true, false, false, new Date(), new Date(), "描述", 1L, 1L, 1L);
        blogMapper.updateBlog(blog);
    }

    @Test
    public void deleteBlogTest() {
        blogMapper.deleteBlog(2L);
    }

    @Test
    public void getBlogByConditionTest() {
        List<Blog> res = blogMapper.getBlogByCondition(null, false, null);
        for (Blog re : res) {
            System.out.println(re);
        }

        //title模糊查询
        List<Blog> res2 = blogMapper.getBlogByCondition("博客", false, null);
        for (Blog re : res2) {
            System.out.println(re);
        }
    }

}

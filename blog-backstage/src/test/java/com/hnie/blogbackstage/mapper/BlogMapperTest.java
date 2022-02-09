package com.hnie.blogbackstage.mapper;

import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.entity.Tag;
import com.hnie.blogbackstage.mybatis.entity.Type;
import com.hnie.blogbackstage.mybatis.entity.User;
import com.hnie.blogbackstage.mybatis.mapper.BlogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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
        Blog blog = new Blog(10L, "博客2", "博客2内容",
                "picture", 5L, 6L, true, true, true,
                false, false, new Date(), new Date(), "原创", "description...", new ArrayList<>(), new Type(34L, null,null),
                new User(1L, null, null, null, null, null, null, new Date()), new ArrayList<>());
        blogMapper.addBlog(blog);
    }

    @Test
    public void updateBlogTest() {
        Blog blog = new Blog(2L, "博客3", "kjhkjhklkjhjkl", "picture", 5L, 6L, true, true, true, false, false, new Date(), new Date(), "原创", "description...", new ArrayList<>(), new Type(34L, null,null), new User(1L, null, null, null, null, null, new Date(), new
                Date()), new ArrayList<>());
        blogMapper.updateBlog(blog);
    }

    @Test
    public void deleteBlogTest() {
        blogMapper.deleteBlog(2L);
    }

    @Test
    public void getBlogByConditionTest() {
        //title模糊查询
        List<Blog> res2 = blogMapper.getBlogByCondition("博客", false, 22L);
        for (Blog re : res2) {
            System.out.println(re);
        }
    }

    @Test
    public void getBlogByTitleTest() {
        Blog blogByName = blogMapper.getBlogByTitle("博客3");
        if (blogByName != null) {
            System.out.println(blogByName);
        }

    }

    @Test
    public void updateViewTest() {
        blogMapper.updateViews(27L);
    }

}

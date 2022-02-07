package com.hnie.blogbackstage.service.impl;

import com.hnie.blogbackstage.NotFoundException;
import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.mapper.BlogMapper;
import com.hnie.blogbackstage.mybatis.mapper.TypeMapper;
import com.hnie.blogbackstage.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/26 15:34
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    @Autowired
    TypeMapper typeMapper;

    @Override
    public Blog getBlog(Long id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogMapper.getAllBlog();
    }

    @Override
    public Blog getBlogByTitle(String title) {
        return blogMapper.getBlogByTitle(title);
    }

    @Override
    public List<Blog> getBlogByCondition(String title,Boolean recommend,Long typeId) {
        return blogMapper.getBlogByCondition(title, recommend, typeId);
    }

    @Override
    public boolean saveBlog(Blog blog) {
        blog.setCommentCount(0L);
        blog.setView(0L);
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        int re = blogMapper.addBlog(blog);
        int ret = blogMapper.addBlogTag(blog);
        if (re > 0 && ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateBlog(Blog blog) {
        Blog blogById = blogMapper.getBlogById(blog.getId());
        if (blogById == null) {
            throw new NotFoundException("该博客不存在");
        }
        blog.setUpdateTime(new Date());
        //更新blog内容
        int re = blogMapper.updateBlog(blog);
        //更新blog_tag内容
        blogMapper.deleteBlogTag(blog);
        blogMapper.addBlogTag(blog);
        if (re > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteBlog(Long id) {
        blogMapper.deleteBlogTag(blogMapper.getBlogById(id));
        blogMapper.deleteBlog(id);
    }
}

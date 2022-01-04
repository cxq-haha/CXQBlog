package com.hnie.blogbackstage.service.impl;

import com.hnie.blogbackstage.NotFoundException;
import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.entity.Type;
import com.hnie.blogbackstage.mybatis.mapper.BlogMapper;
import com.hnie.blogbackstage.mybatis.mapper.TypeMapper;
import com.hnie.blogbackstage.service.BlogService;
import com.hnie.blogbackstage.service.transferEntiry.BlogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<BlogInfo> transferBlogInfoList(List<Blog> blogs) {
        List<BlogInfo> blogInfos = new ArrayList<>();
        for (Blog blog : blogs) {
            BlogInfo blogInfo = new BlogInfo();
            blogInfo.setId(blog.getId());
            blogInfo.setTitle(blog.getTitle());
            Type type = typeMapper.getTypeById(blog.getTypeId());
            if (type == null) {
                throw new NotFoundException("not found type of id " + blog.getTypeId());
            }
            blogInfo.setType(type.getName());
            blogInfo.setRecommend(blog.isRecommend());
            blogInfo.setUpdateTime( blog.getUpdateTime());
            blogInfos.add(blogInfo);
        }
        return blogInfos;
    }

    @Override
    public List<Blog> getBlogByCondition(String title,Boolean recommend,String type) {
        return blogMapper.getBlogByCondition(title, recommend, type);
    }

    @Override
    public boolean saveBlog(Blog blog) {
        int re = blogMapper.addBlog(blog);
        if (re > 0) {
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
        int re = blogMapper.updateBlog(blog);
        if (re > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteBlog(Long id) {
        blogMapper.deleteBlog(id);
    }
}

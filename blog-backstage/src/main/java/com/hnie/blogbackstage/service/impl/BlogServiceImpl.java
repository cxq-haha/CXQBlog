package com.hnie.blogbackstage.service.impl;

import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.mapper.BolgMapper;
import com.hnie.blogbackstage.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/20 17:59
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BolgMapper blogMapper;

    @Override
    public void showBlog() {
        List<Blog> allBlog = blogMapper.getAllBlog();
        for (Blog blog : allBlog) {
            System.out.println(blog);
        }
    }
}

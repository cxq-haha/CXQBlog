package com.hnie.blogbackstage.service;

import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.service.transferEntiry.BlogInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/26 15:31
 */
public interface BlogService {

    //根据Id获取Blog
    Blog getBlog(Long id);

    //查询所有的Blog
    List<Blog> getAllBlog();

    //根据名臣查询Blog
    Blog getBlogByTitle(String title);

    //将Blog列表转化成BlogInfo列表
    List<BlogInfo> transferBlogInfoList(List<Blog> blogs);

    //条件查询Blog
    List<Blog> getBlogByCondition(String title, Boolean recommend, String type);

    //添加一个Blog
    boolean saveBlog(Blog blog);

    //更新Blog
    boolean updateBlog( Blog blog);

    //删除Blog
    void deleteBlog(Long id);
}

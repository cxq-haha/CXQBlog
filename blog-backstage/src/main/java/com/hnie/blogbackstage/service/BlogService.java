package com.hnie.blogbackstage.service;

import com.hnie.blogbackstage.mybatis.entity.Blog;

import java.util.List;
import java.util.Map;

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

    //条件查询Blog
    List<Blog> getBlogByCondition(String title, Boolean recommend, Long typeId);

    //添加一个Blog
    boolean saveBlog(Blog blog);

    //更新Blog
    boolean updateBlog( Blog blog);

    //删除Blog
    void deleteBlog(Long id);

    //查询最新的size个blog
    List<Blog> listSizeTop(Integer size);

    //将blog的正文转换成html
    Blog getBlogAndConvert(Long id);

    //根据typeId获取blog
    List<Blog> getBlogsByTypeId(Long typeId);

    //根据tagId获取blog
    List<Blog> getBlogsByTagId(Long id);

    //blog归档
    Map<String, List<Blog>> archivesBlog();

    //获取Blog总数
    Integer blogCount();

    List<Blog> searchBlogsByTitle(String key);
}

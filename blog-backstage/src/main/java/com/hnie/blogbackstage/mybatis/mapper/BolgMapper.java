package com.hnie.blogbackstage.mybatis.mapper;


import com.hnie.blogbackstage.mybatis.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/20 17:12
 */
@Mapper
@Repository
public interface BolgMapper {
    //获取所有Blog
    List<Blog> getAllBlog();
    //保存Blog
    //更新Blog
    //删除Blog
    //获取第一个页面的博客
}

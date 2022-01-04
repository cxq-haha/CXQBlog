package com.hnie.blogbackstage.mybatis.mapper;

import com.hnie.blogbackstage.mybatis.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/26 15:35
 */
@Repository
@Mapper
public interface BlogMapper {

    //根据ID查找Blog
    Blog getBlogById(@Param("id") Long id);

    //根据条件查询Blog
    List<Blog> getBlogByCondition(@Param("title") String title,@Param("recommend") Boolean recommend,@Param("type") String type);

    //获取所有的Blog
    List<Blog> getAllBlog();

    //添加一个Blog
    int addBlog(Blog blog);

    //更新一个Blog
    int updateBlog(Blog blog);

    //删除指定ID的Blog
    int deleteBlog(@Param("id") Long id);

}

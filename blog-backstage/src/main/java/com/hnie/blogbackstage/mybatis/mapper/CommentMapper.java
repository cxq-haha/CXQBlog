package com.hnie.blogbackstage.mybatis.mapper;

import com.hnie.blogbackstage.mybatis.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :CXQ
 * @description :
 * @create :2022-02-10 13:52:00
 */
@Mapper
@Repository
public interface CommentMapper {
    //根据blogId查找Comment
    List<Comment> getCommentsByBlogId(@Param("blogId") Long blogId);

    //根据评论Id查找子评论
    List<Comment> getChildCommentsById(@Param("id") Long id);

}

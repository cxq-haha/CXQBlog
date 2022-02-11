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

    //添加comment
    void addComment(Comment comment);

    //根据Id获取父评论Id
    Long getParentCommentId(@Param("childId") Long childId);

    //根据id查找nickname
    String getNicknameById(@Param("id") Long id);
}

package com.hnie.blogbackstage.service;

import com.hnie.blogbackstage.mybatis.entity.Comment;

import java.util.List;

/**
 * @author :CXQ
 * @description :
 * @create :2022-02-10 16:01:00
 */
public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);
}

package com.hnie.blogbackstage.service.impl;

import com.hnie.blogbackstage.mybatis.entity.Comment;
import com.hnie.blogbackstage.mybatis.mapper.CommentMapper;
import com.hnie.blogbackstage.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :CXQ
 * @description :
 * @create :2022-02-10 16:02:00
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        return commentMapper.getCommentsByBlogId(blogId);
    }
}

package com.hnie.blogbackstage.service.impl;

import com.hnie.blogbackstage.mybatis.entity.Comment;
import com.hnie.blogbackstage.mybatis.mapper.CommentMapper;
import com.hnie.blogbackstage.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public void saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        Long parentCommentId = comment.getParentComment().getId();
        if (parentCommentId == -1) {//如果没有指定回复人，作为一级评论
            comment.getParentComment().setId(null);
        } else if (commentMapper.getParentCommentId(parentCommentId) != null) {//被回复的评论是二级评论，将被回复的评论设置为其父评论
            comment.setParentNickname(commentMapper.getNicknameById(parentCommentId));
            comment.getParentComment().setId(commentMapper.getParentCommentId(parentCommentId));
        } else {
            comment.setParentNickname(commentMapper.getNicknameById(parentCommentId));
        }
        commentMapper.addComment(comment);
    }
}

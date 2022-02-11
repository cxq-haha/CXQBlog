package com.hnie.blogbackstage.mapper;

import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.entity.Comment;
import com.hnie.blogbackstage.mybatis.mapper.CommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @author :CXQ
 * @description :
 * @create :2022-02-10 14:09:00
 */
@SpringBootTest
public class CommentMapperTest {
    @Autowired
    CommentMapper commentMapper;

    @Test
    public void getCommentsByBlogIdTest() {
        List<Comment> ret = commentMapper.getCommentsByBlogId(28L);
        System.out.println(ret);
    }

    @Test
    public void getCommentsByIdTest() {
        List<Comment> ret = commentMapper.getChildCommentsById(2L);
        System.out.println(ret);
    }

    @Test
    public void addCommentTest() {
        Blog blog = new Blog();
        blog.setId(28L);
        Comment parentComment = new Comment();
        parentComment.setId(null);

        Comment comment = new Comment(null, "评论content", new Date(), false, "jjjjjjj", "234534@qq.com", "张三","萌萌哒", blog, null, parentComment);
        commentMapper.addComment(comment);

    }


    @Test
    public void getParentCommentIdTest() {
        Long parentCommentId1 = commentMapper.getParentCommentId(1L);
        Long parentCommentId2 = commentMapper.getParentCommentId(2L);
        Long parentCommentId3 = commentMapper.getParentCommentId(3L);
        Long parentCommentId4 = commentMapper.getParentCommentId(4L);
        System.out.println(parentCommentId1 + parentCommentId2 + parentCommentId3 + parentCommentId4);
    }
}

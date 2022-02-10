package com.hnie.blogbackstage.mapper;

import com.hnie.blogbackstage.mybatis.entity.Comment;
import com.hnie.blogbackstage.mybatis.mapper.CommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}

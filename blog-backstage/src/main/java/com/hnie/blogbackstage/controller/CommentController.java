package com.hnie.blogbackstage.controller;

import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.entity.Comment;
import com.hnie.blogbackstage.mybatis.entity.User;
import com.hnie.blogbackstage.service.BlogService;
import com.hnie.blogbackstage.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author :CXQ
 * @description :
 * @create :2022-02-10 16:01:00
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${myblog.comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        Blog blog = new Blog();
        blog.setId(blogId);
        model.addAttribute("blog", blog);
        return "blog::commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session) {
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            comment.setAvatar(avatar);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }
}

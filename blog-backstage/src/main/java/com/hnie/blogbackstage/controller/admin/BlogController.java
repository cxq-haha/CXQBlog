package com.hnie.blogbackstage.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.entity.Type;
import com.hnie.blogbackstage.service.BlogService;
import com.hnie.blogbackstage.service.TypeService;
import com.hnie.blogbackstage.service.transferEntiry.BlogInfo;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/23 12:16
 */
@Controller
@RequestMapping("/admin")
public class BlogController {


    @Autowired
    BlogService blogService;

    @Autowired
    TypeService typeService;

    //跳转到博客列表
    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        String orderBy = "id asc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Blog> blogs = blogService.getAllBlog();
        List<BlogInfo> blogInfos = blogService.transferBlogInfoList(blogs);
        PageInfo<BlogInfo> pageInfo = new PageInfo<>(blogInfos);
        model.addAttribute("pageInfo", pageInfo);

        List<Type> types = typeService.listType();
        model.addAttribute("types", types);
        return "/admin/blogs";
    }
}

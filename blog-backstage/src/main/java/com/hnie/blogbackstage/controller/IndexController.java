package com.hnie.blogbackstage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnie.blogbackstage.NotFoundException;
import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.entity.Tag;
import com.hnie.blogbackstage.mybatis.entity.Type;
import com.hnie.blogbackstage.service.BlogService;
import com.hnie.blogbackstage.service.TagService;
import com.hnie.blogbackstage.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    BlogService blogService;

    @Autowired
    TypeService typeService;

    @Autowired
    TagService tagService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        String orderBy = "b.id asc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Blog> blogs = blogService.getAllBlog();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);

        List<Type> types = typeService.listSizeTop(6);
        model.addAttribute("types", types);

        List<Tag> tags = tagService.listSizeTop(10);
        model.addAttribute("tags", tags);

        List<Blog> newBLogs = blogService.listSizeTop(7);
        model.addAttribute("newBLogs", newBLogs);

        return "index";
    }

    @PostMapping("/search")
    public String search(Model model,@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,@RequestParam("query") String query) {
        String orderBy = "b.id asc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Blog> blogs = blogService.searchBlogsByTitle(query);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model) {
        model.addAttribute("blog", blogService.getBlogAndConvert(id));
        return "blog";
    }

}

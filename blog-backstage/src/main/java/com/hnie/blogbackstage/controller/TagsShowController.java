package com.hnie.blogbackstage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.entity.Tag;
import com.hnie.blogbackstage.service.BlogService;
import com.hnie.blogbackstage.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author :CXQ
 * @description :
 * @create :2022-02-09 18:14:00
 */
@Controller
public class TagsShowController {

    @Autowired
    TagService tagService;

    @Autowired
    BlogService blogService;

    @GetMapping("/tags/{id}")
    public String types(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @PathVariable Long id, Model model) {
        List<Tag> tags = tagService.listSizeTop(-1);
        System.out.println("tags:" + tags);
        if (id == -1) {
            id = tags.get(0).getId();
        }
        model.addAttribute("tags", tags);
        List<Blog> blogs = blogService.getBlogsByTagId(id);

        PageHelper.startPage(pageNum, 10);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTag", tagService.getTagById(id));
        return "tags";
    }
}

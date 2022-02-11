package com.hnie.blogbackstage.controller;

import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.service.BlogService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

/**
 * @author :CXQ
 * @description :
 * @create :2022-02-11 14:04:00
 */
@Controller
public class ArchiveShowController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model) {
        model.addAttribute("archiveMap", blogService.archivesBlog());
        model.addAttribute("blogCount", blogService.blogCount());
        return "archives";
    }
}

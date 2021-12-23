package com.hnie.blogbackstage.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/23 12:16
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
    @GetMapping("/blogs")
    public String list() {
        return "/admin/blogs";
    }
}

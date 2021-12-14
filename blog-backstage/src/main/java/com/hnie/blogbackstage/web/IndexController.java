package com.hnie.blogbackstage.web;

import com.hnie.blogbackstage.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
//        String blog = null;
//        if (blog == null) {
//            throw new  NotFoundException("博客不存在");
//        }
        System.out.println("----------index-----------");
        return "index";
    }

}

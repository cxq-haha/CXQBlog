package com.hnie.blogbackstage.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnie.blogbackstage.mybatis.entity.Type;
import com.hnie.blogbackstage.service.TypeService;
import com.hnie.blogbackstage.service.impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/23 14:33
 */
@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    TypeServiceImpl typeService;

    @GetMapping("/types")
    public String types(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        String orderBy = "id asc";
        PageHelper.startPage(pageNum, 10, orderBy);//根据Id排序
        List<Type> types = typeService.listType();
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        model.addAttribute("pageInfo", pageInfo);
        return "/admin/types";
    }

    @GetMapping("/types/input")
    public String input() {
        return "/admin/types-input";
    }

    @PostMapping("/types")
    public String post(Type type) {
        Boolean re = typeService.saveType(type);
        if (re) {//保存成功

        } else {//保存失败

        }
        return "redirect:/admin/types";
    }
}

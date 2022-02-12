package com.hnie.blogbackstage.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnie.blogbackstage.mybatis.entity.Tag;
import com.hnie.blogbackstage.mybatis.entity.Tag;
import com.hnie.blogbackstage.service.TagService;
import com.hnie.blogbackstage.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


/**
 * @Author: chenxueqin
 * @Date: 2021/12/27 22:03
 */
@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    TagService tagService;

    @RequestMapping("/tags")
    public String tags(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        String orderBy = "id asc";
        PageHelper.startPage(pageNum, 10, orderBy);//根据Id排序
        List<Tag> tags = tagService.listTag();
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags";
    }

    //添加标签页面
    @GetMapping("/tags/input")
    public String input() {
        return "admin/tags-input";
    }

    //添加标签后跳转到标签页面
    @PostMapping("/tags")
    public String post(Tag tag, RedirectAttributes attributes) {
        //后端校验--类型名是否重复
        Tag tagByName = tagService.getTagByName(tag.getName());
        if (tagByName != null) {
            attributes.addFlashAttribute("message", "该标签已经存在，不能添加重复的标签!");
            return "redirect:admin/tags/input";
        }
        Boolean re = tagService.saveTag(tag);
        if (re) {//保存成功
            attributes.addFlashAttribute("message", "添加成功!");
        } else {//保存失败
            attributes.addFlashAttribute("message", "添加失败!");
        }
        return "redirect:admin/tags";
    }

    //修改标签后跳转到标签页面
    @PostMapping("/tags/{id}")
    public String editPost(Tag tag, RedirectAttributes attributes) {
        //后端校验--类型名是否重复
        Tag tagByName = tagService.getTagByName(tag.getName());
        if (tagByName != null) {
            attributes.addFlashAttribute("message", "该标签已经存在，不能设置重复的标签!");
            attributes.addFlashAttribute("tag", tag);
            return "redirect:admin/tags/input";
        }
        Boolean re = tagService.updateTag(tag);
        if (re) {//保存成功
            attributes.addFlashAttribute("message", "修改成功!");
        } else {//保存失败
            attributes.addFlashAttribute("message", "修改失败!");
        }
        return "redirect:admin/tags";
    }

    //修改类型
    @GetMapping("/tags/{id}/input")
    public String editTag(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getTagById(id));
        return "admin/tags-input";
    }

    //删除类型
    @GetMapping("/tags/{id}/delete")
    public String deleteTag(@PathVariable Long id, RedirectAttributes attributes) {
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message", "删除成功!");
        return "redirect:admin/tags";
    }

}

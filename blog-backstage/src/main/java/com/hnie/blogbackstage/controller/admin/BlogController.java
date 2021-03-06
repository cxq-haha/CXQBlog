package com.hnie.blogbackstage.controller.admin;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnie.blogbackstage.NotFoundException;
import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.entity.Tag;
import com.hnie.blogbackstage.mybatis.entity.Type;
import com.hnie.blogbackstage.mybatis.entity.User;
import com.hnie.blogbackstage.mybatis.mapper.BlogMapper;
import com.hnie.blogbackstage.service.BlogService;
import com.hnie.blogbackstage.service.TagService;
import com.hnie.blogbackstage.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/23 12:16
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
    private static final String INPUT = "admin/blogs-input";
    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";
    private static final String REDIRECT_INPUT = "redirect:/admin/blogs-input";

    @Autowired
    BlogService blogService;

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    TypeService typeService;

    @Autowired
    TagService tagService;

    //跳转到博客列表
    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        String orderBy = "b.id asc";
        PageHelper.startPage(pageNum, 10);
        List<Blog> blogs = blogService.getAllBlog();

        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);

        List<Type> types = typeService.listType();
        model.addAttribute("types", types);
        return LIST;
    }

    //点击添加按钮跳转到博客新增页面
    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("blog", new Blog());
        return INPUT;
    }

    //点击修改按钮跳转文章修改页面
    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        Blog blog = blogService.getBlog(id);
        List<Tag> tags = blog.getTags();
        List<Long> tagIds = tags.stream().map(a -> a.getId()).collect(Collectors.toList());
        model.addAttribute("blog", blog);
        model.addAttribute("types", typeService.listType());
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("tagIds", tagIds);
        return INPUT;
    }

    //删除blog
    @GetMapping("/blogs/{id}/delete")
    public String editDelete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("message", "博客删除成功！");
        return REDIRECT_LIST;
    }

    //编辑已有的blog保存跳转到blog列表页面
    @PostMapping("/blogs/{id}")
    public String updateBlog(Blog blog,@RequestParam HashMap<String, String> param, RedirectAttributes attributes) {
        String tagIdStr = param.get("tagIds");
        String[] tagIds = tagIdStr.split(",");
        ArrayList<Tag> tagList = new ArrayList<>();
        for (String id : tagIds) {
            if (id != null && !id.equals("")) {
                tagList.add(tagService.getTagById(Long.valueOf(id)));
            }
        }
        blog.setTags(tagList);
        Type type = typeService.getTypeById(blog.getType().getId());
        blog.setType(type);
        boolean re = blogService.updateBlog(blog);
        if (re) {
            attributes.addFlashAttribute("message", "博客修改成功！");
            return REDIRECT_LIST;
        } else {
            throw new NotFoundException("博客修改失败！");
        }
    }

    //点击搜索按钮重定向到blog列表页面
    @PostMapping("/blogs/search")
    public String search(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam HashMap<String, String> jsonInfo) {
        String orderBy = "b.id asc";
        PageHelper.startPage(pageNum, 10, orderBy);
        String title = jsonInfo.get("title");
        String typeStr = jsonInfo.get("type");
        Long type = 0L;
        if (typeStr != "" && typeStr != null) {
             type = Long.valueOf(jsonInfo.get("type"));
        }
        Boolean recommend = Boolean.valueOf(jsonInfo.get("recommend"));
        List<Blog> blogs = blogService.getBlogByCondition(title, recommend, type);

        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);

        List<Type> types = typeService.listType();
        model.addAttribute("types", types);
        return "admin/blogs::blogList";
    }

    @PostMapping("/blogs")
    public String post(Blog blog, HttpSession session, RedirectAttributes attributes, @RequestParam HashMap<String, String> param) {
        //重复Blog校验
        Blog blogByName = blogService.getBlogByTitle(blog.getTitle());
        if (blogByName != null) {
            attributes.addFlashAttribute("message", "该博客已经存在，不能添加重复的博客");
            return REDIRECT_INPUT;
        }
        User user = (User) session.getAttribute("user");
        blog.setUser(user);
        Type type = typeService.getTypeById(blog.getType().getId());
        blog.setType(type);
        String tagIdStr = param.get("tagIds");
        String[] tagIds = tagIdStr.split(",");
        ArrayList<Tag> tagList = new ArrayList<>();
        for (String id : tagIds) {
            tagList.add(tagService.getTagById(Long.valueOf(id)));
        }
        blog.setTags(tagList);
        boolean ret = blogService.saveBlog(blog);
        if (ret) {
            attributes.addFlashAttribute("message", "添加成功！");
        } else {
            attributes.addFlashAttribute("message", "添加失败！");
        }
        return REDIRECT_LIST;
    }
}

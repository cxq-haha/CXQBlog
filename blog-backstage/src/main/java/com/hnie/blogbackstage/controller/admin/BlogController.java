package com.hnie.blogbackstage.controller.admin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnie.blogbackstage.mybatis.entity.Blog;
import com.hnie.blogbackstage.mybatis.entity.Tag;
import com.hnie.blogbackstage.mybatis.entity.Type;
import com.hnie.blogbackstage.mybatis.entity.User;
import com.hnie.blogbackstage.service.BlogService;
import com.hnie.blogbackstage.service.TagService;
import com.hnie.blogbackstage.service.TypeService;
import com.hnie.blogbackstage.service.transferEntiry.BlogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/23 12:16
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
    private static final String INPUT = "/admin/blogs-input";
    private static final String LIST = "/admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";
    private static final String REDIRECT_INPUT = "redirect:/admin/blogs-input";

    @Autowired
    BlogService blogService;

    @Autowired
    TypeService typeService;

    @Autowired
    TagService tagService;

    //跳转到博客列表
    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        String orderBy = "b.id asc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Blog> blogs = blogService.getAllBlog();
        List<BlogInfo> blogInfos = blogService.transferBlogInfoList(blogs);
        PageInfo<BlogInfo> pageInfo = new PageInfo<>(blogInfos);
        model.addAttribute("pageInfo", pageInfo);

        List<Type> types = typeService.listType();
        model.addAttribute("types", types);
        return LIST;
    }


    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("blog", new Blog());
        return INPUT;
    }

    @PostMapping("/blogs/search")
    public String search(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam HashMap<String, String> jsonInfo) {
        String title = jsonInfo.get("title");
        Long type = Long.valueOf( jsonInfo.get("type"));
        Boolean recommend = Boolean.valueOf(jsonInfo.get("recommend"));
        List<Blog> blogs = blogService.getBlogByCondition(title, recommend, typeService.getTypeById(type).getName());
        List<BlogInfo> blogInfos = blogService.transferBlogInfoList(blogs);

        String orderBy = "id asc";
        PageInfo<BlogInfo> pageInfo = new PageInfo<>(blogInfos);
        model.addAttribute("pageInfo", pageInfo);

        List<Type> types = typeService.listType();
        model.addAttribute("types", types);
        return REDIRECT_LIST;
    }

    @PostMapping("/blogs")
    public String post(Blog blog, HttpSession session, RedirectAttributes attributes,@RequestParam HashMap<String,String> param) {
        //重复Blog校验
        Blog blogByName = blogService.getBlogByTitle(blog.getTitle());
        if (blogByName != null) {
            attributes.addFlashAttribute("message", "该博客已经存在，不能添加重复的博客");
            return REDIRECT_INPUT;
        }
        User user = (User) session.getAttribute("user");
        blog.setUser(user);
        Type type = typeService.getTypeById(Long.valueOf(param.get("typeId")));
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

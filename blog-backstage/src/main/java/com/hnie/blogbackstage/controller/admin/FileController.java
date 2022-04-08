package com.hnie.blogbackstage.controller.admin;


import com.hnie.blogbackstage.mybatis.entity.Image;
import com.hnie.blogbackstage.util.FileUtil;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class FileController {
    @GetMapping("/images")
    public String images() {
        return "admin/photos";
    }

    @GetMapping("/images/input")
    public String imagesInput() {
        return "admin/photos-input";
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @Value(value = "${myblog.file-repository.host}")
    private String host;

    @Value(value = "${myblog.file-repository.port}")
    private String port;

    @PostMapping("/saveImages")
    public void save(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException {
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = mRequest.getFileMap();
        Collection<MultipartFile> values = fileMap.values();

        ArrayList<String> urls = new ArrayList<>();

        for (MultipartFile multipartFile : values) {
            Image image = new Image();
            image.setName(multipartFile.getOriginalFilename());
            image.setCreatedTime(new Date());
            image.setContent(new Binary(multipartFile.getBytes()));
            image.setContentType(multipartFile.getContentType());
            image.setSize(multipartFile.getSize());

            Image savImg = mongoTemplate.save(image);

            //获取图片后缀
            String postFix = FileUtil.getFilePostFix(savImg.getName());

            String url = "http://" + host + ":" + port + "/admin/file/image/" + savImg.getId() + postFix;
            System.out.println("save image to mongoDB : " + url);
            urls.add(url);
        }
        model.addAttribute("message", "上传成功");

        //解决ajax重定向问题
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            //告诉ajax我是重定向
            response.setHeader("REDIRECT", "REDIRECT");
            //告诉ajax我重定向的路径
            response.setHeader("CONTENTPATH", "/admin/images");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.sendRedirect("/admin/images");
        }
    }


    @GetMapping(value = "/file/image/{fileName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] image(@PathVariable String fileName) {
        //去除后缀
        String id = FileUtil.removeFilePostFix(fileName);

        byte[] data = null;
        Image image = mongoTemplate.findById(id, Image.class);
        if (image != null) {
            data = image.getContent().getData();
        }
        return data;
    }
}

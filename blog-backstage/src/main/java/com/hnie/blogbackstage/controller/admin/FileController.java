package com.hnie.blogbackstage.controller.admin;


import com.hnie.blogbackstage.mybatis.entity.Image;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;


@Controller
public class FileController {
    @RequestMapping("/admin/images")
    public String te() {
        return "admin/photos-input";
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @Value(value = "${myblog.file-repository.host}")
    private String host;

    @Value(value = "${myblog.file-repository.port}")
    private String port;

    @RequestMapping("/admin/saveImages")
//    @ResponseBody
    public String save(HttpServletRequest request, Model model) throws IOException {
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
            String url = "http://" + host + ":" + port + "/file/image/" + savImg.getId();
            System.out.println("save image to mongoDB : " + url);
            urls.add(url);
        }
        model.addAttribute("message", "上传成功");
        model.addAttribute("urls", urls);
        return "redirect:/admin/photos-input";
    }



    @GetMapping(value = "/file/image/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] image(@PathVariable String id){
        byte[] data = null;
        Image image = mongoTemplate.findById(id, Image.class);
        if (image != null) {
            data = image.getContent().getData();
        }
        return data;
    }
}

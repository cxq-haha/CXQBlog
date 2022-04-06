package com.hnie.blogbackstage.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@Controller
public class FileController {
    @RequestMapping("test")
    public String te() {
        return "admin/photos-input";
    }

    @RequestMapping("/imgupload")
    @ResponseBody
    public String test(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = mRequest.getFileMap();
        Collection<MultipartFile> values = fileMap.values();
        for (MultipartFile value : values) {
            System.out.println("Name   " + value.getName());
            System.out.println("OriginalFilename   " + value.getOriginalFilename());
            System.out.println("Size   " + value.getSize());
            System.out.println("Resource   " + value.getResource());
            System.out.println("ContentType   " + value.getContentType());
            System.out.println("Bytes   " + value.getBytes());
            System.out.println();
        }
        return "admin/photos-input";
    }
}

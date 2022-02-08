package com.hnie.blogbackstage.mybatis.entity;


import lombok.*;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/16 16:49
 * @Description: 标签实体类
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Tag {
    private Long id;            //id
    private String name;        //标签名称

    private List<Blog> blogs;   //该标签的所有blog

    private Integer blogCount;  //博客数量

    public Tag(Long id, String name, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }
}

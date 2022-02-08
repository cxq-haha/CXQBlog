package com.hnie.blogbackstage.mybatis.entity;

import lombok.*;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/16 16:47
 * @Description: 分类实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Type {
    private Long id;            //id
    private String name;        //分类名称

    private List<Blog> blogs;   //该分类下的所有blog

    private Integer blogCount;

    public Type(Long id, String name, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }
}

package com.hnie.blogbackstage.pojo;

import lombok.*;

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
    private Long id;        //id
    private String name;    //分类名称
}

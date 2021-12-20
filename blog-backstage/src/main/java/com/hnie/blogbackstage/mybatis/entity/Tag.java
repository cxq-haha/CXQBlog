package com.hnie.blogbackstage.mybatis.entity;


import lombok.*;

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
    private Long id;        //id
    private String name;    //标签名称
}

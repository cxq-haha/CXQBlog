package com.hnie.blogbackstage.pojo;


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

package com.hnie.blogbackstage.pojo;

import lombok.*;

import java.util.Date;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/16 16:56
 * 用户实体类
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private Long id;
    private String username;    //用户名
    private String password;    //密码
    private String email;       //邮箱
    private String avatar;      //头像
    private String type;        //用户类型
    private Date createTime;    //创建时间
    private Date updateTime;    //更新时间
}

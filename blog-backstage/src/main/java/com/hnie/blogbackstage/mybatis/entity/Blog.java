package com.hnie.blogbackstage.mybatis.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/16 16:34
 * @Description: 博客实体类
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Blog {
    private Long id;                //id
    private String title;           //标题
    private String content;         //内容
    private String firstPicture;    //首图
    private Long view;              //浏览次数
    private Long commentCount;      //评论数
    private boolean appreciation;   //赞赏是否开启
    private boolean shareStatement; //版权是否开启
    private boolean commentabled;   //评论是否开启
    private boolean published;      //是否发布
    private boolean recommend;      //是否推荐
    private Date createTime;        //创建时间
    private Date updateTime;        //更新时间
    private String description;     //博客描述

    /*外键*/
    private Long typeId;            //博客类型id
    private Long userId;            //用户id
    private Long tagId;             //标签id


    private Type type;
    private User user;
    private List<Comment> comments = new ArrayList<>();
}

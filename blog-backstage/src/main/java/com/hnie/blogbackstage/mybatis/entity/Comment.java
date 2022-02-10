package com.hnie.blogbackstage.mybatis.entity;

import lombok.*;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/16 16:52
 * @Discription: 评论实体类
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Comment {
    private Long id;                    //id
    private String content;             //评论内容
    private Date createTime;            //创建时间
    private boolean adminComment;       //是否是管理员评论
    private String avatar;              //头像
    private String email;               //邮箱
    private String nickname;            //昵称

    /*外键*/
    private Blog blog;
    private List<Comment> replyComments;//回复的评论（子评论）
    private Comment parentComment;

}

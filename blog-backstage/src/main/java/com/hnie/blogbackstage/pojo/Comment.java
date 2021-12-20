package com.hnie.blogbackstage.pojo;

import lombok.*;

import java.util.Date;

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

    /*外键*/
    private Long uerId;                 //评论者Id
    private Long blogId;                //博客id
    private Long parentCommentId;       //父级评论id

//    private DetailedBlog blog;
}

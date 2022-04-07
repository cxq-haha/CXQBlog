package com.hnie.blogbackstage.mybatis.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document
@Accessors(chain = true)
public class Image {

    @Id
    private String id;
    /** 文件名 */
    private String name;
    /** 上传时间 */
    private Date createdTime;
    /** 文件内容 */
    private Binary content;
    /** 文件类型 */
    private String contentType;
    /** 文件大小 */
    private long size;

}


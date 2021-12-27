package com.hnie.blogbackstage.service.transferEntiry;

import lombok.*;

import java.util.Date;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/27 15:26
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogInfo {
    Long id;
    String title;
    String type;
    boolean recommend;
    Date updateTime;
}


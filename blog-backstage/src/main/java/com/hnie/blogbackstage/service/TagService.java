package com.hnie.blogbackstage.service;

import com.hnie.blogbackstage.mybatis.entity.Tag;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/27 22:04
 */
public interface TagService {
    //查询所有的标签
    List<Tag> listTag();

    //根据Id查询标签
    Tag getTagById(Long id);

    //根据名称查询标签
    Tag getTagByName(String name);

    //保存Tag
    Boolean saveTag(Tag tag);

    //删除Tag
    void deleteTag(Long id);

    //修改Tag
    Boolean updateTag(Tag tag);

    List<Tag> listSizeTop(Integer size);
}

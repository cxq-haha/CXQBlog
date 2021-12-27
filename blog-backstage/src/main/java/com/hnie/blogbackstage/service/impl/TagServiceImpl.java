package com.hnie.blogbackstage.service.impl;

import com.hnie.blogbackstage.mybatis.entity.Tag;
import com.hnie.blogbackstage.mybatis.mapper.TagMapper;
import com.hnie.blogbackstage.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/27 22:09
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> listTag() {
        return tagMapper.getAllTag();
    }

    @Override
    public Tag getTagById(Long id) {
        return tagMapper.getTagById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    public Boolean saveTag(Tag tag) {
        int re = tagMapper.addTag(tag);
        if (re > 0) {
            return true;
        } else {
            return true;
        }
    }

    @Override
    public void deleteTag(Long id) {
        tagMapper.deleteTag(id);
    }

    @Override
    public Boolean updateTag(Tag tag) {
        int re = tagMapper.updateTag(tag);
        if (re > 0) {
            return true;
        } else {
            return true;
        }
    }
}

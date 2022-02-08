package com.hnie.blogbackstage.mapper;

import com.hnie.blogbackstage.mybatis.entity.Tag;
import com.hnie.blogbackstage.mybatis.mapper.TagMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/27 22:19
 */
@SpringBootTest
public class TagMapperTest {
    @Autowired
    TagMapper tagMapper;
    @Test
    public void getAllTagTest() {
        List<Tag> allTag = tagMapper.getAllTag();
        for (Tag tag : allTag) {
            System.out.println(tag);
        }
    }
    @Test
    public void getTagByIdTest() {
        tagMapper.getTagById(1L);
    }

    @Test
    public void getTagByNameTest() {
        Tag tag = tagMapper.getTagByName("C++");
        System.out.println(tag);
    }

    @Test
    public void addTagTest() {
        Tag tag = new Tag(2L, "Java",null);
        tagMapper.addTag(tag);
    }

    @Test
    public void deleteTagTest() {
        tagMapper.deleteTag(1L);
    }

    @Test
    public void updateTagTest() {
        Tag tag = new Tag(2L, "Python",null);
        tagMapper.updateTag(tag);
    }

    @Test
    public void getTagsLimitTest() {
        List<Tag> tagsLimit = tagMapper.getTagsLimit(3);
        System.out.println(tagsLimit);
    }
}

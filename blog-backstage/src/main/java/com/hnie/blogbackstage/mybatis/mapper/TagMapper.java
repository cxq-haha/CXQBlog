package com.hnie.blogbackstage.mybatis.mapper;

import com.hnie.blogbackstage.mybatis.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/27 22:09
 */
@Repository
@Mapper
public interface TagMapper {
    //查询所有Tag
    List<Tag> getAllTag();

    //根据Id查询Tag
    Tag getTagById(@Param("id") Long id);

    //根据名称查询Tag
    Tag getTagByName(@Param("name") String name);

    //添加Tag
    int addTag(Tag tag);

    //删除Tag
    int deleteTag(@Param("id") Long id);

    //更新Tag
    int updateTag(Tag tag);

    List<Tag> getTagsLimit(@Param("size") Integer size);
}

package com.hnie.blogbackstage.mybatis.mapper;

import com.hnie.blogbackstage.mybatis.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/23 13:32
 */
@Repository
@Mapper
public interface TypeMapper {
    //添加一个type
    int addType( Type type);

    //根据Id删除一个Type
    int deleteTypeById(@Param("id") Long id);

    //根据Id查询type
    Type getTypeById(@Param("id") Long id);

    //根据名称查询type
    Type getTypeByName(@Param("name")String name);

    //修改一个Type
    int updateType(Type type);

    //查询所有的Type
    List<Type> getAllType();

}

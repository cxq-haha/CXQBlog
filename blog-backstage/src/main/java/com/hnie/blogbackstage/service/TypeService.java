package com.hnie.blogbackstage.service;

import com.hnie.blogbackstage.mybatis.entity.Type;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/23 13:27
 */
public interface TypeService {
    //保存Type
    Boolean saveType(Type type);

    //根据Id查询Type
    Type getTypeById(Long id);

    //根据名称查找Type
    Type getTypeByName(String name);

    Long getIdByName(String name);

    //查询所有的Type（暂时不进行分页查询）
    List<Type> listType();

    //修改Type
    Boolean updateType( Type type);

    //删除Type
    void deleteType(Long id);
}

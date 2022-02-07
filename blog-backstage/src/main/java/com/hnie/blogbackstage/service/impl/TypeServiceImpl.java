package com.hnie.blogbackstage.service.impl;

import com.hnie.blogbackstage.mybatis.entity.Type;
import com.hnie.blogbackstage.mybatis.mapper.TypeMapper;
import com.hnie.blogbackstage.service.TypeService;
import jdk.nashorn.internal.codegen.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/23 13:31
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;

    @Override

    public Boolean saveType(Type type) {
        int re = typeMapper.addType(type);
        if (re > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Type getTypeById(Long id) {
        return typeMapper.getTypeById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    public Long getIdByName(String name) {
        return typeMapper.getIdByName(name);
    }

    @Override
    public List<Type> listType() {
        return typeMapper.getAllType();
    }

    @Override
    public Boolean updateType( Type type) {
        int re = typeMapper.updateType(type);
        if (re > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteType(Long id) {
        typeMapper.deleteTypeById(id);
    }

    @Override
    public List<Type> listSizeTop(Integer size) {
        return typeMapper.getTypesLimit(size);
    }
}

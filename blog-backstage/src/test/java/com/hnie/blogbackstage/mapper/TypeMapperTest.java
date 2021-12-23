package com.hnie.blogbackstage.mapper;

import com.hnie.blogbackstage.mybatis.entity.Type;
import com.hnie.blogbackstage.mybatis.mapper.TypeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import java.util.List;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/23 13:41
 */
@SpringBootTest
public class TypeMapperTest {
    @Autowired
    TypeMapper typeMapper;

    @Test
    public void addTypeTest() {
        Type typ = new Type(null, "111111");
        int re = typeMapper.addType(typ);
        System.out.println("添加结果" + re);
    }

    @Test
    public void deleteTypeByIdTest() {
        int re = typeMapper.deleteTypeById(4L);
        System.out.println("根据Id删除的结果为：" + re);
    }

    @Test
    public void selectTypeByIdTest() {
        Type type = typeMapper.getTypeById(1L);
        System.out.println("查询到的Type为：" + type);
    }

    @Test
    public void updateTypeTest() {
        Type type = new Type(1L, "算法设计");
        int re = typeMapper.updateType( type);
        System.out.println("修改结果为：" + re);
    }

    @Test
    public void getAllTypeTest() {
        List<Type> allType = typeMapper.getAllType();
        for (Type type : allType) {
            System.out.println(type);
        }
    }
}

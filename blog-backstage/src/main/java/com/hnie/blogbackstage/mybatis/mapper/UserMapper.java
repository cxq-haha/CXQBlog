package com.hnie.blogbackstage.mybatis.mapper;

import com.hnie.blogbackstage.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/22 16:20
 */
@Repository
@Mapper
public interface UserMapper {
    //根据账号密码查询用户
    User findByUsernameAndPassword(@Param("username") String userName, @Param("password") String password);
}

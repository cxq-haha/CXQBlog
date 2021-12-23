package com.hnie.blogbackstage.service.impl;

import com.hnie.blogbackstage.mybatis.entity.User;
import com.hnie.blogbackstage.mybatis.mapper.UserMapper;
import com.hnie.blogbackstage.service.UserService;
import com.hnie.blogbackstage.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/22 16:18
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User CheckUser(String userName, String password) {
        return userMapper.findByUsernameAndPassword(userName, MD5Util.code(password));
    }
}

package com.hnie.blogbackstage.service;

import com.hnie.blogbackstage.mybatis.entity.User;
import com.hnie.blogbackstage.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/22 16:18
 */
public interface UserService {
    User CheckUser(String userName, String password);
}

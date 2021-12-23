package com.hnie.blogbackstage.mapper;

import com.hnie.blogbackstage.mybatis.entity.User;
import com.hnie.blogbackstage.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: chenxueqin
 * @Date: 2021/12/22 16:25
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void checkUserTest() {
        User chen = userMapper.findByUsernameAndPassword("陈学勤", "001129");
        System.out.println(chen);
    }
}

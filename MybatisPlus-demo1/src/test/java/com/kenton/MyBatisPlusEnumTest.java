package com.kenton;

import com.kenton.mybatisplus.enums.SexEnum;
import com.kenton.mybatisplus.mapper.UserMapper;
import com.kenton.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/11 22:22
 */
@SpringBootTest
public class MyBatisPlusEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        User user = new User();
        user.setName("admin");
        user.setAge(33);
        user.setSex(SexEnum.MALE);
        int result = userMapper.insert(user);
        System.out.println("result:" + result);
    }
}

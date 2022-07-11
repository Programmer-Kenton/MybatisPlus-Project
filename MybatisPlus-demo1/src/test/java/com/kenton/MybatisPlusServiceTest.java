package com.kenton;

import com.kenton.mybatisplus.pojo.User;
import com.kenton.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/9 19:54
 */
@SpringBootTest
public class MybatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){
        // 查询总记录数
        long count = userService.count();
        System.out.println("总记录数:" + count);
    }

    @Test
    public void testInsertMore(){
        // 批量添加
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("lcx"+i);
            user.setAge(20+i);
            list.add(user);
        }
        boolean batch = userService.saveBatch(list);
        System.out.println(batch);
    }
}

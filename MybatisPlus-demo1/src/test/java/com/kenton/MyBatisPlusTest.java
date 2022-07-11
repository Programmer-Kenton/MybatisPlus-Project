package com.kenton;

import com.kenton.mybatisplus.mapper.UserMapper;
import com.kenton.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/6 19:51
 */
@SpringBootTest(classes = MybatisPlusApplication.class)
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        // MybatisPlus的selectList 查询list集合 若没有条件 则可以设置null参数
        List<User> list = (List<User>) userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        // Preparing: INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User();
        user.setName("张三");
        user.setEmail("zhangsan@qq.com");
        user.setAge(20);
        int result = userMapper.insert(user);
        System.out.println("result:" + result);
        System.out.println("id:" + user.getId());
    }

    @Test
    public void testDelete(){
        // 通过id删除用户信息
        /*int result = userMapper.deleteById(1545410728853188609L);
        System.out.println("result:" + result);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        int result = userMapper.deleteByMap(map);
        System.out.println("result:" + result);*/

        // 通过多个id实现批量删除
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result:" + result);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@qq.com");
        int result = userMapper.updateById(user);
        System.out.println("result:" + result);
    }

    @Test
    public void testSelect(){
        // 通过id查询用户信息
        User user = userMapper.selectById(1L);
        System.out.println(user);

        // 根据多个id查询多个用户信息
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> usersOne = userMapper.selectBatchIds(list);
        usersOne.forEach(System.out::println);

        // 根据Map集合条件查询用户信息
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","Jack");
        map.put("age",20);
        List<User> usersTwo = userMapper.selectByMap(map);
        usersTwo.forEach(System.out::println);

        List<User> userThree = userMapper.selectList(null);
        userThree.forEach(System.out::println);

        Map<String, Object> myMap = userMapper.selectMapById(1L);
        System.out.println(myMap);
    }
}

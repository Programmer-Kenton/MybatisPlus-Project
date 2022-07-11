package com.kenton;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.kenton.mybatisplus.mapper.UserMapper;
import com.kenton.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/10 14:02
 */
@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        // 查用用户名包含a 年龄在20-30之间 邮箱信息不为null
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name","a")
                        .between("age",20,30)
                                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        // 查询用户信息 按照年龄降序排序 若年龄相同 按照id升序排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("uid");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03(){
        // 删除邮箱地址为Null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result:" + result);
    }

    @Test
    public void test04(){
        // 将年龄大于20并且用户名包含a 或者邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20)
                        .like("user_name","a")
                                .or()
                                        .isNull("email");
        User user = new User();
        user.setName("小明");
        user.setEmail("test@atguigu.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result:" + result);
    }

    @Test
    public void test05(){
        // 将用户名包含a并且年龄大于20或者邮箱为null的用户信息修改
        // lambda表达式中的条件优先执行
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name","a")
                /*.gt("age",20)
                .or()
                .isNull("email");*/
                .and(i->i.gt("age",20).or().isNull("email"));
        User user = new User();
        user.setName("小红");
        user.setEmail("hahaha@qq.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result:" + result);
    }

    @Test
    public void test06(){
        // 查询用户的用户名、年龄、邮箱信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name","age","email");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test07(){
        // 查询id小于等于100的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid","select uid from t_user where uid <= 100");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test08(){
        // 将用户名包含a并且年龄大于20或者邮箱为null的用户信息修改
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.like("user_name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        userUpdateWrapper.set("user_name","小黑").set("email","abc@atguigu.com");
        int result = userMapper.update(null, userUpdateWrapper);
        System.out.println("result:" + result);
    }

    @Test
    public void test09(){
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
            // isNotBlank判断某个字符串是否不为空字符串 不为null 不为空白符
            queryWrapper.like("user_name",username);
        }
        if (ageBegin != null) {
            queryWrapper.ge("age",ageBegin);
        }
        if (ageEnd != null) {
            queryWrapper.le("age",ageEnd);
        }
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test10(){
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like((StringUtils.isNotBlank(username)),"user_name",username)
                .ge(ageBegin != null,"age",ageBegin)
                .le(ageEnd != null,"age",ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test11(){
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(ageBegin != null,User::getAge,ageBegin)
                .le(ageEnd != null,User::getAge,ageEnd);
        List<User> list = userMapper.selectList(userLambdaQueryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test12(){
        LambdaUpdateWrapper<User> userLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        userLambdaUpdateWrapper.like(User::getName,"a")
                .and(i->i.gt(User::getAge,20).or().isNull(User::getEmail));
        userLambdaUpdateWrapper.set(User::getName,"小黑").set(User::getEmail,"abc@atguigu.com");
        int result = userMapper.update(null, userLambdaUpdateWrapper);
        System.out.println("result:" + result);
    }
}

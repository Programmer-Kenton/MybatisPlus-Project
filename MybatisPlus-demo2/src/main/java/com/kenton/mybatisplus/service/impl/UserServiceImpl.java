package com.kenton.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kenton.mybatisplus.mapper.UserMapper;
import com.kenton.mybatisplus.pojo.User;
import com.kenton.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/11 23:52
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}

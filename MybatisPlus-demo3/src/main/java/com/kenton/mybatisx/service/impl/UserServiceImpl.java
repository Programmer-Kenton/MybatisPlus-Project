package com.kenton.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kenton.mybatisx.pojo.User;
import com.kenton.mybatisx.service.UserService;
import com.kenton.mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 14416
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-07-12 00:18:52
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}





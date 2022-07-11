package com.kenton.mybatisplus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kenton.mybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

    int deleteByUidAndUserName(@Param("uid") Integer uid, @Param("userName") String userName);

    int updateAgeAndSexByUid(@Param("age") Integer age,@Param("sex") Integer sex,@Param("uid") Integer uid);

    List<User> selectAgeAndSexByAgeBetween(@Param("beginAge") Integer beginAge,@Param("endAge") Integer endAge);

    /*List<User> selectAllOrderByAgeDesc();*/

}

package com.kenton.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.kenton.mybatisplus.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Kenton
 * @description 用户类
 * @date: 2022/7/6 19:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 设置实体类所对应的表名
// @TableName("t_user")
public class User {

    // 将属性所对应的字段指定为主键
    // @TableId注解的value属性用于指定主键的字段
    // MybatisPlus主键默认采用雪花算法 IdType.AUTO可以设置主键自动增长
    // 如果手动赋值Id就算设置雪花算法也会采用 手动赋值的Id
    @TableId(value = "uid")
    private Long id;

    // 指定属性对应的字段名
    @TableField("user_name")
    private String name;

    private Integer age;

    private String email;

    private SexEnum sex;

    @TableLogic
    private Integer isDeleted;
}

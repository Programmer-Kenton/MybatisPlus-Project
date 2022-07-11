package com.kenton.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/11 23:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User {

    @TableId
    private Integer uid;

    private String userName;

    private Integer sex;

    private String email;

    private Integer isDeleted;
}

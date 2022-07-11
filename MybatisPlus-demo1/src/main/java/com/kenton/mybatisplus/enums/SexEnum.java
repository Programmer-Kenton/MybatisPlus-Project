package com.kenton.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/11 22:18
 */
@Getter
public enum SexEnum {

    MALE(1,"男"),
    FEMALE(2,"女");

    // 将注解所标识的属性的值存储到数据库中
    @EnumValue
    private Integer sex;
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}

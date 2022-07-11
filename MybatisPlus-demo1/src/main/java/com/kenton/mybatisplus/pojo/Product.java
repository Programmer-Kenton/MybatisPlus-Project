package com.kenton.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Kenton
 * @description 产品类
 * @date: 2022/7/11 21:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Integer price;

    // 用来表示乐观锁版本号字段
    @Version
    private Integer version;
}

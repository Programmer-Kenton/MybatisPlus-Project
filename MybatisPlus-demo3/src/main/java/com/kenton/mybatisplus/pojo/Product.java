package com.kenton.mybatisplus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/11 23:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;

    private String name;

    private Integer price;

    private Integer version;
}

package com.kenton.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kenton.mybatisplus.mapper.ProductMapper;
import com.kenton.mybatisplus.pojo.Product;
import com.kenton.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/11 23:57
 */
@Service
// 指定数据源 因为两个对象操作的数据源不同
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper,Product> implements ProductService {

}

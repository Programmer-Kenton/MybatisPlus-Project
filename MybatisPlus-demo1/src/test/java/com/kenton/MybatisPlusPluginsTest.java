package com.kenton;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kenton.mybatisplus.mapper.ProductMapper;
import com.kenton.mybatisplus.mapper.UserMapper;
import com.kenton.mybatisplus.pojo.Product;
import com.kenton.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/11 21:10
 */
@SpringBootTest
public class MybatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testPage(){
        // 在MybatisPlus中 (a,b) 第a页 每页显示b条数据
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);
        // 获取当前页的记录
        System.out.println(page.getRecords());
        // 获取当前页码
        System.out.println(page.getCurrent());
        // 获取每页显示的条数
        System.out.println(page.getSize());
        // 获取总记录数
        System.out.println(page.getTotal());
        // 判断是否有下一页
        System.out.println(page.hasNext());
        // 判断是否有上一页
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testPageVo(){
        Page<User> page = new Page<>(1,3);
        // 对年龄大于20的用户信息进行分页
        userMapper.selectPageVo(page,20);
        // 获取当前页的记录
        System.out.println(page.getRecords());
        // 获取当前页码
        System.out.println(page.getCurrent());
        // 获取每页显示的条数
        System.out.println(page.getSize());
        // 获取总记录数
        System.out.println(page.getTotal());
        // 判断是否有下一页
        System.out.println(page.hasNext());
        // 判断是否有上一页
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testProduct01(){
        // 小李查询商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的商品价格:" + productLi.getPrice());
        // 小王查询商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询的商品价格:" + productLi.getPrice());
        // 小李将商品价格+50
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);
        // 小王将商品价格-30
        productWang.setPrice(productWang.getPrice()-30);
        int result = productMapper.updateById(productWang);
        if (result == 0) {
            // 操作失败 重试
            Product productNew = productMapper.selectById(1);
            // 将新的版本价格设置为当前当本的-30
            productNew.setPrice(productNew.getPrice()-30);
            productMapper.updateById(productNew);
        }
        // 老板查询商品价格产品
        Product productBoss = productMapper.selectById(1);
        System.out.println("老板查询的商品价格:" + productBoss.getPrice());
    }
}

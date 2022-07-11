package com.kenton;

import com.kenton.mybatisplus.service.ProductService;
import com.kenton.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/12 0:00
 */
@SpringBootTest
public class MybatisPlusDatasourceApplicationTest {

    @Test
    void contextLoads(){

    }

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;


    @Test
    public void test(){
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }
}

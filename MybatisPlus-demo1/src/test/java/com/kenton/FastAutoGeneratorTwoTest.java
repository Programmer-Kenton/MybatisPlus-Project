package com.kenton;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/11 23:00
 */
public class FastAutoGeneratorTwoTest {
    public static void main(String[] args) {
        // 设置连接数据库
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/mybatis_plus?" +
                        "characterEncoding=UTF-8&userSSL=false","root","java")
                .globalConfig(builder -> {
                    // 设置作者
                    builder.author("Kenton")
                            //.enableSwagger() 开启swagger模式
                            /**
                             * Swagger是什么？Swagger怎么用？
                             *    Swagger 是一个规范且完整的框架，用于生成、描述、调用和可视化 RESTful 风格的 Web 服务。
                             *    Swagger 的目标是对 REST API 定义一个标准且和语言无关的接口，可以让人和计算机拥有无须访问源码、文档或网络流量监测就可以发现和理解服务的能力。当通过 Swagger 进行正确定义，用户可以理解远程服务并使用最少实现逻辑与远程服务进行交互。与为底层编程所实现的接口类似，Swagger 消除了调用服务时可能会有的猜测。
                             *    Swagger 的优势
                             *    支持 API 自动生成同步的在线文档：使用 Swagger 后可以直接通过代码生成文档，不再需要自己手动编写接口文档了，对程序员来说非常方便，可以节约写文档的时间去学习新技术。
                             *    提供 Web 页面在线测试 API：光有文档还不够，Swagger 生成的文档还支持在线测试。参数和格式都定好了，直接在界面上输入参数对应的值即可在线测试接口。
                             */
                            // 覆盖已生成的文件
                            .fileOverride()
                            // 指定输出目录
                            .outputDir("D://mybatis_plus");
                })
                        .packageConfig(builder -> {
                            builder.parent("com.atguigu") // 设置父包名
                                    .moduleName("mybatisplus") // 设置父包模块名
                                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://mybatis_plus"));
// 设置mapperXml生成路径
                        })
                        .strategyConfig(builder -> {
                            builder.addInclude("t_user") // 设置需要生成的表名
                                    .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                        })
                        // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                        .templateEngine(new FreemarkerTemplateEngine())
                        .execute();
    }

}

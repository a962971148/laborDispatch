package com.taoye.labor_dispatch.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * MP代码生成器
 * 运行main方法，根据数据库表生成：entity mapper mapperXml service serviceImpl controller
 */
public class MpGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create(
                        // 修改数据库连接地址
                        "jdbc:mysql://127.0.0.1:3306/labor_dispatch?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true",
                        "root",
                        "123456")

                // 全局配置
                .globalConfig(builder -> {
                    builder.author("taoye")
                            // java输出目录
                            .outputDir(System.getProperty("user.dir") + "/src/main/java")
                            .disableOpenDir();
                })

                // 包配置
                .packageConfig(builder -> {
                    // 修改为你的父包
                    builder.parent("com.taoye.labor_dispatch")
                            .moduleName("")
                            // mapper xml输出路径
                            .pathInfo(Collections.singletonMap(
                                    OutputFile.xml,
                                    System.getProperty("user.dir") + "/src/main/resources/mapper"
                            ));
                })

                // 策略配置
                .strategyConfig(builder -> {
                    // ==========填写需要生成的表名，多张逗号分隔==========
                    builder.addInclude("intial_description")

                            // 实体类配置
                            .entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .disableSerialVersionUID()
                            .enableFileOverride()

                            // Mapper
                            .mapperBuilder()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .enableFileOverride()
                            ;

//                            // Service
//                            .serviceBuilder()
//                            .formatServiceFileName("%sService")
//                            .formatServiceImplFileName("%sServiceImpl")
//
//                            // Controller rest风格 @RestController
//                            .controllerBuilder()
//                            .enableRestStyle();
                })

                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
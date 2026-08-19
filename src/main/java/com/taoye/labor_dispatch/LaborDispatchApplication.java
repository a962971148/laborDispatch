package com.taoye.labor_dispatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// ✅正确
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.taoye.labor_dispatch.mapper")
public class LaborDispatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaborDispatchApplication.class, args);
    }

}

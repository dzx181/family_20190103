package com.senb.familyedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//启动类
@SpringBootApplication
@MapperScan(basePackages = "com.senb.familyedu.dao")
public class FamilyEduApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilyEduApplication.class, args);
    }

}


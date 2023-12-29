package com.me.assumentpark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.me.assumentpark.mapper")
public class AssumentParkApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssumentParkApplication.class, args);
    }

}

package com.flyin.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.flyin.example.mapper")
@SpringBootApplication
public class TkMapperTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkMapperTestApplication.class, args);
    }

}

package com.flyin.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.flyin.example.mapper")
@SpringBootApplication
public class TkMapperTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkMapperTestApplication.class, args);
    }

}

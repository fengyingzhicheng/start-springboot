package com.flyin.example;

/**
 * @author 王军
 * @description
 * @date 2022/1/9 17:58
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author bravo
 */
@MapperScan("com.flyin.example.mapper")
@SpringBootApplication
public class HappyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HappyDemoApplication.class, args);
    }

}
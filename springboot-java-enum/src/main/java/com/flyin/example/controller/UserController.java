package com.flyin.example.controller;

import com.flyin.example.config.Result;
import com.flyin.example.pojo.TkUserPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Swagger2测试接口
 *
 * @author qiyu
 * @date 2020-09-20 17:13
 */
@Slf4j
@RestController
public class UserController {

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public Result addUser(@RequestBody TkUserPojo user) {
        log.info("user:{}", user);
        return Result.success(user);
    }
}
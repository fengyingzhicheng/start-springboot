package com.flyin.example.service;

import com.flyin.example.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author 王军
 * @description
 * @date 2022/3/4 14:07
 */
public interface IUserService {
    final String SERVICE_NAME = "userService";

    void save(User user);

    void update(User user);

    User find(Long id);

    boolean exists(Long id);

}
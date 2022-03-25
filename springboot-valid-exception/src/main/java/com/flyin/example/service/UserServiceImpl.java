package com.flyin.example.service;

import com.flyin.example.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author 王军
 * @description
 * @date 2022/3/4 14:07
 */
@Service(value = IUserService.SERVICE_NAME)
public class UserServiceImpl implements IUserService{
    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User find(Long id) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }
}
package com.flyin.example.dao;

/**
 * @author 王军
 * @description
 * @date 2022/3/4 14:04
 */

import com.flyin.example.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pdai
 */
@Repository
public class UserRepository {

    private List<User> userDemoList = new ArrayList<>();

    public void save(User user) {
        userDemoList.add(user);
    }

    public List<User> findAll() {
        return userDemoList;
    }
}

package com.flyin.example.creation.singleton;

/**
 * @author 王军
 * @description 懒汉式加锁
 * @date 2022/2/8 16:17
 */
public class SingletonLazyByLock {
    private static SingletonLazyByLock instance;
    private SingletonLazyByLock(){}
    public static synchronized SingletonLazyByLock getInstance() {
        if (instance == null) {
            instance = new SingletonLazyByLock();
        }
        return instance;
    }
}
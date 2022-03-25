package com.flyin.example.creation.singleton;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 16:20
 */
public class SingletonLazyDoubleLock {
    private volatile static SingletonLazyDoubleLock instance;

    private SingletonLazyDoubleLock() {
    }

    public static SingletonLazyDoubleLock getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyDoubleLock.class) {
                if (instance == null) {
                    instance = new SingletonLazyDoubleLock();
                }
            }
        }
        return instance;
    }
}
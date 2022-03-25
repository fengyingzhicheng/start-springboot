package com.flyin.example.creation.singleton;

/**
 * @author 王军
 * @description 饿汉式
 * @date 2022/2/8 16:18
 */
public class SingletonHunger {
    private static SingletonHunger instance = new SingletonHunger();
    private SingletonHunger (){}
    public static SingletonHunger getInstance() {
        return instance;
    }
}
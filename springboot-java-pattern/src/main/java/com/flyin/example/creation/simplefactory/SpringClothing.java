package com.flyin.example.creation.simplefactory;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 15:09
 */
public class SpringClothing implements Clothing{

    @Override
    public void keepWarm() {
        System.out.println("春装可以保暖。");
    }
}
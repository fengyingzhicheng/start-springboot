package com.flyin.example.creation.abstractfactory;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 15:34
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
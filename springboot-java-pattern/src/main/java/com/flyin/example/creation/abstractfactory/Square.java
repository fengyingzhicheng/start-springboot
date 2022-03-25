package com.flyin.example.creation.abstractfactory;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 15:33
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
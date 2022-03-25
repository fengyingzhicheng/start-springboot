package com.flyin.example.creation.abstractfactory;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 15:30
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
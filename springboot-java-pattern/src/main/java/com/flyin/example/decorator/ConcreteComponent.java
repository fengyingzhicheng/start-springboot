package com.flyin.example.decorator;

/**
 * @author 王军
 * @description
 * @date 2022/3/18 13:56
 */
public class ConcreteComponent implements Component
{

    @Override
    public void doSomething()
    {
        System.out.println("功能A");
    }

}
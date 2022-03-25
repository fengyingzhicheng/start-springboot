package com.flyin.example.decorator;

/**
 * @author 王军
 * @description
 * @date 2022/3/18 13:58
 */
public class Client
{
    public static void main(String[] args)
    {
        Component component = new ConcreteComponent();

        Component component1 = new ConcreteDecorator1(component);

        component1.doSomething();
        System.out.println("-----------");

        Component component2 = new ConcreteDecorator2(component1);

        component2.doSomething();
    }

}
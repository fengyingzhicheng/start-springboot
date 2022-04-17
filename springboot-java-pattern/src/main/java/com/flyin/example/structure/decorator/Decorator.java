package com.flyin.example.structure.decorator;

/**
 * @author 王军
 * @description
 * @date 2022/3/18 13:56
 */
public class Decorator implements Component
{
    private Component component;

    public Decorator(Component component)
    {
        this.component = component;
    }

    @Override
    public void doSomething()
    {

        component.doSomething();
    }

}
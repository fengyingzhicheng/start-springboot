package com.flyin.example.decorator;

/**
 * @author 王军
 * @description
 * @date 2022/3/18 13:56
 */
public class ConcreteDecorator1 extends Decorator
{
    public ConcreteDecorator1(Component component)
    {
        super(component);
    }

    @Override
    public void doSomething()
    {
        super.doSomething();

        this.doAnotherThing();
    }

    private void doAnotherThing()
    {
        System.out.println("功能B");
    }

}
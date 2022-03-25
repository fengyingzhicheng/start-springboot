package com.flyin.example.decorator;

/**
 * @author 王军
 * @description
 * @date 2022/3/18 13:57
 */
public class ConcreteDecorator2 extends Decorator
{
    public ConcreteDecorator2(Component component)
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
        System.out.println("功能C");
    }

}
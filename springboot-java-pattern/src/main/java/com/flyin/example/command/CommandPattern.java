package com.flyin.example.command;

/**
 * @author 王军
 * @description
 * @date 2022/4/11 11:04
 */
public class CommandPattern {
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker ir = new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法...");
        ir.call();
        //客户访问调用者的call()方法...
        //调用者执行命令command...
        //接收者的action()方法被调用...
    }
}
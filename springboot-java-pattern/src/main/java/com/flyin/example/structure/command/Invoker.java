package com.flyin.example.structure.command;

/**
 * @author 王军
 * @description 调用者
 * @date 2022/4/11 11:04
 */
public class Invoker {
    private Command command;
    public Invoker(Command command) {
        this.command = command;
    }
    public void setCommand(Command command) {
        this.command = command;
    }
    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}
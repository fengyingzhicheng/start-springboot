package com.flyin.example.command;

/**
 * @author 王军
 * @description
 * @date 2022/4/11 11:03
 */
//具体命令
class ConcreteCommand implements Command {
    private Receiver receiver;
    ConcreteCommand() {
        receiver = new Receiver();
    }
    @Override
    public void execute() {
        receiver.action();
    }
}
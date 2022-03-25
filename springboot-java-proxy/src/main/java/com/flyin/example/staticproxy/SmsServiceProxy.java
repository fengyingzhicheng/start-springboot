package com.flyin.example.staticproxy;

/**
 * @author 王军
 * @description
 * @date 2022/2/9 16:14
 */
public class SmsServiceProxy implements SmsService{

    private final SmsService smsService;

    public SmsServiceProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return null;
    }
}
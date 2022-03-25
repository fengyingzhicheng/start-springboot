package com.flyin.example.staticproxy;

/**
 * @author 王军
 * @description
 * @date 2022/2/9 16:15
 */
public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsServiceProxy smsProxy = new SmsServiceProxy(smsService);
        smsProxy.send("java");
    }
}

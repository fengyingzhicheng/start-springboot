package com.flyin.example.staticproxy;

/**
 * @author 王军
 * @description
 * @date 2022/2/9 16:07
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

package com.flyin.example.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 王军
 * @description
 * @date 2022/2/9 16:08
 */
public class Main {
    public static void main(String[] args) {
        SmsServiceImpl smsService = new SmsServiceImpl();
        Object proxy = Proxy.newProxyInstance(
                smsService.getClass().getClassLoader(), // 目标类的类加载
                smsService.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //调用方法之前，我们可以添加自己的操作
                        System.out.println("before method " + method.getName());
                        Object result = method.invoke(smsService, args);
                        //调用方法之后，我们同样可以添加自己的操作
                        System.out.println("after method " + method.getName());
                        return result;
                    }
                }  // 代理对象对应的自定义 InvocationHandler
        );
        SmsService service = (SmsService) proxy;
        service.send("test");
    }
}
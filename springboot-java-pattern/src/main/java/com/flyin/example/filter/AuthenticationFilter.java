package com.flyin.example.filter;

/**
 * @author 王军
 * @description
 * @date 2022/3/25 10:23
 */
public class AuthenticationFilter implements Filter {
    @Override
    public void execute(String request){
        System.out.println("Authenticating request: " + request);
    }
}
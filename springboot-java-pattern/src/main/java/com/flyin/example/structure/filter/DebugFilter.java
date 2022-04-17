package com.flyin.example.structure.filter;

/**
 * @author 王军
 * @description
 * @date 2022/3/25 10:25
 */
public class DebugFilter implements Filter {
    @Override
    public void execute(String request){
        System.out.println("Debug request: " + request);
    }
}
package com.flyin.example.filter;

/**
 * @author 王军
 * @description
 * @date 2022/3/25 10:24
 */
public class Client {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager();
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());
        filterManager.filterRequest("HOME");
    }
}
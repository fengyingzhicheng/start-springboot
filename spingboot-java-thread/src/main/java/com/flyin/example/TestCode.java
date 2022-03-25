package com.flyin.example;

/**
 * @author 王军
 * @description
 * @date 2022/3/18 10:32
 */
public class TestCode {
    public int foo() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}

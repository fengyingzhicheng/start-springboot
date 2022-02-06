package com.flyin.example.function;

import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String[] args) {
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String o) {
//                return o.isEmpty();
//            }
//        };

        Predicate<String> predicate = o -> o.isEmpty();

        System.out.println(predicate.test(""));
        System.out.println(predicate.test("null"));
    }
}

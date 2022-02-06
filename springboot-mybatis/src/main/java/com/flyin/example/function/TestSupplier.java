package com.flyin.example.function;

import java.util.Random;
import java.util.function.Supplier;

public class TestSupplier {
    public static void main(String[] args) {
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return String.valueOf(new Random().nextInt());
//            }
//        };

        Supplier<String> supplier = () -> String.valueOf(new Random().nextInt());
        System.out.println(supplier.get());
    }
}

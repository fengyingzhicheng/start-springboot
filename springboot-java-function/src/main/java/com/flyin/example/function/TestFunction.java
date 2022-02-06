package com.flyin.example.function;

import java.util.Locale;
import java.util.function.Function;

public class TestFunction {
    public static void main(String[] args) {
//        Function<String,String> function=new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s.toLowerCase(Locale.ROOT);
//            }
//        };

        Function<String,String> function= s -> s.toLowerCase(Locale.ROOT);

        System.out.println(function.apply("CHINESE"));


    }
}

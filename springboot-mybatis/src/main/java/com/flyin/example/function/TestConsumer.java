package com.flyin.example.function;

import java.util.function.Consumer;

public class TestConsumer {

    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String o) {
//                System.out.println("hhh "+o);
//            }
//        };

        Consumer<String> consumer = o -> System.out.println("hhh "+o);

        consumer.accept("wangjun");
    }
}

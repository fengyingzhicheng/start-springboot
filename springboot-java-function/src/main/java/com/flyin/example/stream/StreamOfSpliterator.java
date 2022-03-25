package com.flyin.example.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 11:11
 */
public class StreamOfSpliterator {
    public static void main(String[] args) {
        //learnIterator();
        learnIterator2();
    }
    private static void learnIterator() {
        List<String> lists = Arrays.asList("A", "B", "C", "D");

        Spliterator<String> spliterator = lists.stream().spliterator();

        while (spliterator.tryAdvance(System.out::println)) {
            ;
        }

        System.out.println("*****************");
        lists.stream().spliterator().forEachRemaining(System.out::println);
    }

    private static void learnIterator2() {
        List<String> lists = Arrays.asList("A", "B", "C", "D");

        Spliterator<String> spliterator = lists.stream().spliterator();

        Spliterator<String> stringSpliterator = spliterator.trySplit();

        if (stringSpliterator != null) stringSpliterator.forEachRemaining(System.out::println);

        System.out.println("------------------");

        spliterator.forEachRemaining(System.out::println);
    }

    private static void learnIterator3() {
        List<String> lists = Arrays.asList("A", "B", "C", "D");
        Iterator<String> iterator = lists.iterator();
        iterator.forEachRemaining(System.out::println);
    }
}
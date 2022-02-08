package com.flyin.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamOfParallel {

    public static void main(String[] args) {
        learnStream();
    }


    private static void learnStream() {
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(6);

        Optional<Integer> sum = lists.parallelStream().reduce((a, b) -> a + b);//这里把stream()换成了parallelStream（）
        if (sum.isPresent()) System.out.println("list的总和为:" + sum.get());//21
        //<====> lists.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);

        Integer sum2 = lists.stream().reduce(0, (a, b) -> a + b);//21
        System.out.println("list的总和为:" + sum2);

        Optional<Integer> product = lists.stream().reduce((a, b) -> a * b);
        if (product.isPresent()) System.out.println("list的积为:" + product.get());//720

        Integer product2 = lists.parallelStream().reduce(1, (a, b) -> a * b);//这里把stream()换成了parallelStream（）
        System.out.println("list的积为:" + product2);//720
        //应用到并行流的任何操作都必须是符合缩减操作的三个约束条件，无状态，不干预，关联性！
        // 因为这三大约束确保在并行流上执行操作的结果和在顺序流上执行的结果是相同的。

        Integer product3 = lists.parallelStream().reduce(1, (a, b) -> a *  (b * 2),
                (a, b) -> a * b * 2 );
        System.out.println("product:" + product3);
    }
}

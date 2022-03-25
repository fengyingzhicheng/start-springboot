package com.flyin.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class StreamOfReduce {
    public static void main(String[] args) {
        learnStream();
        learnStreamOfReduce();
    }


    private static void learnStream() {
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(6);

        Optional<Integer> sum = lists.stream().reduce((a, b) -> a + b);
        if (sum.isPresent()) System.out.println("list的总和为:" + sum.get());//21
        //<====> lists.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);

        Integer sum2 = lists.stream().reduce(0, (a, b) -> a + b);//21
        System.out.println("list的总和为:" + sum2);

        Optional<Integer> product = lists.stream().reduce((a, b) -> a * b);
        if (product.isPresent()) System.out.println("list的积为:" + product.get());//720

        Integer product2 = lists.stream().reduce(1, (a, b) -> a * b);
        System.out.println("list的积为:" + product2);//720

        Integer product3 = lists.stream().reduce(1, (a, b) -> {
            if (b % 2 == 0) return a * b;
            else return a;//这里你可以为所欲为!
        });
        System.out.println("list的偶数的积为:" + product3);//48


        Stream<String> of = Stream.of("张飞", "关羽");
        //一下代码报错，类型不匹配The method reduce(String, BinaryOperator<String>) in the type Stream<String>
        //is not applicable for the arguments (int, BinaryOperator<String>)
        System.out.print("每个字符串长度连接为 ");
        System.out.println(of.reduce("", (a, b) -> a + b.length()));

        of = Stream.of("张飞", "关羽");
        System.out.print("字符串求和为 ");
        System.out.println(of.reduce(0, (a, b) -> a + b.length(), Integer::sum));
    }

    private static void learnStreamOfReduce() {
        List<Student> lists = new ArrayList<>();
        lists.add(new Student("xx", 16, 50));
        lists.add(new Student("yy", 20, 60));
        lists.add(new Student("zz", 25, 70));
        lists.add(new Student("cc", 30, 80));

        BiFunction<Double, Student, Double> accumulator = (a, b) -> a * (b.getAge() * 2);
        //BiFunction<U, ? super T, U> accumulator T的任何父类都可以 所以可以换成Human
        //BiFunction<Double, Human, Double> accumulator = (a, b) -> a * (b.getAge() * 2);
        Double product4 = lists.parallelStream().reduce(1.0, accumulator,
                (a, b) -> a * b * 2);
        System.out.println("product:" + product4);
    }
}

package com.flyin.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOfMapper {
    public static void main(String[] args) {
//        learnMap();
        learnFlatMap();
    }

    private static void learnMap() {
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        //使用并行流来处理
        Integer product = lists.parallelStream().reduce(1, (a, b) -> a *  (b * 2),
                (a, b) -> a * b);
        System.out.println("product:" + product);//48

        //使用映射来处理
        //Integer productMap = lists.parallelStream().map((a) -> a * 2).reduce(1, (a, b) -> a * b);
        Stream<Integer> productNewMapStream = lists.parallelStream().map((a) -> a * 2);
        Integer productMap = productNewMapStream.reduce(1, (a, b) -> a * b);
        System.out.println("productMap:" + productMap);//48
    }

    private static void learnFlatMap() {
        //(广州  深圳  上海  北京)的全拼的一些组合,下面我们就把每一个城市都划分一下
        List<String> citys = Arrays.asList("GuangZhou ShangHai", "GuangZhou ShenZhen",
                "ShangHai ShenZhen", "BeiJing ShangHai", "GuangZhou BeiJing", "ShenZhen BeiJing");

        //这里打印的数组对应的地址
        citys.stream().map(mCitys -> Arrays.stream(mCitys.split(" "))).forEach(System.out::println);//note1

        System.out.println();

        //流里面的元素还是一个数组
        citys.stream()
                .map(mCities -> Arrays.stream(mCities.split(" ")))//流里面的每个元素还是数组
                .forEach(cities ->cities.forEach(city-> System.out.print(city+" ")));//note2

        System.out.println();
        System.out.println();

        //直接一个flatMap()就把数组合并到映射流里面了
        citys.stream().flatMap(mCities->Arrays.stream(mCities.split(" "))).forEach(System.out::println);//note3

        System.out.println();

        //使用distinct()方法去重！
        citys.stream().flatMap(mCities->Arrays.stream(mCities.split(" "))).distinct().forEach(System.out::println);//note4

    }
}

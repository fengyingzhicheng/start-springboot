package com.flyin.example.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 9:28
 */
public class StreamOfCollect {
    public static void main(String[] args) {
        //learnCollect();
        learnCollect2();
    }

    private static void learnCollect() {
        List<HeroPlayerGold> lists = new ArrayList<>();
        lists.add(new HeroPlayerGold("盖伦", "RNG-Letme", 100));
        lists.add(new HeroPlayerGold("诸葛亮", "RNG-Xiaohu", 300));
        lists.add(new HeroPlayerGold("露娜", "RNG-MLXG", 300));
        lists.add(new HeroPlayerGold("狄仁杰", "RNG-UZI", 500));
        lists.add(new HeroPlayerGold("牛头", "RNG-Ming", 500));

        List<PlayerGold> playerGolds = lists.stream()
                .map(plary -> new PlayerGold(plary.getPlayer(), plary.getGold()))
                .collect(Collectors.toList());
        System.out.println("============PlayerGold begin==============");
        playerGolds.forEach(System.out::println);
        System.out.println("============PlayerGold end================\n");



        Set<Hero> heroes = lists.stream().map(player -> new Hero(player.getHero())).collect(Collectors.toSet());
        System.out.println("============Hero begin==============");
        heroes.forEach(System.out::println);
        System.out.println("============Hero end================");
    }

    private static void learnCollect2() {
        List<HeroPlayerGold> lists = new ArrayList<>();
        lists.add(new HeroPlayerGold("盖伦", "RNG-Letme", 100));
        lists.add(new HeroPlayerGold("诸葛亮", "RNG-Xiaohu", 300));
        lists.add(new HeroPlayerGold("露娜", "RNG-MLXG", 300));
        lists.add(new HeroPlayerGold("狄仁杰", "RNG-UZI", 500));
        lists.add(new HeroPlayerGold("牛头", "RNG-Ming", 500));


        lists.stream().collect(HashSet::new,//第一个参数
                HashSet::add,//第二个参数
                AbstractCollection::addAll//第三个参数
        ).forEach(System.out::println);
    }
}
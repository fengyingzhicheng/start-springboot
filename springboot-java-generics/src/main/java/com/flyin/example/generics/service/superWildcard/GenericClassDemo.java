package com.flyin.example.generics.service.superWildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王军
 * @description
 * @date 2022/1/1 21:28
 */
public class GenericClassDemo {

    public static void main(String[] args) {

        List<? super Human> humanList = new ArrayList<>();
        // 别紧张，还没开始呢，我现在自己指向自己，还不让存东西了吗？
        humanList.add(new Human("人类"));

        // 只能指向Human及其父类型的List：灵长类、生物类
        // humanList = new ArrayList<Chinese>(); // ERROR
        humanList = new ArrayList<Primate>();
        humanList = new ArrayList<Creature>();

        // 哇，牛逼啊，简单泛型和extends都搞不定的存入问题让你super整得服服帖帖
        humanList.add(new Human("女性"));
        humanList.add(new Chinese("中国人"));

        // super：也不是啦，我虽然能存东西，但规定只能存Human及其子类型元素
        //humanList.add(new Primate("灵长类动物")); // ERROR
        //humanList.add(new Creature("外星生物")); // ERROR
        //humanList.add("无关类型，比如String"); // ERROR

        // 简单类型&extends：么只能往Object自动转型
        Object object = humanList.get(0);
    }


    static class Creature {
        public Creature(String name) {
            this.name = name;
        }
        private String name;
    }

    static class Primate extends Creature {
        public Primate(String name) {
            super(name);
        }
    }

    static class Human extends Primate {
        public Human(String name) {
            super(name);
        }
    }

    static class Chinese extends Human {
        public Chinese(String name) {
            super(name);
        }
    }

    static class Japanese extends Human {
        public Japanese(String name) {
            super(name);
        }
    }
}
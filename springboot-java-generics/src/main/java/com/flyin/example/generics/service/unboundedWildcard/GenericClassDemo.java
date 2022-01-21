package com.flyin.example.generics.service.unboundedWildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王军
 * @description
 * 指向允许指向所有
 * 存：禁止存入
 * 取：只能是Object
 * @date 2022/1/1 21:42
 */
public class GenericClassDemo {

    public static void main(String[] args) {


        List<?> humanList = new ArrayList<>();
        //禁止存
        //humanList.add(new Human("人类"));
        //humanList.add(new Primate("灵长类动物")); // ERROR
        //humanList.add(new Creature("外星生物")); // ERROR
        //humanList.add(new Chinese("tets")); // ERROR


        // 只能指向Human及其父类型的List：灵长类、生物类
        // humanList = new ArrayList<Chinese>(); // ERROR
        humanList = new ArrayList<Primate>();
        humanList = new ArrayList<Creature>();
        humanList = new ArrayList<Chinese>();


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
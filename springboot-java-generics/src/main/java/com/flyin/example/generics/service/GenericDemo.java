package com.flyin.example.generics.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王军
 * @description
 * @date 2022/1/1 21:54
 */
public class GenericDemo {
    public static void main(String[] args) {
        //List<Object> list = new ArrayList<Integer>();
        //List<Human> list2 = new ArrayList<Chinese>();
        //List<Human> list3 = new ArrayList<Creature>();
        //List<? extends Human> list4 = new ArrayList<Creature>();
        //List<? super Human> list5 = new ArrayList<Chinese>();

        List<? extends Human> list6 = new ArrayList<Chinese>();
        //list6.add(new Human("xx"));
        Human human = list6.get(0);
        List<? super Human> list7 = new ArrayList<Creature>();
        list7.add(new Chinese("xx"));
        list7.add(new Human("xx"));
        //list7.add(new Creature("xx"));
        Object object = list7.get(0);

        List<?> list8 = new ArrayList<Chinese>();
        List<?> list9 = new ArrayList<Creature>();

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
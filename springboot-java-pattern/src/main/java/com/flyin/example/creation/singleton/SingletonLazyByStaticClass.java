package com.flyin.example.creation.singleton;

/**
 * @author 王军
 * @description 懒加载通过静态持有类
 * @date 2022/2/8 16:22
 */
public class SingletonLazyByStaticClass {
    private static class SingletonHolder {
        static {
            System.out.println("static code");
        }

        private static final SingletonLazyByStaticClass INSTANCE = new SingletonLazyByStaticClass();
    }

    /**
     * 假设new 这个很耗资源
     */
    private SingletonLazyByStaticClass() {
    }

    public static final SingletonLazyByStaticClass getInstance() {
        System.out.println("instance load");
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println("..");
        SingletonLazyByStaticClass singletonLazyByStaticClass = SingletonLazyByStaticClass.getInstance();
    }
}
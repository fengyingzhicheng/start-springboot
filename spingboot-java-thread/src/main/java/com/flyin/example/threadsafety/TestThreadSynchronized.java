package com.flyin.example.threadsafety;

/**
 * @author 王军
 * @description 测试线程的并发修改资源数据
 * @date 2022/1/27 15:10
 */
public class TestThreadSynchronized {

    public static void main(String[] args) {
        NumberCount2 numberCount2 = new NumberCount2();

        //四个线程去操作同一个资源
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                numberCount2.increment();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                numberCount2.increment();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                numberCount2.decrement();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                numberCount2.decrement();
            }
        }, "D").start();

    }


}

/**
 * 资源类
 */
class NumberCount {
    /* 并发修改的资源 */
    private Integer number = 0;


    public synchronized void increment() {
        number++;
        System.out.println(Thread.currentThread().getName() + "执行相加，相加后大小" + number);
    }

    public synchronized void decrement() {
        number--;
        System.out.println(Thread.currentThread().getName() + "执行相减，相减后大小" + number);
    }
}

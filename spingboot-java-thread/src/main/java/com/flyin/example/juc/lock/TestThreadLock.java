package com.flyin.example.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 王军
 * @description 测试线程的并发修改资源数据
 * @date 2022/1/27 15:10
 */
public class TestThreadLock {

    public static void main(String[] args) {
        NumberCount numberCount = new NumberCount();

        //四个线程去操作同一个资源
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                numberCount.increment();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                numberCount.increment();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                numberCount.decrement();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                numberCount.decrement();
            }
        }, "D").start();

    }


}

/**
 * 资源类
 */
class NumberCount {
    /**
     * 并发修改的资源
     */
    private Integer number = 0;
    /**
     * JUC锁
     */
    private final Lock lock = new ReentrantLock();


    public void increment() {
        lock.lock();
        try {
            number++;
            System.out.println(Thread.currentThread().getName() + "执行相加，相加后大小" + number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() {
        lock.lock();
        try {
            number--;
            System.out.println(Thread.currentThread().getName() + "执行相减，相减后大小" + number);
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

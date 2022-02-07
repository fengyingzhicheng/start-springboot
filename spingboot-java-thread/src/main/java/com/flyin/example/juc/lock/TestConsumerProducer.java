package com.flyin.example.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 王军
 * @description 生产者消费者模型 本质是线程之间互相通信 在资源类中操作通知
 * 线程通信模板代码：条件 等待 业务 通知
 * @date 2022/1/27 15:28
 */
public class TestConsumerProducer {
    public static void main(String[] args) {
        NumberCount3 numberCount3 = new NumberCount3();

        //四个线程去操作同一个资源
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                numberCount3.increment();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                numberCount3.increment();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                numberCount3.decrement();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                numberCount3.decrement();
            }
        }, "D").start();

    }

}

/**
 * 资源类
 */
class NumberCount2 {
    /* 并发修改的资源 */
    private Integer number = 0;
    /**
     * JUC锁
     */
    private final Lock lock = new ReentrantLock();

    /**
     * 获取锁的等候室
     */
    Condition condition = lock.newCondition();

    public  void increment() {
        lock.lock();
        try {
            while (number == 1) {
                //当是1的时候 线程不应该再执行此方法 等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "执行相加，相加后大小" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public  void decrement() {
        lock.lock();
        try {
            while (number ==0 ) {
                //当是0的时候 线程不应该再执行此方法 等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "执行相减，相减后大小" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
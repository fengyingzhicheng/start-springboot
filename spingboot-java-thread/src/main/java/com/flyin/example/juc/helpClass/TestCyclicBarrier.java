package com.flyin.example.juc.helpClass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 王军
 * @description
 * @date 2022/1/29 13:04
 */
public class TestCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7);
        for (int i = 0; i < 7; i++) {
            new Thread(()->{
                //每个子任务前面要做的操作
                System.out.println("当前线程"+Thread.currentThread().getName());
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("每个子线程任务"+Thread.currentThread().getName());

            },String.valueOf(i)).start();

        }

    }
}
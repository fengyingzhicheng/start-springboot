package com.flyin.example.juc.helpClass;

import java.util.concurrent.CountDownLatch;

/**
 * @author 王军
 * @description 每个前置任务做完前 后置任务阻塞 前置减一到零所有做完 不阻塞放行
 * CountDownLatch 不阻塞前置任务 后置任务可以等待所有前置任务执行完 再做
 * 等前置任务做完 CountDownLatch count置为0
 * @date 2022/1/27 20:18
 */
public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(7);

        for (int i = 0; i < 7; i++) {
            int i1 = i;
            new Thread(() -> {
                System.out.println("当前线程" + i1);
                latch.countDown();
            }).start();
        }
        latch.await();

        System.out.println("开启主线程任务" + latch.getCount());

    }
}
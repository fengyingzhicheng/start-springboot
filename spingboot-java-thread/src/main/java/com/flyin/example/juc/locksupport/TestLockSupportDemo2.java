package com.flyin.example.juc.locksupport;

/**
 * @author 王军
 * @description
 * @date 2022/3/17 14:50
 */
import java.util.concurrent.locks.LockSupport;

class MyThread2 extends Thread {
    private Object object;

    public MyThread2(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before unpark");
        System.out.println("Blocker info "+LockSupport.getBlocker((Thread) object));
        // 释放许可
        LockSupport.unpark((Thread) object);
        System.out.println("Blocker info "+LockSupport.getBlocker((Thread) object));
        System.out.println("after unpark");
    }
}

public class TestLockSupportDemo2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2(Thread.currentThread());
        myThread2.start();
        try {
            // 主线程睡眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before park");
        System.out.println("Main  Blocker info "+LockSupport.getBlocker(Thread.currentThread()));
        // 获取许可 //获取不上
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("Main  Blocker info "+LockSupport.getBlocker(Thread.currentThread()));
        System.out.println("after park");
    }
}

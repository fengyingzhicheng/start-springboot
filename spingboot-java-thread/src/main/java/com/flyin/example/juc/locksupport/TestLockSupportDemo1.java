package com.flyin.example.juc.locksupport;

/**
 * @author 王军
 * @description
 * @date 2022/3/17 14:39
 */
import java.util.concurrent.locks.LockSupport;

class MyThread1 extends Thread {
    private Object object;

    public MyThread1(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        System.out.println("before unpark");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
        // 释放许可
        LockSupport.unpark((Thread) object);
        // 休眠500ms，保证先执行park中的setBlocker(t, null);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 再次获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));

        System.out.println("after unpark");
    }
}

public class TestLockSupportDemo1 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1(Thread.currentThread());
        myThread1.start();
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }
}

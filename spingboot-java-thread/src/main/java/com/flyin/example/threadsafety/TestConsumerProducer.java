package com.flyin.example.threadsafety;

/**
 * @author 王军
 * @description 生产者消费者模型 本质是线程之间互相通信 在资源类中操作通知
 * 线程通信模板代码：条件 等待 业务 通知
 * @date 2022/1/27 15:28
 */
public class TestConsumerProducer {
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
class NumberCount2 {
    /* 并发修改的资源 */
    private Integer number = 0;


    public synchronized void increment() {
        while (number == 1) {
            //当是1的时候 线程不应该再执行此方法 等待
            try {
                this.wait();
                //这里必须使用 循环判断条件 防止【虚假唤醒】 比如其他线程已经加了1 此时这个线程从wait醒来 不判断直接进行+1 错误
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "执行相加，相加后大小" + number);
        this.notifyAll();
    }

    public synchronized void decrement() {
        while (number ==0 ) {
            //当是0的时候 线程不应该再执行此方法 等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "执行相减，相减后大小" + number);
        this.notifyAll();
    }
}
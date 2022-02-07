package com.flyin.example.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 王军
 * @description 测试读写锁
 * @date 2022/1/29 14:02
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 7; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.put(finalI,finalI);
            }).start();
        }

        for (int i = 0; i < 17; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.get(finalI);
            }).start();
        }

    }
}

class MyCache{
    Map<Integer,Object> map=new HashMap<>();
    ReadWriteLock lock=new ReentrantReadWriteLock();

    public void put(Integer key,Object value) {
        lock.writeLock().lock();
        System.out.println("写入当前线程名"+Thread.currentThread().getName()+"key名"+key);
        map.put(key,value);
        System.out.println("写入完毕");
        lock.writeLock().unlock();
    }

    public void get(Integer key) {
        lock.readLock().lock();

        System.out.println("读取当前线程名"+Thread.currentThread().getName()+"key名"+key);
        map.get(key);
        System.out.println("读取完毕");

        lock.readLock().unlock();
    }
}
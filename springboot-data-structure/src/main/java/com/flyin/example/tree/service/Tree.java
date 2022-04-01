package com.flyin.example.tree.service;

/**
 * @author 王军
 * @description
 * @date 2022/4/1 15:37
 */
public interface Tree<T> {
    /**
     * 插入数据到树
     * @param data 数据
     */
    void insert(T data);

    /**
     * 删除树某个数据
     * @param data 数据
     */
    void delete(T data);

    /**
     * 打印树到控制台
     */
    void print();
}
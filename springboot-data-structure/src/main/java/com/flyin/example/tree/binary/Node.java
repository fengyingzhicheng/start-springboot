package com.flyin.example.tree.binary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 王军
 * @description
 * @date 2022/4/2 11:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node<T extends Comparable<? super T>, U extends Node<T, U>> {
    /**
     * 关键字(键值)
     */
    T key;

    /**
     * 左孩子
     */
    U left;
    /**
     * 右孩子
     */
    U right;
}
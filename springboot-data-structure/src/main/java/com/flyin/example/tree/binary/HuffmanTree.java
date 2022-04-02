//package com.flyin.example.tree.binary;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * 哈夫曼树
// *
// * @author 王军
// * @description
// * @date 2022/4/2 11:12
// */
//@Slf4j
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class HuffmanTree<T extends Comparable<? super T>>{
//    /**
//     * 哈夫曼树的节点(内部类)
//     *
//     * @author fengying
//     * @date 2022/04/02
//     */
//    @EqualsAndHashCode(callSuper = true)
//    @Data
//    static class HuffmanTreeNode<T extends Comparable<? super T>> extends Node<T> {
//        /**
//         * 左孩子
//         */
//        HuffmanTreeNode<T> left;
//        /**
//         * 右孩子
//         */
//        HuffmanTreeNode<T> right;
//
//        public HuffmanTreeNode(T key, HuffmanTreeNode<T> left, HuffmanTreeNode<T> right) {
//            this.key = key;
//            this.left = left;
//            this.right = right;
//        }
//    }
//}
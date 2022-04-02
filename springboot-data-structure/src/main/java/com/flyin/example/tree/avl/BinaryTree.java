package com.flyin.example.tree.avl;

/**
 * @author 王军
 * @description
 * @date 2022/4/2 9:36
 */
public interface BinaryTree<T extends Comparable<? super T>> {
    /**
     * 前序遍历
     */
    void preOrder();

    /**
     * 中序遍历
     */
    void inOrder();

    /**
     * 后序遍历
     */
    void postOrder();

    /**
     * 二分查找
     *
     * @param key 关键
     * @return {@link AvlTree.AvlTreeNode}<{@link T}>
     */
    AvlTree.AvlTreeNode<T> binarySearch(T key);

    /**
     * 迭代搜索
     *
     * @param key 关键
     * @return {@link AvlTree.AvlTreeNode}<{@link T}>
     */
    AvlTree.AvlTreeNode<T> iterativeSearch(T key);

    /**
     * 最低
     *
     * @return {@link T}
     */
    T minimum();

    /**
     * 最大
     *
     * @return {@link T}
     */
    T maximum();

    /**
     * 插入
     *
     * @param key 关键
     */
    void insert(T key);

    /**
     * 删除
     *
     * @param key 关键
     */
    void remove(T key);

    /**
     * 摧毁
     */
    void destroy();

    /**
     * 打印
     */
    void print();
}
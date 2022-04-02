package com.flyin.example.tree.binary;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 王军
 * @description
 * @date 2022/4/2 9:36
 */
@Slf4j
public class BinaryTree<T extends Comparable<? super T>, U extends Node<T, U>> {
    /**
     * 根结点
     */
    protected U mRoot;

    /**
     * 前序遍历
     */
    void preOrder() {
        preOrder(mRoot);
    }

    /**
     * 前序遍历
     *
     * @param tree 树
     */
    private void preOrder(U tree) {
        if (tree != null) {
            log.info("preOrder key {}", tree.key);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param tree 树
     */
    private void inOrder(U tree) {
        if (tree != null) {
            inOrder(tree.left);
            log.info("inOrder key {}", tree.key);
            inOrder(tree.right);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(mRoot);
    }

    /**
     * 后序遍历
     *
     * @param tree 树
     */
    private void postOrder(U tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            log.info("postOrder key {}", tree.key);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(mRoot);
    }

    /**
     * 二分查找
     *
     * @param x   x
     * @param key 关键
     * @return {@link Node}<{@link T}>
     */
    private U binarySearch(U x, T key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return binarySearch(x.left, key);
        } else if (cmp > 0) {
            return binarySearch(x.right, key);
        } else {
            return x;
        }
    }

    /**
     * 二分查找
     *
     * @param key 关键
     * @return {@link Node}<{@link T}>
     */
    public U binarySearch(T key) {
        return binarySearch(mRoot, key);
    }

    /**
     * 迭代搜索
     *
     * @param x   x
     * @param key 关键
     * @return {@link Node}<{@link T}>
     */
    private U iterativeSearch(U x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }

        return null;
    }

    /**
     * 迭代搜索
     *
     * @param key 关键
     * @return {@link Node}<{@link T}>
     */
    public U iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /**
     * 查找最小结点：返回tree为根结点的AVL树的最小结点。
     *
     * @param tree 树
     * @return {@link Node}<{@link T}>
     */
    private U minimum(U tree) {
        if (tree == null) {
            return null;
        }

        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    /**
     * 最小值
     *
     * @return {@link T}
     */
    public T minimum() {
        U p = minimum(mRoot);
        if (p != null) {
            return p.key;
        }

        return null;
    }

    /**
     * 查找最大结点：返回tree为根结点的AVL树的最大结点。
     *
     * @param tree 树
     * @return {@link U}<{@link T}>
     */
    protected U maximum(U tree) {
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    /**
     * 最大值
     *
     * @return {@link T}
     */
    public T maximum() {
        U p = maximum(mRoot);
        return p.key;
    }

    /**
     * 插入
     *
     * @param key 关键
     */
    public void insert(T key) {
        mRoot = insert(mRoot, key);
    }


    /**
     * 插入
     *
     * @param tree AVL树的根结点
     * @param key  插入的结点的键值
     * @return {@link U}<{@link T}> 根节点
     */
    public U insert(U tree, T key) {
        int cmp = key.compareTo(tree.key);

        // 应该将key插入到"tree的左子树"的情况
        if (cmp < 0) {
            tree.left = insert(tree.left, key);
        }
        // 应该将key插入到"tree的右子树"的情况
        else if (cmp > 0) {
            tree.right = insert(tree.right, key);
        }
        return tree;
    }

    /**
     * 删除
     *
     * @param key 键值
     */
    public void remove(T key) {
        U z;
        if ((z = binarySearch(mRoot, key)) != null) {
            mRoot = remove(mRoot, z);
        }
    }

    /**
     * 删除
     *
     * @param tree AVL树的根结点
     * @param z    待删除的结点
     * @return {@link U}<{@link T}> 根节点
     */
    public U remove(U tree, U z) {
        // 根为空 或者 没有要删除的节点，直接返回null。
        if (tree == null || z == null) {
            return null;
        }

        int cmp = z.key.compareTo(tree.key);
        // 待删除的节点在"tree的左子树"中
        if (cmp < 0) {
            tree.left = remove(tree.left, z);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
        }
        // 待删除的节点在"tree的右子树"中
        else if (cmp > 0) {
            tree.right = remove(tree.right, z);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
        } else {    // tree是对应要删除的节点。
            // tree的左右孩子都非空
            if ((tree.left != null) && (tree.right != null)) {
                U max = maximum(tree.left);
                tree.key = max.key;
                tree.left = remove(tree.left, max);
            } else {
                tree = (tree.left != null) ? tree.left : tree.right;
            }
        }

        return tree;
    }


    /**
     * 销毁AVL树
     *
     * @param tree 树
     */
    private void destroy(U tree) {
        if (tree == null) {
            return;
        }

        if (tree.left != null) {
            destroy(tree.left);
        }
        if (tree.right != null) {
            destroy(tree.right);
        }
    }

    /**
     * 摧毁
     */
    public void destroy() {
        destroy(mRoot);
    }

    /**
     * 打印
     *
     * @param tree      树
     * @param key       节点的键值
     * @param direction 0，表示该节点是根节点;
     *                  -1，表示该节点是它的父结点的左孩子;
     *                  1表示该节点是它的父结点的右孩子。
     */
    private void print(U tree, T key, int direction) {
        if (tree != null) {
            if (direction == 0) {
                // tree是根节点
                log.info("{} is root,key {}", tree.key, key);
            } else {
                // tree是分支节点
                log.info("{} is {}'s {} child", tree.key, key, direction == 1 ? "right" : "left");
            }

            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    /**
     * 打印
     */
    public void print() {
        if (mRoot != null) {
            print(mRoot, mRoot.key, 0);
        }
    }
}
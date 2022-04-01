package com.flyin.example.tree.avl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author 王军
 * @description
 * @date 2022/4/1 15:30
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvlNode<T extends Comparable<? super T>> {
    private AvlNode<T> left;
    private AvlNode<T> right;
    private T element;
    private int height;

    public AvlNode(T data) {
        this.element = data;
        height = 1;
    }

    /**
     * 插入
     *
     * @param target 数据
     * @param data   数据
     */
    public AvlNode<T> insert(AvlNode<T> target, AvlNode<T> data) {
        //当前遍历结点
        int compare = data.element.compareTo(target.element);
        if (compare > 0) {
            if (target.right == null) {
                target.right = data;
            } else {
                target.right = insert(target.right, data);
            }
        } else if (compare < 0) {
            if (target.left == null) {
                target.left = data;
            } else {
                target.left = insert(target.left, data);
            }
        }

        if (Math.abs(height(target.left) - height(target.right)) >= 2) {
            log.info("结点处不平衡，节点值为{}", this.element);
            //左右旋转
//            if (height(left) > height(right)) {
//                if (height(left.left) > height(left.right)) {
//                    //右旋
//                    rightRotate(this);
//                } else {
//                    //右左旋
//                    rightLeftRotate(this);
//                }
//            } else {
//                if (height(right.right) > height(right.left)) {
//                    leftRotate(this);
//                } else {
//                    leftRightRotate(this);
//                }
//            }

        }
        target.height = Math.max(height(target.left), height(target.right)) + 1;

        return target;
    }

    /**
     * 左旋转
     *
     * @param data 数据
     * @return {@link AvlNode}<{@link T}>
     */
    private AvlNode<T> leftRotate(AvlNode<T> data) {
        AvlNode<T> root = data.right;
        root.left = data;
        return root;
    }

    /**
     * 右旋
     *
     * @param data 数据
     * @return {@link AvlNode}<{@link T}>
     */
    private AvlNode<T> rightRotate(AvlNode<T> data) {
        AvlNode<T> root = data.left;
        root.right = data;
        return root;
    }


    /**
     * 先左旋再右旋
     *
     * @param data 数据
     * @return {@link AvlNode}<{@link T}>
     */
    private AvlNode<T> leftRightRotate(AvlNode<T> data) {
        data.left = leftRotate(data.left);
        return rightRotate(data);
    }

    /**
     * 先右旋再左旋
     *
     * @param data 数据
     * @return {@link AvlNode}<{@link T}>
     */
    private AvlNode<T> rightLeftRotate(AvlNode<T> data) {
        data.right = leftRotate(data.right);
        return rightRotate(data);
    }


    /**
     * 删除
     *
     * @param data 数据
     */
    public void delete(T data) {

    }

    /**
     * 高度
     *
     * @param data 数据
     * @return int
     */
    private int height(AvlNode<T> data) {
        if (data == null) {
            return 0;
        } else {
            return data.height;
        }
    }

    /**
     * 打印
     */
    public void print() {
        Queue<AvlNode<T>> queue = new ArrayDeque<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            AvlNode<T> remove = queue.remove();
            log.info("遍历到当前结点,结点值为{}", remove.element);
            log.info("遍历到当前结点,结点高度为{}", remove.height);
            if (remove.left != null) {
                queue.add(remove.left);
            }

            if (remove.right != null) {
                queue.add(remove.right);
            }
        }
    }
}
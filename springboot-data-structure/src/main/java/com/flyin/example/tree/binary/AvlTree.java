package com.flyin.example.tree.binary;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * avl树
 *
 * @author 王军
 * @description
 * @date 2022/4/1 15:34
 */
@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
@NoArgsConstructor
public class AvlTree<T extends Comparable<? super T>> extends BinaryTree<T, AvlTree.AvlTreeNode<T>> {

    /**
     * AVL树的节点(内部类)
     *
     * @author fengying
     * @date 2022/04/02
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    static class AvlTreeNode<T extends Comparable<? super T>> extends Node<T, AvlTreeNode<T>> {
        /**
         * 高度
         */
        int height;

        public AvlTreeNode(T key, AvlTreeNode<T> left, AvlTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    /**
     * 获取树的高度
     *
     * @param tree 树
     * @return int
     */
    private int height(AvlTreeNode<T> tree) {
        if (tree != null) {
            return tree.height;
        }

        return 0;
    }

    /**
     * 高度
     *
     * @return int
     */
    public int height() {
        return height(mRoot);
    }

    /**
     * 比较两个值的大小
     *
     * @param a a
     * @param b b
     * @return int
     */
    private int max(int a, int b) {
        return Math.max(a, b);
    }


    /**
     * 左左型号 右旋转
     *
     * @param k2 k2
     * @return {@link AvlTreeNode}<{@link T}>
     */
    private AvlTreeNode<T> leftLeftRotation(AvlTreeNode<T> k2) {
        AvlTreeNode<T> k1;

        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        //旋转后要更新高度信息
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;

        return k1;
    }

    /**
     * 右右型 左旋转
     *
     * @param k1 k1
     * @return {@link AvlTreeNode}<{@link T}>
     */
    private AvlTreeNode<T> rightRightRotation(AvlTreeNode<T> k1) {
        AvlTreeNode<T> k2;

        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;

        return k2;
    }

    /**
     * 左右旋转
     *
     * @param k3 k3
     * @return {@link AvlTreeNode}<{@link T}>
     */
    private AvlTreeNode<T> leftRightRotation(AvlTreeNode<T> k3) {
        k3.left = rightRightRotation(k3.left);

        return leftLeftRotation(k3);
    }

    /**
     * 右左旋转
     *
     * @param k1 k1
     * @return {@link AvlTreeNode}<{@link T}>
     */
    private AvlTreeNode<T> rightLeftRotation(AvlTreeNode<T> k1) {
        k1.right = leftLeftRotation(k1.right);

        return rightRightRotation(k1);
    }

    /**
     * 插入
     *
     * @param tree AVL树的根结点
     * @param key  插入的结点的键值
     * @return {@link AvlTreeNode}<{@link T}> 根节点
     */
    @Override
    public AvlTreeNode<T> insert(AvlTreeNode<T> tree, T key) {
        if (tree == null) {
            // 新建节点
            tree = new AvlTreeNode<>(key, null, null);
        } else {
            int cmp = key.compareTo(tree.key);

            // 应该将key插入到"tree的左子树"的情况
            if (cmp < 0) {
                tree.left = insert(tree.left, key);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.left) - height(tree.right) == 2) {
                    //当前值插入到目标结点的左树的左
                    if (key.compareTo(tree.left.key) < 0) {
                        //左左型 右旋
                        tree = leftLeftRotation(tree);
                    }
                    //当前值插入到目标结点的左树的右
                    else {
                        //左右型 左右旋转
                        tree = leftRightRotation(tree);
                    }
                }
            }
            // 应该将key插入到"tree的右子树"的情况
            else if (cmp > 0) {
                tree.right = insert(tree.right, key);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.right) - height(tree.left) == 2) {
                    //当前值插入到目标结点的右树的右
                    if (key.compareTo(tree.right.key) > 0) {
                        //右旋
                        tree = rightRightRotation(tree);
                    }
                    //当前值插入到目标结点的右树的左
                    else {
                        //右左旋
                        tree = rightLeftRotation(tree);
                    }
                }
            }
        }

        tree.height = max(height(tree.left), height(tree.right)) + 1;

        return tree;
    }

    /**
     * 删除
     *
     * @param tree AVL树的根结点
     * @param z    待删除的结点
     * @return {@link AvlTreeNode}<{@link T}> 根节点
     */
    @Override
    public AvlTreeNode<T> remove(AvlTreeNode<T> tree, AvlTreeNode<T> z) {
        // 根为空 或者 没有要删除的节点，直接返回null。
        if (tree == null || z == null) {
            return null;
        }

        int cmp = z.key.compareTo(tree.key);
        // 待删除的节点在"tree的左子树"中
        if (cmp < 0) {
            tree.left = remove(tree.left, z);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.right) - height(tree.left) == 2) {
                AvlTreeNode<T> r = tree.right;
                if (height(r.left) > height(r.right)) {
                    tree = rightLeftRotation(tree);
                } else {
                    tree = rightRightRotation(tree);
                }
            }
        }
        // 待删除的节点在"tree的右子树"中
        else if (cmp > 0) {
            tree.right = remove(tree.right, z);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.left) - height(tree.right) == 2) {
                AvlTreeNode<T> l = tree.left;
                if (height(l.right) > height(l.left)) {
                    tree = leftRightRotation(tree);
                } else {
                    tree = leftLeftRotation(tree);
                }
            }
        } else {    // tree是对应要删除的节点。
            // tree的左右孩子都非空
            if ((tree.left != null) && (tree.right != null)) {
                if (height(tree.left) > height(tree.right)) {
                    // 如果tree的左子树比右子树高；
                    // 则(01)找出tree的左子树中的最大节点
                    //   (02)将该最大节点的值赋值给tree。
                    //   (03)删除该最大节点。
                    // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
                    AvlTreeNode<T> max = maximum(tree.left);
                    tree.key = max.key;
                    tree.left = remove(tree.left, max);
                } else {
                    // 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
                    // 则(01)找出tree的右子树中的最小节点
                    //   (02)将该最小节点的值赋值给tree。
                    //   (03)删除该最小节点。
                    // 这类似于用"tree的右子树中最小节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
                    AvlTreeNode<T> min = maximum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);
                }
            } else {
                tree = (tree.left != null) ? tree.left : tree.right;
            }
        }

        return tree;
    }
}
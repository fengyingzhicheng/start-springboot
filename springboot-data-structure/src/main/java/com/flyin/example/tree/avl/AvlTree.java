package com.flyin.example.tree.avl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * avl树
 *
 * @author 王军
 * @description
 * @date 2022/4/1 15:34
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvlTree<T extends Comparable<? super T>> implements BinaryTree<T> {
    /**
     * 根结点
     */
    private AvlTreeNode<T> mRoot;

    /**
     * AVL树的节点(内部类)
     *
     * @author fengying
     * @date 2022/04/02
     */
    static class AvlTreeNode<T extends Comparable<? super T>> {
        /**
         * 关键字(键值)
         */
        T key;
        /**
         * 高度
         */
        int height;
        /**
         * 左孩子
         */
        AvlTreeNode<T> left;
        /**
         * 右孩子
         */
        AvlTreeNode<T> right;

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
     * 前序遍历
     *
     * @param tree 树
     */
    private void preOrder(AvlTreeNode<T> tree) {
        if (tree != null) {
            log.info("preOrder key {}", tree.key);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /**
     * 前序遍历
     */
    @Override
    public void preOrder() {
        preOrder(mRoot);
    }

    /**
     * 中序遍历
     *
     * @param tree 树
     */
    private void inOrder(AvlTreeNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            log.info("inOrder key {}", tree.key);
            inOrder(tree.right);
        }
    }

    /**
     * 中序遍历
     */
    @Override
    public void inOrder() {
        inOrder(mRoot);
    }

    /**
     * 后序遍历
     *
     * @param tree 树
     */
    private void postOrder(AvlTreeNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            log.info("postOrder key {}", tree.key);
        }
    }

    /**
     * 后序遍历
     */
    @Override
    public void postOrder() {
        postOrder(mRoot);
    }

    /**
     * 二分查找
     *
     * @param x   x
     * @param key 关键
     * @return {@link AvlTreeNode}<{@link T}>
     */
    private AvlTreeNode<T> binarySearch(AvlTreeNode<T> x, T key) {
        if (x == null) {
            return x;
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
     * @return {@link AvlTreeNode}<{@link T}>
     */
    @Override
    public AvlTreeNode<T> binarySearch(T key) {
        return binarySearch(mRoot, key);
    }

    /**
     * 迭代搜索
     *
     * @param x   x
     * @param key 关键
     * @return {@link AvlTreeNode}<{@link T}>
     */
    private AvlTreeNode<T> iterativeSearch(AvlTreeNode<T> x, T key) {
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
     * @return {@link AvlTreeNode}<{@link T}>
     */
    @Override
    public AvlTreeNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /**
     * 查找最小结点：返回tree为根结点的AVL树的最小结点。
     *
     * @param tree 树
     * @return {@link AvlTreeNode}<{@link T}>
     */
    private AvlTreeNode<T> minimum(AvlTreeNode<T> tree) {
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
    @Override
    public T minimum() {
        AvlTreeNode<T> p = minimum(mRoot);
        if (p != null) {
            return p.key;
        }

        return null;
    }

    /**
     * 查找最大结点：返回tree为根结点的AVL树的最大结点。
     *
     * @param tree 树
     * @return {@link AvlTreeNode}<{@link T}>
     */
    private AvlTreeNode<T> maximum(AvlTreeNode<T> tree) {
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
    @Override
    public T maximum() {
        AvlTreeNode<T> p = maximum(mRoot);
        if (p != null) {
            return p.key;
        }

        return null;
    }

    /**
     * 左左旋转
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
     * 右右旋转
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
    private AvlTreeNode<T> insert(AvlTreeNode<T> tree, T key) {
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
                        //左旋
                        tree = leftLeftRotation(tree);
                    }
                    //当前值插入到目标结点的左树的右
                    else {
                        //左右旋
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
     * 插入
     *
     * @param key 关键
     */
    @Override
    public void insert(T key) {
        mRoot = insert(mRoot, key);
    }

    /**
     * 删除
     *
     * @param tree AVL树的根结点
     * @param z    待删除的结点
     * @return {@link AvlTreeNode}<{@link T}> 根节点
     */
    private AvlTreeNode<T> remove(AvlTreeNode<T> tree, AvlTreeNode<T> z) {
        // 根为空 或者 没有要删除的节点，直接返回null。
        if (tree == null || z == null) {
            return null;
        }

        int cmp = z.key.compareTo(tree.key);
        if (cmp < 0) {        // 待删除的节点在"tree的左子树"中
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
        } else if (cmp > 0) {    // 待删除的节点在"tree的右子树"中
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

    /**
     * 删除
     *
     * @param key 键值
     */
    @Override
    public void remove(T key) {
        AvlTreeNode<T> z;

        if ((z = binarySearch(mRoot, key)) != null) {
            mRoot = remove(mRoot, z);
        }
    }

    /**
     * 销毁AVL树
     *
     * @param tree 树
     */
    private void destroy(AvlTreeNode<T> tree) {
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
    @Override
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
    private void print(AvlTreeNode<T> tree, T key, int direction) {
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
    @Override
    public void print() {
        if (mRoot != null) {
            print(mRoot, mRoot.key, 0);
        }
    }
}
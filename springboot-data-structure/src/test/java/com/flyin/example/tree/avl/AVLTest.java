package com.flyin.example.tree.avl;

import com.flyin.example.tree.service.Tree;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 王军
 * @description
 * @date 2022/4/1 15:32
 */

public class AVLTest {
    Tree<Integer> tree;

    @Before
    public void initAvlTree() {
        tree=new AvlTree<>(new AvlNode<>(12));
        tree.insert(13);
        tree.insert(9);
        tree.insert(10);
        tree.insert(11);
    }

    @Test
    public void testAvl() {
        System.out.println("ok");
        tree.print();
    }
}
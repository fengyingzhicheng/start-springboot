package com.flyin.example.tree.binary;

import org.junit.Before;
import org.junit.Test;

/**
 * @author 王军
 * @description
 * @date 2022/4/1 15:32
 */

public class AVLTest {

    @Before
    public void initAvlTree() {
        //tree=new AvlTree<>(new AvlNode<>(12));
        //tree.insert(13);
        //tree.insert(9);
        //tree.insert(10);
        //tree.insert(11);
    }

    @Test
    public void testAvl() {
        AvlTree<Integer> avlTree = new AvlTree<Integer>();
        avlTree.insert(12);
        avlTree.insert(13);
        avlTree.insert(9);
        avlTree.insert(10);
        avlTree.insert(11);
        avlTree.print();
    }
}
package com.flyin.example.tree.avl;

import com.flyin.example.tree.service.Tree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 王军
 * @description
 * @date 2022/4/1 15:34
 */

@Data
@AllArgsConstructor
public class AvlTree<T extends Comparable<? super T>> implements Tree<T> {
    private AvlNode<T> root;

    @Override
    public void insert(T data) {
        root.insert(new AvlNode<>(data));
    }

    @Override
    public void delete(T data) {
        root.delete(data);
    }

    @Override
    public void print() {
        root.print();
    }


}
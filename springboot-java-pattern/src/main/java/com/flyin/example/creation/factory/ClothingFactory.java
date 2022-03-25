package com.flyin.example.creation.factory;

import com.flyin.example.creation.simplefactory.Clothing;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 15:11
 */
public abstract class ClothingFactory {
    //工厂方法，此方法可以创建工厂
    public abstract Clothing createClothing();
}
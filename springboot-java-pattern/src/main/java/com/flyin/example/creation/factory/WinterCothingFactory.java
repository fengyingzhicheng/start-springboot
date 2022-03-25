package com.flyin.example.creation.factory;

import com.flyin.example.creation.simplefactory.Clothing;
import com.flyin.example.creation.simplefactory.WinterClothing;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 15:12
 */
public class WinterCothingFactory extends ClothingFactory{

    @Override
    public Clothing createClothing() {
        return new WinterClothing();
    }

}
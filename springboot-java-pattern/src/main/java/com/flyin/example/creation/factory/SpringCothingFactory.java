package com.flyin.example.creation.factory;

import com.flyin.example.creation.simplefactory.Clothing;
import com.flyin.example.creation.simplefactory.SpringClothing;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 15:11
 */
public class SpringCothingFactory extends ClothingFactory{

    @Override
    public Clothing createClothing() {
        return new SpringClothing();
    }

}
package com.flyin.example.creation.simplefactory;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 15:10
 */
public class ClothingFactory {
    public static Object createClothing(String  type){
        if("SPRING".equals(type)){
            return new SpringClothing();
        }else if("WINTER".equals(type)){
            return new WinterClothing();
        }else{
            return null;
        }
    }
}
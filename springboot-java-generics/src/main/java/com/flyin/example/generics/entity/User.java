package com.flyin.example.generics.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 王军
 * @description 泛型是一种技术，也可以理解为对泛型类和泛型接口的统称，类似ArrayList<T>中的T不叫泛型，而叫类型参数(Type Parameter)，也叫形式类型参数。
 * 使用泛型时，比如ArrayList<String>，T被替换为String，可以看做是对T的“赋值”，这里的String称为实际类型参数(actual type parameter)。
 * 实际类型参数用来为类型参数赋值，把ArrayList<T>由泛化通用的模板变为特定类型的类。
 * 你还可以把泛型理解为：变量是对数据的抽取，而泛型是对变量类型的抽取，抽取成类型参数，抽象层次更高。
 * @date 2021/12/23 14:47
 */
@Data
public class User {
    private Integer age;
    private String name;
    private Date birthDate;

    //public User getUser(T t){...}
}
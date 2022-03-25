package com.flyin.example.stream;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 9:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Student extends Human {
    private Integer score;


    public Student(String name, Integer age, Integer score) {
        super(name, age);
        this.score = score;
    }
}
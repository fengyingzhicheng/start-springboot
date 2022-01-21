package com.flyin.example.service;

import lombok.Data;

/**
 * @author 王军
 * @description Employee
 * @date 2022/1/9 17:37
 */
@Data
public class Employee {
    /**
     * 指定员工在哪一天休息
     */
    private WeekDay restDay;
}
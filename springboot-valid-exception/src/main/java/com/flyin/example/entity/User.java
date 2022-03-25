package com.flyin.example.entity;

/**
 * @author 王军
 * @description
 * @date 2022/3/4 14:04
 */

import lombok.Data;

import java.time.LocalDateTime;

/**
 * User entity.
 *
 * @author pdai
 */
@Data
public class User {
    private Long id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

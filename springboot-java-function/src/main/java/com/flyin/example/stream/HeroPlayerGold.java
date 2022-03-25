package com.flyin.example.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author 王军
 * @description HeroPlayerGold
 * @date 2022/2/8 10:50
 */
@Data
@ToString
@AllArgsConstructor
public class HeroPlayerGold {
    /** 使用的英雄名字 */
    private String hero;
    /** 玩家的ID */
    private String player;
    /** 获得的金币数 */
    private int gold;
}
package com.flyin.example.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author 王军
 * @description
 * @date 2022/2/8 10:53
 */
@Data
@ToString
@AllArgsConstructor
public class PlayerGold {
    /** 玩家的ID */
    private String player;
    /** 获得的金币数 */
    private int gold;
}
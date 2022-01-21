package com.flyin.example.pojo;

/**
 * @author 王军
 * @description
 * @date 2022/1/9 18:01
 */

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author qiyu
 */
@Getter
@Setter
public class BasePojo {

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Boolean deleted;
}
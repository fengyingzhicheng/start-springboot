package com.flyin.example.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flyin.example.service.WeekDay;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 王军
 * @description
 * @date 2022/1/9 17:52
 */
@Data
@TableName( "tk_user")
public class TkUserPojo extends BasePojo {
    /**
     * 主键id
     */
    @Id
    @ApiModelProperty(value = "id", dataType = "Long", required = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    @ApiModelProperty(value = "姓名", dataType = "String", required = true)
    private String name;

    @ApiModelProperty(value = "年龄", dataType = "String", required = true)
    private Integer age;

    @ApiModelProperty(value = "用户类型", dataType = "Integer", required = true, hidden = true)
    private Integer userType;
    private WeekDay restDay;
}
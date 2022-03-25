package com.flyin.example.entity;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * @author 王军
 * @description
 * @date 2022/3/4 14:36
 */
@Data
@Builder
@ApiModel(value = "User", subTypes = {AddressParam.class})
public class AddressParam {
}
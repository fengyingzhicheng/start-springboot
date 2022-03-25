package com.flyin.example.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

/**
 * @author 王军
 * @description
 * @date 2022/3/4 14:58
 */
@Data
@Builder
public class ExceptionData {

    @Singular
    private final List<Object> errors;

}
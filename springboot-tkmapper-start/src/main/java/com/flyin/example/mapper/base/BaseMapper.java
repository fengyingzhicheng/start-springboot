package com.flyin.example.mapper.base;

import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author 王军
 * @description BaseMapper
 * @date 2021/12/7 15:07
 */
@RegisterMapper
public interface BaseMapper<T> extends Mapper<T>, IdListMapper<T, Long>, InsertListMapper<T> {
}
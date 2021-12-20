package com.flyin.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flyin.example.pojo.MpUserPojo;

/**
 * 继承MyBatis-Plus提供的BaseMapper，提供了增删改查及分页方法，基本已经完全满足日常开发需求
 *
 * @author 王军
 */
public interface MpUserMapper extends BaseMapper<MpUserPojo> {
}
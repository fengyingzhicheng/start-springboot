package com.flyin.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flyin.example.mapper.MpUserMapper;
import com.flyin.example.pojo.MpUserPojo;
import org.springframework.stereotype.Service;

/**
 * 继承MyBatis-Plus提供的ServiceImpl，定好Mapper和DO
 * 实现自己的Service接口
 *
 * @author 王军
 * @date 2020-09-13 16:39
 */
@Service
public class MpUserServiceImpl extends ServiceImpl<MpUserMapper, MpUserPojo> implements MpUserService {
}
package com.flyin.example.service.impl;

import com.flyin.example.mapper.PmsProductMapper;
import com.flyin.example.pojo.PmsProduct;
import com.flyin.example.service.IPmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 王军
 * @description PmsProductService
 * @date 2021/12/7 15:41
 */
@Service
public class PmsProductService implements IPmsProductService {
    @Autowired
    PmsProductMapper pmsProductMapper;

    @Override
    public List<PmsProduct> getPmsProductList(Integer previewStatus) {
        Example example = new Example(PmsProduct.class);
        example.createCriteria().andEqualTo("previewStatus",previewStatus);
        return pmsProductMapper.selectByExample(example);
    }
}
package com.flyin.example.service;

import com.flyin.example.pojo.PmsProduct;

import java.util.List;

/**
 * @author 王军
 * @description
 * @date 2021/12/7 15:46
 */
public interface IPmsProductService {
    List<PmsProduct> getPmsProductList(Integer previewStatus);
}
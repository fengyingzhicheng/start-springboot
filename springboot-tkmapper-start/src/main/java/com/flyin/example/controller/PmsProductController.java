package com.flyin.example.controller;

import com.flyin.example.pojo.PmsProduct;
import com.flyin.example.service.impl.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author 王军
 * @description
 * @date 2021/12/7 15:48
 */
@RequestMapping("/pmsProduct")
@RestController
public class PmsProductController {
    @Autowired
    PmsProductService pmsProductService;

    @GetMapping("/getPmsProductList")
    public List<PmsProduct> getPmsProductList(@PathParam("previewStatus") Integer previewStatus) {
        return pmsProductService.getPmsProductList(previewStatus);
    }

    @GetMapping("/test")
    public String test() {
        return "hello";
    }
}
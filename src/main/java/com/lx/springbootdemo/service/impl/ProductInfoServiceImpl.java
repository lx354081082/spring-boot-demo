package com.lx.springbootdemo.service.impl;

import com.lx.springbootdemo.enums.ProductStatusEunm;
import com.lx.springbootdemo.pojo.ProductInfo;
import com.lx.springbootdemo.repository.ProductCategoryRepository;
import com.lx.springbootdemo.repository.ProductInfoRepository;
import com.lx.springbootdemo.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lx on 2018/1/22
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductInfoRepository productInfoRepository;

    //全部上架商品
    @Override
    public List<ProductInfo> getUpList() {
        return productInfoRepository.findAllByProductStatus(ProductStatusEunm.UP.getCode());
    }
}

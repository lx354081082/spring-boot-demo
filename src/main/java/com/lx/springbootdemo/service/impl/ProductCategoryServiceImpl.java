package com.lx.springbootdemo.service.impl;

import com.lx.springbootdemo.pojo.ProductCategory;
import com.lx.springbootdemo.repository.ProductCategoryRepository;
import com.lx.springbootdemo.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lx on 2018/1/22
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getByIds(List<Integer> cetegoryIds) {
        return productCategoryRepository.findByCategoryIdIn(cetegoryIds);
    }
}

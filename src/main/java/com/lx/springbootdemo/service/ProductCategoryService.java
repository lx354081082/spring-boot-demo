package com.lx.springbootdemo.service;

import com.lx.springbootdemo.pojo.ProductCategory;

import java.util.List; /**
 * Created by lx on 2018/1/22
 */
public interface ProductCategoryService {
    List<ProductCategory> getByIds(List<Integer> cetegoryIds);
}

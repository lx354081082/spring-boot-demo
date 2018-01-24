package com.lx.springbootdemo.repository;

import com.lx.springbootdemo.pojo.ProductCategory;
import com.lx.springbootdemo.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lx on 2018/1/20
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryIdIn(List<Integer> ids);
}

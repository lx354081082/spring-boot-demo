package com.lx.springbootdemo.repository;

import com.lx.springbootdemo.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lx on 2018/1/22
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findAllByProductStatus(Integer productStatus);
    ProductInfo findByProductId(String productId);
}

package com.lx.springbootdemo.controller;

import com.lx.springbootdemo.pojo.ProductCategory;
import com.lx.springbootdemo.pojo.ProductInfo;
import com.lx.springbootdemo.service.ProductCategoryService;
import com.lx.springbootdemo.service.ProductInfoService;
import com.lx.springbootdemo.utils.ReturnUtils;
import com.lx.springbootdemo.vo.ProductCategoryVO;
import com.lx.springbootdemo.vo.ProductInfoVO;
import com.lx.springbootdemo.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lx on 2018/1/22
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    ProductInfoService productInfoService;
    @Autowired
    ProductCategoryService productCategoryService;
    @GetMapping("/list")
    public ResultVO list() {
        //全部上架商品
        List<ProductInfo> upList = productInfoService.getUpList();
        //种类id集合
        List<Integer> cetegoryIds = new ArrayList<>();
        for (ProductInfo p : upList) {
            if (!cetegoryIds.contains(p.getCategoryType())) {
                cetegoryIds.add(p.getCategoryType());
            }
        }
        //种类集合详情
        List<ProductCategory> productCategoryList = productCategoryService.getByIds(cetegoryIds);

        /**
         * 商品品牌
         * name
         * type
         * foods list
         */
        List<ProductCategoryVO> productCategoryVOList = new ArrayList<>();
        for (ProductCategory pc:productCategoryList) {
            ProductCategoryVO productCategoryVO = new ProductCategoryVO();
            BeanUtils.copyProperties(pc,productCategoryVO);
            //商品详情VO LIST
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo p : upList) {
                ProductInfoVO productInfoVO = new ProductInfoVO();
                if (p.getCategoryType().equals(productCategoryVO.getCategoryType())) {
                    BeanUtils.copyProperties(p, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productCategoryVO.setList(productInfoVOList);
            productCategoryVOList.add(productCategoryVO);
        }

        return ReturnUtils.success(productCategoryVOList);
    }
}

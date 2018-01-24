package com.lx.springbootdemo.enums;

import lombok.Getter;

/**
 * Created by lx on 2018/1/22
 * 商品状态枚举
 */
@Getter
public enum ProductStatusEunm {
    UP(0,"上架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEunm(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

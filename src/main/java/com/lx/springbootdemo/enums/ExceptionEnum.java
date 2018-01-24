package com.lx.springbootdemo.enums;

import lombok.Getter;

/**
 * Created by lx on 2018/1/23
 */
@Getter
public enum ExceptionEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    PRODUCT_ERROR(-10,"库存不足")
    ;
    private Integer code;
    private String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

package com.lx.springbootdemo.enums;

import lombok.Getter;

/**
 * Created by lx on 2018/1/22
 * 订单状态枚举
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消")
    ;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
}

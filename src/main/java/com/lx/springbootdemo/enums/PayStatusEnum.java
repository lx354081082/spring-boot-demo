package com.lx.springbootdemo.enums;

import lombok.Getter;

/**
 * Created by lx on 2018/1/22
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"未支付"),
    SUCCESS(1, "支付成功")
    ;
    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
}

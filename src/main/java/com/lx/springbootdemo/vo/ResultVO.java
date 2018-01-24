package com.lx.springbootdemo.vo;

import lombok.Data;

/**
 * Created by lx on 2018/1/22
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}

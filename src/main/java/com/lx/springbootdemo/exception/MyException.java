package com.lx.springbootdemo.exception;

import com.lx.springbootdemo.enums.ExceptionEnum;
import lombok.Data;

/**
 * Created by lx on 2018/1/23
 * 自定义异常
 */
@Data
public class MyException extends RuntimeException {
    private Integer code;

    public MyException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }
    public MyException(String messsge,Integer code) {
        super(messsge);
        this.code = code;
    }
}

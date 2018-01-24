package com.lx.springbootdemo.exception.handler;

import com.lx.springbootdemo.exception.MyException;
import com.lx.springbootdemo.vo.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lx on 2018/1/23
 * json
 * 全局异常统一处理
 * 异常处理器
 */
@ControllerAdvice
public class MyExceptionHandler {
    /**
     * 处理MyException异常
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ResultVO jsonErrorHandler(MyException e) {
        ResultVO rvo = new ResultVO();
        rvo.setCode(e.getCode());
        rvo.setMsg(e.getMessage());
        return rvo;
    }
}

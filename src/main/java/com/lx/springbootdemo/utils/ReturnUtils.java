package com.lx.springbootdemo.utils;

import com.lx.springbootdemo.enums.ExceptionEnum;
import com.lx.springbootdemo.vo.ResultVO;

/**
 * Created by lx on 2018/1/22
 * 返回值工具类 统一返回格式
 */
public class ReturnUtils {
    public static ResultVO success(Object o) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(o);
        return resultVO;
    }
    public static ResultVO success() {
        return success(null);
    }

    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;
    }

    /**
     * 返回异常信息，在已知的范围内
     */
    public static ResultVO error(ExceptionEnum exceptionEnum){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(exceptionEnum.getCode());
        resultVO.setMsg(exceptionEnum.getMessage());
        resultVO.setData(null);
        return resultVO;
    }
}

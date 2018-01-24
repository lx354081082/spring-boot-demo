package com.lx.springbootdemo.utils;

import java.util.Random;

/**
 * Created by lx on 2018/1/22
 * 生成ID工具类
 */
public class Idutil {
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(500000) + 200;
        return System.currentTimeMillis()+String.valueOf(number);
    }

}

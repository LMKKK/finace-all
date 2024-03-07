package com.finace.common.utils;

public class MyUtil {
    /**
     * 随机生成num位数字
     *
     * @param length 数字的长度
     * @return
     */
    public static int getRandom(int length) {
        return (int) ((Math.random() * 9 + 1) * Math.pow(10, length - 1));
    }
}
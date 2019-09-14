package com.gouyanzhan.nine.example1;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 10:19:13
 */
public class ExceptionDemo {
    public static void main(String[] args){
        //字符串的内容为null
        String str = null;
        //获取字符串的长度
        int strLength = str.length();
        System.out.println("strLength 的长度：" + strLength);
    }

}

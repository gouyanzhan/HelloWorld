package com.gouyanzhan.nine.example1;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 10:26:54
 */
public class ExceptionDemo1 {
    public static void printLength() {
        //设置字符串的内容为null
        String str = null;
        //获取字符串的长度
        int strLength = str.length();
        System.out.println("strLength的长度：" + strLength);
    }
    public static void main(String[] args){
        printLength();
    }


}

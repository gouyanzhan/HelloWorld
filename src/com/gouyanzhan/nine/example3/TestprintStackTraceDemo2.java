package com.gouyanzhan.nine.example3;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 11:23:03
 */
public class TestprintStackTraceDemo2 {
    public static void main(String[] args){
        //对method1方法进行异常处理
        try {
            //调用method1方法
            method1();
        }catch (NullPointerException e)
        {
            //获取异常信息
            e.printStackTrace();
        }
    }
    static void method1(){
        //调用method2方法
        method2();
    }
    static void method2(){
        //调用method3方法
        method3();
    }
    static void method3(){
        //字符串的值为null
        String str = null;
        //获取字符串的长度
        int n = str.length();
    }

}

package com.gouyanzhan.nine.example3;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 11:14:09
 */
public class TestprintStackTraceDemo {
    public static void main(String[] args){
       //调用method1方法
        method1();
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

package com.gouyanzhan.clazz;

/**
 * @author Yanzhan Gou
 * @date 2019-03-11 20:50:58
 */
public class OverloadDemo {
    //定义一系列的方法，这些方法的参数是不同的，通过参数来区别调用的方法
    void method(){
        System.out.println("无参数方法被调用");
    }
    void method(int a){
        System.out.println("参数为int类型被调用");
    }
    void method(double b){
        System.out.println("参数为double方法被调用");
    }
    void method(String s){
        System.out.println("参数为String方法被调用");
    }
}

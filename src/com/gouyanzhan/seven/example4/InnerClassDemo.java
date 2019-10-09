package com.gouyanzhan.seven.example4;

/**
 * @author Yanzhan Gou
 * @date 2019-09-16 22:22:38
 */
public class InnerClassDemo{
    public static void main(String[] args){
        //创建一个对象
        Outer out = new Outer();
        //调用该类的内部类定义的方法
        out.useIner();
    }
}

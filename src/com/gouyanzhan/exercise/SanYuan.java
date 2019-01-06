package com.gouyanzhan.exercise;

public class SanYuan {
    public static void main(String[]args){
        //声明一系列的int类型变量
        int i,k;
        i=5;
        //使用三元运算符对k进行赋值操作
        k=(i>=0?i:-i);
        System.out.println("the absolute of"+i+"is"+k);
        i = -5;
        k =(i>=0?i:-i);
        System.out.println("the absolute of"+i+"is"+k);
    }
}

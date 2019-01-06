package com.gouyanzhan.exercise;

public class ZiDongZhuanHuan {
    public static void main(String[]args){
        short s = 3;  //定义一个short类型变量
        int i = s;  //short自动类型转换为int
        float f = 1.0f;  //定义一个float类型变量
        double d1 = f;  //float自动类型转换为double
        long l=234L;  //定义一个long类型的变量
        double d2 = l;  //long自动类型转换为double
        System.out.println("short自动类型转换为int后的值等于" + i);
        System.out.println("float自动类型转换为double后的值等于" + d1);
        System.out.println("long自动类型转换为double后的值等于" + d2);

    }
}

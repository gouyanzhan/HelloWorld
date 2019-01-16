package com.gouyanzhan.exercise;

public class ZiDongZhuanHuan {
    public static void main(String[] args) {
        //定义一个short类型变量
        short s = 3;
        printAutomaticConversion1(s);
        //定义一个float类型变量
        float f = 1.0f;
        printAutomaticConversion2(f);
        //定义一个long类型的变量
        long l = 234L;
        printAutomaticConversion3(l);
    }

    private static void printAutomaticConversion1(short a) {
        //short自动类型转换为int
        int i = a;
        System.out.println("short自动类型转换为int后的值等于" + i);
    }

    private static void printAutomaticConversion2(float b) {
        //float自动类型转换为double
        double d1 = b;
        System.out.println("float自动类型转换为double后的值等于" + d1);
    }

    private static void printAutomaticConversion3(long c) {
        //long自动类型转换为double
        double d2 = c;
        System.out.println("long自动类型转换为double后的值等于" + d2);
    }

}

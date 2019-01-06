package com.gouyanzhan.exercise;

public class JinZhi {
    public static void main(String[]args){
        int a10 = 12;  //定义一个十进制数值
        int a8 = 012;   //定义一个八进制数值
        int a16 = 0X12;  //定义一个以数字表示的十六进制整数
        int b16 = 0xcafe;  //定义一个以字母表示的十六进制整数
        System.out.println("十进制12等于" + a10);
        System.out.println("八进制12等于" + a8);
        System.out.println("第一个十六进制数值等于" + a16);
        System.out.println("第二个十六进制数值等于" + b16);
    }
}

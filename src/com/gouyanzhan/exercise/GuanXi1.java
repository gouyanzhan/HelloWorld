package com.gouyanzhan.exercise;

public class GuanXi1 {
    public static void main(String[]args){
        int i = 5;  //定义一个int类型的变量
        double d = 5.0;  //定义一个double类型的变量
        boolean b1 =(i==d);  //运用关系运算符的结果
        System.out.println("b1的结果为：" + b1);
        char c = 'a';  //定义一个char类型变量
        long l =97L;  //定义一个long类型变量
        boolean b2 =(c==l);  //运用关系运算符的结果
        System.out.println("b2的结果为：" + b2);
        boolean bl1 = true;  //定义一个boolean类型变量
        boolean bl2 = false;  //定义一个boolean类型变量
        boolean b3 =(bl1 == bl2);  //运用关系运算符的结果
        System.out.println("b3的结果为：" + b3);
        System.out.println("d的结果：" + d);

    }
}

package com.gouyanzhan.exercise;

public class SuanShu {
    public static void main(String[]args){
        int i1 = 7;
        int i2 = 3;
        printCount(i1,i2);

    }

    /**
     * 计算加减乘除
     * @param a 传入一个int型参数a
     * @param b 传入一个int型参数b
     */
    private static void printCount(int a,int b){
        int jia = a + b;
        int jian = a - b;
        int cheng = a * b;
        int chu = a / b;
        int yu = a % b;
        System.out.println("加运算结果：" +jia);
        System.out.println("减运算结果：" +jian);
        System.out.println("乘运算结果：" +cheng);
        System.out.println("除运算结果：" +chu);
        System.out.println("求余运算结果：" +yu);
    }
}

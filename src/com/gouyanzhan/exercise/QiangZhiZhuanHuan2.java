package com.gouyanzhan.exercise;

public class QiangZhiZhuanHuan2 {
    public static void main(String[]args){
        int i1 = 128;
       printConversion1(i1);
        double d = 123.456;
       printConversion2(d);
    }

    /**
     * int强制类型转换为byte
     * @param a 传入int型参数
     */
    private static void printConversion1(int a){
        byte b =(byte)a;
        System.out.println("int强制类型转换byte后值等于" + b);
    }

    /**
     * double强制类型转换为int
     * @param a 传入double型参数
     */
    private static void printConversion2(double a){
        int i2 = (int)a;
        System.out.println("double强制类型转换int后值等于" + i2);
    }
}

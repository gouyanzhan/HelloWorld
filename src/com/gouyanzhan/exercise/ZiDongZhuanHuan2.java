package com.gouyanzhan.exercise;

public class ZiDongZhuanHuan2 {
    public static void main(String[] args){
        int l = 234234234;
       printAutomaticConversion(l);
    }

    /**
     * int型转换为float
     * @param a 传入一个int型参数
     */
    private static void printAutomaticConversion(int a){
        float d = a;
        System.out.println("int自动类型转换为float后的值等于"+ d);
    }
}

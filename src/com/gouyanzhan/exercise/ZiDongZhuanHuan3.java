package com.gouyanzhan.exercise;

public class ZiDongZhuanHuan3 {
    public static void main(String[]args){
        char i1 = 'a';
        char c2 = 'A';
        printAutomaticConversion(i1, c2);
    }

    /**
     * char类型转换为int型
     * @param a
     * @param b
     */
    private static void printAutomaticConversion(char a,char b){
        int i1= a;
        System.out.println("char自动类型转换为int后的值等于" + i1);
        int i2 =b + 1;
        System.out.println("char类型和int类型计算后的值等于" + i2);
    }
}

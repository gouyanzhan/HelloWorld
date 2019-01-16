package com.gouyanzhan.exercise;

public class QiangZhiZhuanHuan3 {
    public static void main(String[]args){
        char c1 = 'A';
        printConversion(c1);
    }

    public static void printConversion(char c1){
       int a = c1 + 1;
        char c2 =(char)a;
        System.out.println("int强制类型转换char后的值等于" + c2);
    }
}

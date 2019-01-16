package com.gouyanzhan.exercise;

public class QiangZhiZhuanHuan1 {
    public static void main(String[] args){
        int i1 = 123;
        printConversion(i1);
    }

    /**
     * int强制类型转换为byte
     * @param i 传入int型参数
     */
    private static void printConversion(int i){
        byte b =(byte)i;
        System.out.println("int强制类型转换byte后值等于" + b);
    }
}

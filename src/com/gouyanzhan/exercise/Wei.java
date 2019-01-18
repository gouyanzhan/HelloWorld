package com.gouyanzhan.exercise;

public class Wei {
    public static void main(String[] args) {
        int a = 6;
        int b = 3;
        printYuWei(a, b);
        //与（&）：如果对应位都是1，则结果为1，否则为0
        //或（|）：如果对应位都是0，则结果为0，否则为1
        //异或（^）：如果对应值相同，则结果为0，否则为1
        //非（～）：将操作数的每一位按位取反
    }

    /**
     * 执行与位运算
     * @param a 传入int型参数a
     * @param b 传入int型参数b
     */
    public static void printYuWei(int a, int b) {
        int i = a & b;
        System.out.println("执行与位运算符后的结果等于" + i);
    }
}

package com.gouyanzhan.exercise;

import org.junit.Test;

public class JinZhi {
    public static void main(String[] args) {
        //定义一个十进制数值
        int a10 = 12;
        //定义一个八进制数值
        int a8 = 012;
        int b = a8;
        System.out.println(b+"+"+a8);
        //定义一个以数字表示的十六进制整数
        int a16 = 0X12;
        //定义一个以字母表示的十六进制整数
        int b16 = 0xcafe;
        printDecimal(a10);
        printOctal(a8);
        printHexadecimal(a16);
        printHexadecimal(b16);
    }

    /**
     * 打印十进制
     * @param a
     */
    private static void printDecimal(int a) {
        System.out.println("十进制12等于" + a);
    }

    /**
     * 打印八进制
     * @param b
     */
    private static void printOctal(int b) {
        System.out.println("八进制12等于" + b);
    }

    /**
     * 打印十六进制
     * @param c
     */
    private static void printHexadecimal(int c) {
        System.out.println("十六进制数值等于" + c);
    }

    @Test
    public void testPrintDecimal() {
        int a10 = 12;
        printDecimal(a10);
    }

    @Test
    public void testPrintOctal() {
        int a8 = 012;
        printOctal(a8);
    }

    @Test
    public void testPrintHexadecimal() {
        int a16 = 0X12;
        int b16 = 0xcafe;
        printHexadecimal(a16);
        printHexadecimal(b16);
    }
}

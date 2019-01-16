package com.gouyanzhan.exercise;

import org.junit.Test;

public class SanYuan {
    public static void main(String[] args) {
        //声明一系列的int类型变量
        int i;
        i = 5;
        //使用三元运算符对k进行赋值操作
        printSanYuan(i);
        i = -5;
        printSanYuan(i);
    }

    public static void printSanYuan(int i) {
       int k = (i >= 0 ? i : -i);
        System.out.println("the absolute of "  + i  + " is " + k);
    }

    @Test
    public void testPrintSanYuan(){
        printSanYuan(5);
        printSanYuan(-5);
    }
}

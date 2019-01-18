package com.gouyanzhan.exercise;

import org.junit.Test;

/**
 * 逻辑运算分为与或非
 * & 长路与运算  && 短路与运算
 * | 长路或运算  || 短路或运算
 * ! 非运算
 */
public class LuoJi {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        printBoolVal(a,b);
        printBoolVal1(a,b);
    }

    private static Boolean printBoolVal(int a,int b){
        boolean b1 = (a > 4) && (b < 4);
        boolean b2 = (a < 4) || (b > 4);
        boolean b3 = !(a > 4);
        System.out.println("与" + b1);
        System.out.println("或" + b2);
        System.out.println("非" + b3);
        return true;
    }

    private static void printBoolVal1(int a, int b){
        boolean b1 = (a > 4) && (b < 4);
        boolean b2 = (a < 4) || (b > 4);
        boolean b3 = !(a > 4);
        System.out.println("与" + b1);
        System.out.println("或" + b2);
        System.out.println("非" + b3);
    }

    @Test
    public void testPrintBoolVal(){
        int a1 = 5;
        int b1 = 3;
        printBoolVal(a1,b1);
        System.out.println("----------------");
        int a2 = 3;
        int b2 = 5;
        printBoolVal(a2,b2);

    }
}

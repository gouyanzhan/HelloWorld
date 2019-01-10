package com.gouyanzhan.exercise;

import org.junit.Test;

public class LuoJi2 {
    public static void main(String[] args) {
        //int a = 5;
      //  boolean b = (a < 4) && (a++ < 10);
        printLojic(5);
    }

    private static void printLojic(int a) {
        boolean boolVal;
        boolVal = (a < 4) && (a++ < 10);
        System.out.println("使用短路逻辑运算符的结果为" + boolVal);
        System.out.println("a的结果为" + a);
    }

    @Test
    public void testPrintLojic(){
        int a = 5;
       printLojic(a);
    }
}

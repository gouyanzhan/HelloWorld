package com.gouyanzhan.exercise;

import org.junit.Test;

public class GuanXi1 {
    public static void main(String[]args){
        //定义一个int类型的变量
        int i = 5;
        //定义一个double类型的变量
        double d = 5.0;
        //运用关系运算符的结果
        boolean b1 =(i==d);
        System.out.println("b1的结果为：" + b1);
        printBoolForIntAndDouble(i, d);
        b1 = getBoolForIntAndDouble(i,d);
        System.out.println("b1的结果为：" + b1);
        //定义一个char类型变量
        char c = 'a';
        //定义一个long类型变量
        long l =97L;
        //运用关系运算符的结果
        boolean b2 =(c==l);
        System.out.println("b2的结果为：" + b2);
        //定义一个boolean类型变量
        boolean bl1 = true;
        //定义一个boolean类型变量
        boolean bl2 = false;
        //运用关系运算符的结果
        boolean b3 =(bl1 == bl2);
        System.out.println("b3的结果为：" + b3);
    }

    public static void printBoolForIntAndDouble(int intVal, double doubleVal) {
      boolean boolVal;
      boolVal = (intVal == doubleVal);
      System.out.println("printBoolForIntAndDouble:"+boolVal);
    }
    public static boolean getBoolForIntAndDouble(int intVal, double doubleVal) {
        boolean boolVal;
        boolVal = (intVal == doubleVal);
        return boolVal;
    }
    int i4;
    @Test
    public void testPrintBoolForIntAndDouble(){
       int i = 5;
       double d = 5.0;
       printBoolForIntAndDouble(i,d);
       int i1 = 3;
       double d1 = 5.0;
       printBoolForIntAndDouble(i1,d1);
       int i2 = 5;
       double d2 = 3.0;
       printBoolForIntAndDouble(i2,d2);
       //Integer i3 = null;
       //Double d3 = null;
       //printBoolForIntAndDouble(i3,d3);

       double d4 = 0;
        printBoolForIntAndDouble(i4,d4);
    }

    @Test
    public void testGetBoolForIntAndDouble(){
        int i = 5;
        double d = 5;
        boolean b = getBoolForIntAndDouble(i,d);
        System.out.println(b);
    }
}

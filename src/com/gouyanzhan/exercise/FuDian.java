package com.gouyanzhan.exercise;

import org.junit.Test;

public class FuDian {
    public static void main(String[]args){
        //float f = 1.23f;
        //printF(f);
        //double d1 = 1.23;
        //printDouble(d1);
        //double d2 = 1.23D;
        //printDouble(d2);

    }

    /**
     * 打印单精度浮点类型数值
     * @param f
     */
    public static void printF(float f){
        System.out.println("单精度浮点类型数值等于"+ f);
    }

    /**
     * 打印双精度浮点类型数值
     * @param d
     */
    public static void printDouble(double d){
        System.out.println("双精度浮点类型数值等于"+ d);
    }

    @Test
    public void testPrintF(){
        float f = 1.23f;
        printF(f);
    }

    @Test
    public void testPrintDouble1(){
        double d1 = 1.23;
        printDouble(d1);
    }

    @Test
    public void testPrintDouble2(){
        double d2 = 1.23D;
        printDouble(d2);
    }
}

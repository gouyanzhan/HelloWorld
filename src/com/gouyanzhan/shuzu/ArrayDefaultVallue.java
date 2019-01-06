package com.gouyanzhan.shuzu;

public class ArrayDefaultVallue {
    public static void main(String[] args) {
        //创建一个byte类型的数组
        byte[] byteArray = new byte[1];
        //创建一个char类型的数组
        char[] charArray = new char[1];
        //创建一个long类型的数组
        long[] longArray = new long[1];
        //创建一个float类型的数组
        float[] floatArray = new float[1];
        //创建一个double类型的数组
        double[] doubleArray = new double[1];
        String [] stringArray = new String[1];
        System.out.println("byte="+byteArray[0]); //打印出各个数组的默认初始值
        System.out.println("char="+charArray[0]);
        System.out.println("long="+longArray[0]);
        System.out.println("float="+floatArray[0]);
        System.out.println("double="+doubleArray[0]);


    }
}

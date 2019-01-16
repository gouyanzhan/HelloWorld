package com.gouyanzhan.exercise;

public class YuanMianJi {
    public static void main(String[] args) {
        //定义一个表示半径的变量
        int R = 5;
        printArea(R);
    }

    /**
     * 计算圆面积
     * @param a 传入一个int型参数，作圆的半径
     */
    private static void printArea(int a) {
        //定义一个表示p1的常量
        final double p1 = 3.14;
        //计算圆的面积
        double YMJ = p1 * a * a;
        System.out.println("圆的面积" + "=" + YMJ);
    }

}

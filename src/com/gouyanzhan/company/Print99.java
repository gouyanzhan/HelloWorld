package com.gouyanzhan.company;

import org.junit.Test;

public class Print99 {
    public static void main(String[] args) {
        int a = 6;
        int b = 7;
        printMultiplyTable(a, b);
    }

    /**
     * 打印 a * b 的乘法表
     *
     * @param a int型数值1
     * @param b int型数值2
     */
    public static void printMultiplyTable(int a, int b) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a <= 0 || b <= 0) {
            System.out.println("不能输入非正数");
            return;
        }
        System.out.print("                       " + a + " * " + b + " 乘 法 表 \n");
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (i >= j) {
                    // 打印结果
                    String str = i + " * " + j + " = " + (i * j) + "  ";
                    System.out.printf("%7s", str);
                }
            }
            // 换行
            System.out.println();
        }
    }

    @Test
    public void testPrintMultiplyTable1() {
        printMultiplyTable(8, 9);
    }

    @Test
    public void testPrintMultiplyTable2() {
        printMultiplyTable(0, 9);
    }

    @Test
    public void testPrintMultiplyTable3() {
        printMultiplyTable(-1, 9);
    }

}



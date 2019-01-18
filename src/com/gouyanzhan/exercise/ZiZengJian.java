package com.gouyanzhan.exercise;

import org.junit.Test;

public class ZiZengJian {
    public static void main(String[] args) {
        //定义一个byte类型的变量
        byte b1 = 5;
        printAutomaticOperation1(b1, true);
        printAutomaticOperation1(b1, false);
        //定义一个byte类型的变量
        //byte b3 = 5;
        // 定义两个值相同的变量
        int a = 5;
        int b = 5;
        printAutomaticOperation2(a, b);
    }

    /**
     * 传入一个参数，并对它做+1操作
     *
     * @param a    传入的参数
     * @param flag 标识符，当为true，使用传统的+1方式；当为false，使用自增+1方式
     */
    private static void printAutomaticOperation1(byte a, boolean flag) {
        if (flag) {
            //进行强制类型转换
            byte b = (byte) (a + 1);
            System.out.println(a + " 使用加运算符的结果是 " + b);
        } else {
            //进行自增运算，不需要强制转换
            byte b = ++a;
            System.out.println(a + " 使用自增运算符的结果是 " + b);
        }
    }

    private static void printAutomaticOperation2(int a, int b) {
        int x = 2 * ++a;
        int y = 2 * b++;
        System.out.println("自增运算符前缀运算后 a = " + a + " 表达式 x = " + x);
        System.out.println("自增运算符后缀运算后 b = " + b + " 表达式 y = " + y);
    }

    @Test
    public void testPrintAutomaticOperation1(){
        byte b1 = 5;
        printAutomaticOperation1(b1, true);
        printAutomaticOperation1(b1, false);
    }

    @Test
    public void testPrintAutomaticOperation2(){
        int a = 5;
        int b = 5;
        printAutomaticOperation2(a, b);
    }

}

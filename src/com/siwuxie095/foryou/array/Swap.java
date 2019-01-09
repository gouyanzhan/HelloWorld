package com.siwuxie095.foryou.array;

import java.lang.reflect.Field;

/**
 * 交换
 */
public class Swap {

    public static void main(String[] args) throws Exception {
        Integer a = 1;
        Integer b = 2;
        System.out.println("交换前：");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        swapByValuePassing(a, b);
        System.out.println("以值传递的方式交换：");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        swapByReflecting(a, b);
        System.out.println("以反射的方式交换：");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    /**
     * 值传递
     */
    private static void swapByValuePassing(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }

    /**
     * 反射
     */
    private static void swapByReflecting(Integer a, Integer b) throws Exception {
        Field value = Integer.class.getDeclaredField("value");
        value.setAccessible(true);

        int temp;
        temp = a.intValue();
        value.set(a, b.intValue());
        value.set(b, new Integer(temp));
    }

}

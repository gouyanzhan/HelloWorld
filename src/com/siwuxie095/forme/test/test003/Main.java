package com.siwuxie095.forme.test.test003;

import java.util.Date;

/**
 * @author Jiajing Li
 * @date 2019-01-17 10:38:11
 */
public class Main {

    /**
     * 说明的问题：
     *
     * 1、声明为 final 时的 String，在有占位符存在时，还是随着占位符的被替换而改变；
     *
     * 2、声明为 final 时的 Date，在程序运行的一瞬间就固定了，不会再发生改变；
     */

    private static final String STRING = "Hello World - %s";

    private static final Date DATE = new Date();

    public static void main(String[] args) {
        testFinalString();
        System.out.println();
        testFinalDate();
    }

    private static void testFinalString() {
        System.out.println(STRING);
        for (int i = 0; i < 10; ++i) {
            System.out.println(String.format(STRING, i));
        }
    }

    private static void testFinalDate() {
        for (int i = 0; i < 10; ++i) {
            System.out.println(DATE);
        }
    }

}

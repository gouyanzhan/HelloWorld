package com.siwuxie095.test;

/**
 * @author Jiajing Li <lijiajing@yit.com>
 * @date 2019-01-07 12:59:28
 */
public class BaseTest {
    public static void testStatic() {
        System.out.println("父");
    }

    void print() {
        System.out.println("print");
    }

    private void testPrivate() {
        System.out.println("testPrivate");
    }
}

package com.siwuxie095.test;

/**
 * 主类
 */
public class Main {
    public static void main(String[] args) {
        SubTest.testStatic();
        BaseTest.testStatic();
        SubTest subTest = new SubTest();
        subTest.testStatic();

        BaseTest baseTest = new SubTest();
        baseTest.testStatic();
        SubTest subTest1 = (SubTest) baseTest;
        subTest1.testStatic();
    }
}

package com.siwuxie095.forme.test.test001;


/**
 * 派生类 用于测试
 *
 * @author Jiajing Li
 * @date 2019-01-07 13:00:44
 */
public class SubTest extends BaseTest {

    public static void testStatic() {
        System.out.println("子");
    }

    @Override
    void print() {
        System.out.println("");
    }

    void testPrivate() {}
}

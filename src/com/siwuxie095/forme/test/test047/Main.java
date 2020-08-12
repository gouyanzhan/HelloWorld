package com.siwuxie095.forme.test.test047;

/**
 * @author Jiajing Li
 * @date 2020-08-12 16:09:38
 */
public class Main {
    /**
     * 说明的问题：
     * 1、同线程同类中 static 的 ThreadLocal 变量，在该类的不同对象中是公有的。
     * 也就是说是全局共享的。
     *
     * 注意：和 test045 进行区分
     */
    public static void main(String[] args) {
        ThreadLocalWrapper wrapper1 = new ThreadLocalWrapper();
        System.out.println(wrapper1.str.get());
        ThreadLocalWrapper wrapper2 = new ThreadLocalWrapper();
        wrapper2.str.set("222");
        System.out.println(wrapper1.str.get());
        wrapper1.str.set("11111");
        System.out.println(wrapper2.str.get());
        System.out.println(wrapper1.str.get());
    }

}

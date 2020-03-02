package com.siwuxie095.forme.test.test016;

/**
 * @author Jiajing Li
 * @date 2019-11-21 18:29:10
 */
public class Main {

    /**
     * 说明的问题：
     * 1、静态代码块的加载顺序，以及在继承中，构造函数的加载顺序。
     */
    public static void main(String[] args) {
        A a = new B();
        System.out.println();
        a = new B();
        System.out.println();
        A aa = new A();
    }

}

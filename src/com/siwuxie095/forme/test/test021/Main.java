package com.siwuxie095.forme.test.test021;

/**
 * @author Jiajing Li
 * @date 2020-03-02 15:50:25
 */
public class Main {
    /**
     * 说明的问题：
     * 1、Name、SimpleName、CanonicalName 的区别。
     */
    public static void main(String[] args) {
        System.out.println(Main.class.getName());
        System.out.println(Main.class.getSimpleName());
        System.out.println(Main.class.getCanonicalName());
    }

}

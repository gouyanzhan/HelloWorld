package com.siwuxie095.forme.test.test029;

/**
 * @author Jiajing Li
 * @date 2020-04-15 15:47:00
 */
public class Main {

    /**
     * 说明的问题：
     * 1、直接打印变长参数，无法得到其中每一个具体的值，只会得到一个地址。
     */
    public static void main(String[] args) {
        print("A", "2", "3L", "ersf");
    }

    private static void print(String... msg) {
        System.out.println(msg);
    }


}

package com.siwuxie095.forme.test.test024;

/**
 * @author Jiajing Li
 * @date 2020-03-25 16:20:24
 */
public class Main {

    /**
     * 说明的问题：
     * 1、数字字母混合下的 toLowerCase 和 toUpperCase，并不影响非字母部分。
     */
    public static void main(String[] args) {
        String str = "Abc123";
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
    }

}

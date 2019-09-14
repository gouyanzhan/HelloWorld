package com.siwuxie095.forme.test.test014;

/**
 * @author Jiajing Li
 * @date 2019-07-30 22:59:14
 */
public class Main {

    /**
     * 说明的问题：
     *
     * 1、点号在分隔时需要转义；
     */
    public static void main(String[] args) {
        String str = "3.14";

        System.out.println(str.split("\\.")[0]);
        System.out.println(str.split("\\.")[1]);
        /*
         * 会报错
         */
        System.out.println(str.split(".")[0]);
        System.out.println(str.split(".")[1]);
    }

}

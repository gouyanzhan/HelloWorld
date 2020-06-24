package com.siwuxie095.forme.test.test042;

/**
 * @author Jiajing Li
 * @date 2020-06-24 10:28:19
 */
public class Main {

    /**
     * 说明的问题：
     * 1、Error 和 Checked Exception 不同，在编译期可顺利编译，不用检查。
     */
    public static void main(String[] args) {
        //throw new Error();
        throw new OutOfMemoryError();
    }

}

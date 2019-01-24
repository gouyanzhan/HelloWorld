package com.siwuxie095.foryou.clazz;

/**
 * @author Jiajing Li
 * @date 2019-01-21 22:43:26
 */
public class OverloadTest {

    public static void main(String[] args) {
        Overload overload = new Overload();
        overload.testOverload();
        overload.testOverload(1);
        overload.testOverload(2D);
        overload.testOverload("咦");
    }

}

package com.siwuxie095.forme.test.test025;

import java.math.BigDecimal;

/**
 * @author Jiajing Li
 * @date 2020-03-30 16:32:24
 */
public class Main {

    /**
     * 说明的问题：
     * 1、BigDecimal 在做 toString 时，小数位的个数。
     */
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(10);
        System.out.println(a.toString());
        BigDecimal b = new BigDecimal(10.0);
        System.out.println(b.toString());
        BigDecimal c = new BigDecimal(10.00);
        System.out.println(c.toString());
        BigDecimal d = BigDecimal.valueOf(10.000);
        System.out.println(d.toString());
        BigDecimal e = new BigDecimal("10.0000");
        System.out.println(e.toString());
        String abc = "abcde";
        System.out.println(abc.substring(3));
    }

}

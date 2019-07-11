package com.siwuxie095.forme.algorithm.chapter9th.question2nd.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-13 22:26:22
 */
public class GCD {

    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }

}

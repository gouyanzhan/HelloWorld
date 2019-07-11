package com.siwuxie095.forme.algorithm.chapter9th.question12th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-30 21:33:57
 */
public class Rand {

    public static double randXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    public static double randXPowerK(int k) {
        if (k < 1) {
            return 0;
        }
        double res = -1;
        for (int i = 0; i != k; i++) {
            res = Math.max(res, Math.random());
        }
        return res;
    }

}

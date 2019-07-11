package com.siwuxie095.forme.algorithm.chapter9th.question3rd.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-15 17:02:03
 */
public class Factorial {

    //region 原问题

    public static int zeroNum1(int num) {
        if (num < 0) {
            return 0;
        }
        int res = 0;
        int cur = 0;
        for (int i = 5; i < num + 1; i = i + 5) {
            cur = i;
            while (cur % 5 == 0) {
                res++;
                cur /= 5;
            }
        }
        return res;
    }

    public static int zeroNum2(int num) {
        if (num < 0) {
            return 0;
        }
        int res = 0;
        while (num != 0) {
            res += num / 5;
            num /= 5;
        }
        return res;
    }

    //endregion


    //region 进阶问题

    public static int rightOne1(int num) {
        if (num < 1) {
            return -1;
        }
        int res = 0;
        while (num != 0) {
            num >>>= 1;
            res += num;
        }
        return res;
    }

    public static int rightOne2(int num) {
        if (num < 1) {
            return -1;
        }
        int ones = 0;
        int tmp = num;
        while (tmp != 0) {
            ones += (tmp & 1) != 0 ? 1 : 0;
            tmp >>>= 1;
        }
        return num - ones;
    }

    //endregion

}

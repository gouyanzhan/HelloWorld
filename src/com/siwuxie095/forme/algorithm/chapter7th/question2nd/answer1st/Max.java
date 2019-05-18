package com.siwuxie095.forme.algorithm.chapter7th.question2nd.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-18 13:36:42
 */
public class Max {

    //region 法一

    public static int getMax1(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    private static int flip(int n) {
        return n ^ 1;
    }

    private static int sign(int n) {
        return flip((n >> 31) & 1);
    }
    //endregion


    //region 法二

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int diffSab = sa ^ sb;
        int sameSab = flip(diffSab);
        int returnA = diffSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }
    //endregion



}

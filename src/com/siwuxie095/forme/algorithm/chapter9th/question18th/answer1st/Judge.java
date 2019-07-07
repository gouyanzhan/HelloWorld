package com.siwuxie095.forme.algorithm.chapter9th.question18th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-07-07 21:05:01
 */
public class Judge {

    public static boolean isPalindrome(int n) {
        if (n == Integer.MIN_VALUE) {
            return false;
        }
        n = Math.abs(n);
        int help = 1;
        // 防止 help 溢出
        while (n / help >= 10) {
            help *= 10;
        }
        while (n != 0) {
            if (n / help != n % 10) {
                return false;
            }
            n = (n % help) / 10;
            help /= 100;
        }
        return true;
    }

}

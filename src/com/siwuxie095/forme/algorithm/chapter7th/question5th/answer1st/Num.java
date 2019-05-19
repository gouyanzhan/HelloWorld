package com.siwuxie095.forme.algorithm.chapter7th.question5th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-19 14:10:21
 */
public class Num {

    public static void printOddTimesNum1(int[] arr) {
        int e0 = 0;
        for (int curr : arr) {
            e0 ^= curr;
        }
        System.out.println(e0);
    }


    public static void printOddTimesNum2(int[] arr) {
        int eO = 0;
        int eOHasOne = 0;
        for (int curr : arr) {
            eO ^= curr;
        }
        int rightOne = eO & (~eO + 1);
        for (int curr : arr) {
            if ((curr & rightOne) != 0) {
                eOHasOne ^= curr;
            }
        }
        System.out.println(eOHasOne + " " + (eO ^ eOHasOne));
    }

}

package com.siwuxie095.forme.algorithm.chapter8th.question22th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-11 10:29:59
 */
public class Product {

    public static int[] product1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return null;
        }
        int count = 0;
        int all = 1;
        for (int i = 0; i != arr.length; i++) {
            if (arr[i] != 0) {
                all *= arr[i];
            } else {
                count++;
            }
        }
        int[] res = new int[arr.length];
        if (count == 0) {
            for (int i = 0; i != arr.length; i++) {
                res[i] = all / arr[i];
            }
        }
        if (count == 1) {
            for (int i = 0; i != arr.length; i++) {
                if (arr[i] == 0) {
                    res[i] = all;
                }
            }
        }
        return res;
    }

    public static int[] product2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return null;
        }
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] * arr[i];
        }
        int tmp = 1;
        for (int i = arr.length - 1; i > 0; i--) {
            res[i] = res[i - 1] * tmp;
            tmp *= arr[i];
        }
        res[0] = tmp;
        return res;
    }

}

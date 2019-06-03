package com.siwuxie095.forme.algorithm.chapter8th.question14th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-03 20:37:24
 */
public class Sort {

    public static void sort1(int[] arr) {
        int tmp = 0;
        int next = 0;
        for (int i = 0; i != arr.length; i++) {
            tmp = arr[i];
            while (arr[i] != i + 1) {
                next = arr[tmp - 1];
                arr[tmp - 1] = tmp;
                tmp = next;
            }
        }
    }

    public static void sort2(int[] arr) {
        int tmp = 0;
        for (int i = 0; i != arr.length; i++) {
            while (arr[i] != i + 1) {
                tmp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = tmp;
            }
        }
    }

}

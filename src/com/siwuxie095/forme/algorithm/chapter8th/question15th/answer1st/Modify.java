package com.siwuxie095.forme.algorithm.chapter8th.question15th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-03 21:26:20
 */
public class Modify {

    public static void modify(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int even = 0;
        int odd = 1;
        int end = arr.length - 1;
        while (even <= end && odd <= end) {
            if ((arr[end] & 1) == 0) {
                swap(arr, end, even);
                even += 2;
            } else {
                swap(arr, end, odd);
                odd += 2;
            }
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}

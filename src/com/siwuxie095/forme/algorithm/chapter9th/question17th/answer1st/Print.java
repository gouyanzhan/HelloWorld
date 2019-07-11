package com.siwuxie095.forme.algorithm.chapter9th.question17th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-07-06 17:54:33
 */
public class Print {

    public static void printRandM(int[] arr, int m) {
        if (null == arr || arr.length == 0 || m < 0) {
            return;
        }
        m = Math.min(arr.length, m);
        int count = 0;
        int i = 0;
        while (count < m) {
            i = (int) (Math.random() * (arr.length - count));
            System.out.println(arr[i]);
            swap(arr, arr.length - count++ - 1, i);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}

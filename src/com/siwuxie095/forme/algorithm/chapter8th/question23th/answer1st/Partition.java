package com.siwuxie095.forme.algorithm.chapter8th.question23th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-11 21:06:02
 */
public class Partition {

    public static void leftUnique(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int u = 0;
        int i = 1;
        while (i != arr.length) {
            if (arr[i++] != arr[u]) {
                swap(arr, ++u, i - 1);
            }
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int left = -1;
        int index = 0;
        int right = arr.length;
        while (index < right) {
            if (arr[index] == 0) {
                swap(arr, ++left, index++);
            } else if (arr[index] == 2) {
                swap(arr, index, --right);
            } else {
                index++;
            }
        }
    }

}

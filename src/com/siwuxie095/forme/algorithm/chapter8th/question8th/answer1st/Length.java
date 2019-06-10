package com.siwuxie095.forme.algorithm.chapter8th.question8th.answer1st;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Jiajing Li
 * @date 2019-05-27 17:16:07
 */
public class Length {

    //region 法一

    public static int getLIL1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (isIntegrated(arr, i, j)) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    private static boolean isIntegrated(int[] arr, int left, int right) {
        // O(N)
        int[] newArr = Arrays.copyOfRange(arr, left, right + 1);
        // O(N*logN)
        Arrays.sort(newArr);
        for (int i = 1; i < newArr.length; i++) {
            if (newArr[i - 1] != newArr[i] - 1) {
                return false;
            }
        }
        return true;
    }
    //endregion


    //region 法二

    public static int getLIL2(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int len = 0;
        int max = 0;
        int min = 0;
        // 判断重复
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (max - min == j - 1) {
                    len = Math.max(len, j - i + 1);
                }
            }
            set.clear();
        }
        return len;
    }
    //endregion

}

package com.siwuxie095.forme.algorithm.chapter1st.question10th.answer2nd;

import java.util.Arrays;

/**
 * @author Jiajing Li
 * @date 2019-02-13 21:40:16
 */
public class Number {

    public static int getNum(int[] arr, int num) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int i = 0;
        int res = 0;
        while (i < arr.length) {
            int j = i;
            while (j < arr.length) {
                if (max(arr, i, j) - min(arr, i, j) <= num) {
                    res++;
                }
                j++;
            }
            i++;
        }
        return res;
    }

    /**
     * 参考链接：https://blog.csdn.net/a19990412/article/details/81296234
     */
    private static int max(int[] arr, int i, int j) {
        int[] temp = new int[j - i + 1];
        for (int k = 0; k < temp.length; k++) {
            temp[k] = arr[i + k];
        }
        return Arrays.stream(temp).max().getAsInt();
    }

    private static int min(int[] arr, int i, int j) {
        int[] temp = new int[j - i + 1];
        for (int k = 0; k < temp.length; k++) {
            temp[k] = arr[i + k];
        }
        return Arrays.stream(temp).min().getAsInt();
    }

}

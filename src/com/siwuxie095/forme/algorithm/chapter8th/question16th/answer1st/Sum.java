package com.siwuxie095.forme.algorithm.chapter8th.question16th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-04 21:32:39
 */
public class Sum {

    public static int maxSum(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i != arr.length; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

}

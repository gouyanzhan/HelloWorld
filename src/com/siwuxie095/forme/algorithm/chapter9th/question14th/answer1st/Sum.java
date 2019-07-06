package com.siwuxie095.forme.algorithm.chapter9th.question14th.answer1st;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Jiajing Li
 * @date 2019-07-06 11:07:25
 */
public class Sum {

    //region 原问题 解法一 暴力递归

    public static int unformedSum1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 1;
        }
        HashSet<Integer> set = new HashSet<>();
        // 收集所有子集的和
        process(arr, 0, 0, set);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i != arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        for (int i = min + 1; i != Integer.MIN_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    private static void process(int[] arr, int i, int sum, HashSet<Integer> set) {
        if (i == arr.length) {
            set.add(sum);
            return;
        }
        // 包含当前数 arr[i] 的情况
        process(arr, i + 1, sum, set);
        // 不包含当前数 arr[i] 的情况
        process(arr, i + 1, sum + arr[i], set);
    }

    //endregion

    //region 原问题 解法二 动态规划

    public static int unformedSum2(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 1;
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            min = Math.min(min, arr[i]);
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i != arr.length; i++) {
            for (int j = sum; j >= arr[i]; j--) {
                dp[j] = dp[j - arr[i]] ? true : dp[j];
            }
        }
        for (int i = min; i != dp.length; i++) {
            if (!dp[i]) {
                return i;
            }
        }
        return sum + 1;
    }

    //endregion

    //region 进阶问题

    public static int unformedSum3(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        // 把 arr 排序
        Arrays.sort(arr);
        int range = 0;
        for (int i = 0; i != arr.length; i++) {
            if (arr[i] > range + 1) {
                return range + 1;
            } else {
                range += arr[i];
            }
        }
        return range + 1;
    }

    //endregion
}

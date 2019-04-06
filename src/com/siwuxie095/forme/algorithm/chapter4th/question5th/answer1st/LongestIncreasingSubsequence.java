package com.siwuxie095.forme.algorithm.chapter4th.question5th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-06 11:16:13
 */
public class LongestIncreasingSubsequence {

    //region O(N^2) 的方法

    public static int[] getLIS1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }
        int[] dp = getDp1(arr);
        return generateLIS(arr, dp);
    }

    private static int[] getDp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }
    //endregion


    //region O(N * logN) 的方法

    public static int[] getLIS2(int[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }
        int[] dp = getDp2(arr);
        return generateLIS(arr, dp);
    }

    private static int[] getDp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < arr.length; ++i) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }
    //endregion

    private static int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; ++i) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for (int i = index; i >= 0; --i) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }



}

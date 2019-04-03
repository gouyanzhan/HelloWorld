package com.siwuxie095.forme.algorithm.chapter4th.question3rd.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-02 21:40:09
 */
public class Coin {

    //region 原问题

    public static int minCoins1(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; ++j) {
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= aim; ++j) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                   left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }


    public static int minCoins2(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        for (int j = 1; j <= aim; ++j) {
            dp[j] = max;
            if (j - arr[0] >= 0 && dp[j - arr[0]] != max) {
                dp[j] = dp[j - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= aim; ++j) {
                left = max;
                if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
                    left = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        return dp[aim] != max ? dp[aim] : -1;
    }
    //endregion


    //region 补充问题

    public static int minCoins3(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; ++j) {
            dp[0][j] = max;
        }
        if (arr[0] <= aim) {
            dp[0][arr[0]] = 1;
        }
        // 左上角某个位置的值
        int leftUp = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= aim; ++j) {
                leftUp = max;
                if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
                    leftUp = dp[i - 1][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(leftUp, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }


    public static int minCoins4(int[] arr, int aim) {
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        for (int j = 1; j <= aim; ++j) {
            dp[j] = max;
        }
        if (arr[0] < aim) {
            dp[arr[0]] = 1;
        }
        // 左上角某个位置的值
        int leftUp = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = aim; j > 0; --j) {
                leftUp = max;
                if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
                    leftUp = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.min(leftUp, dp[j]);
            }
        }
        return dp[aim] != max ? dp[aim] : -1;
    }
    //endregion

}

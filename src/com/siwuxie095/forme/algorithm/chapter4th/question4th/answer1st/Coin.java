package com.siwuxie095.forme.algorithm.chapter4th.question4th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-03 18:33:59
 */
public class Coin {

    /**
     * 暴力递归的方法
     */
    public static int coins1(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    private static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = (aim == 0) ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; ++i) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    /**
     * 记忆搜索的方法
     */
    public static int coins2(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);
    }

    private static int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = (aim == 0) ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; arr[index] * i <= aim; ++i) {
                mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
                    res += (mapValue == -1) ? 0 : mapValue;
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        map[index][aim] = (res == 0) ? -1 : res;
        return res;
    }

    /**
     * 动态规划的方法 A
     */
    public static int coins3(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; ++j) {
            dp[0][arr[0] * j] = 1;
        }
        int num = 0;
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 1; j <= aim; ++j) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; ++k) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }

    /**
     * 动态规划的方法 B
     */
    public static int coins4(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; ++j) {
            dp[0][arr[0] * j] = 1;
        }
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 1; j <= aim; ++j) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += (j - arr[i] >= 0) ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }

    /**
     * 动态规划的方法 B + 空间压缩
     */
    public static int coins5(int[] arr, int aim) {
        if (null == arr || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[] dp = new int[aim + 1];
        for (int j = 0; arr[0] * j <= aim; ++j) {
            dp[arr[0] * j] = 1;
        }
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 1; j <= aim; ++j) {
                dp[j] += (j - arr[i] >= 0) ? dp[j - arr[i]] : 0;
            }
        }
        return dp[aim];
    }

}

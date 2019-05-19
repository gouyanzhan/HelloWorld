package com.siwuxie095.forme.algorithm.chapter4th.question9th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-06 22:59:31
 */
public class Cost {

    /**
     * 经典动态规划方法
     */
    public static int minCost1(String str1, String str2, int ic, int dc, int rc) {
        if (null == str1 || null == str2) {
            return 0;
        }
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int row = charArr1.length + 1;
        int col = charArr2.length + 1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; ++i) {
            dp[i][0] = dc * i;
        }
        for (int j = 1; j < col; ++j) {
            dp[0][j] = ic * j;
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                if (charArr1[i - 1] == charArr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }
        }
        return dp[row - 1][col - 1];
    }

    /**
     * 经典动态规划方法 + 空间压缩
     */
    public static int minCost2(String str1, String str2, int ic, int dc, int rc) {
        if (null == str1 || null == str2) {
            return 0;
        }
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        char[] longerArr = (charArr1.length >= charArr2.length) ? charArr1 : charArr2;
        char[] shorterArr = (charArr1.length < charArr2.length) ? charArr1 : charArr2;
        // str2 较长就交换 ic 和 dc 的值
        if (charArr1.length < charArr2.length) {
            int tmp = ic;
            ic = dc;
            dc = tmp;
        }
        int[] dp = new int[shorterArr.length + 1];
        for (int i = 1; i <= shorterArr.length; ++i) {
            dp[i] = ic * i;
        }
        for (int i = 1; i <= longerArr.length; ++i) {
            // pre 表示左上角的值
            int pre = dp[0];
            dp[0] = dc * i;
            for (int j = 1; j <= shorterArr.length; ++j) {
                // dp[j] 没更新前先保存下来
                int tmp = dp[j];
                if (longerArr[i - 1] == shorterArr[j - 1]) {
                    dp[j] = pre;
                } else {
                    dp[j] = pre + rc;
                }
                dp[j] = Math.min(dp[j], dp[j - 1] + ic);
                dp[j] = Math.min(dp[j], tmp + dc);
                // pre 变成 dp[j] 没更新前的值
                pre = tmp;
            }
        }
        return dp[shorterArr.length];
    }

}

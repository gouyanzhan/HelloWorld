package com.siwuxie095.forme.algorithm.chapter4th.question2nd.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-01 21:31:43
 */
public class Path {

    /**
     * dp 即 Dynamic Programming，动态规划
     */
    public static int minPathSum(int[][] m) {
        if (null == m || m.length == 0 || null == m[0] || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; ++i) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; ++j) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

}

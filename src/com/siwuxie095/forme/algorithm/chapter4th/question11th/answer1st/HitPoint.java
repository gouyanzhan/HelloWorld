package com.siwuxie095.forme.algorithm.chapter4th.question11th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-07 20:23:20
 */
public class HitPoint {

    /**
     * 经典动态规划方法
     */
    public static int minHP1(int[][] m) {
        if (null == m || m.length == 0 || null == m[0] || m[0].length == 0) {
            return 1;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row--][col--];
        dp[row][col] = (m[row][col] > 0) ? 1 : -m[row][col] + 1;
        for (int j = col - 1; j >= 0; --j) {
            dp[row][j] = Math.max(dp[row][j + 1] - m[row][j], 1);
        }
        int right = 0;
        int down  = 0;
        for (int i = row - 1; i >= 0; --i) {
            dp[i][col] = Math.max(dp[i + 1][col] - m[i][col], 1);
            for (int j = col - 1; j >= 0; --j) {
                right = Math.max(dp[i][j + 1] - m[i][j], 1);
                down  = Math.max(dp[i + 1][j] - m[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[0][0];
    }

    /**
     * 经典动态规划方法 + 空间压缩
     */
    public static int minHP2(int[][] m) {
        if (null == m || m.length == 0 || null == m[0] || m[0].length == 0) {
            return 1;
        }
        int more = Math.max(m.length, m[0].length);
        int less = Math.min(m.length, m[0].length);
        boolean rowMore = (more == m.length);
        int[] dp = new int[less];
        int tmp = m[m.length - 1][m[0].length - 1];
        dp[less - 1] = tmp > 0 ? 1 : -tmp + 1;
        int row = 0;
        int col = 0;
        for (int j = less - 2; j >= 0; --j) {
            row = rowMore ? more - 1 : j;
            col = rowMore ? j : more - 1;
            dp[j] = Math.max(dp[j + 1] - m[row][col], 1);
        }
        int choosen1 = 0;
        int choosen2 = 0;
        for (int i = more - 2; i >= 0; --i) {
            row = rowMore ? i : less - 1;
            col = rowMore ? less - 1 : i;
            dp[less - 1] = Math.max(dp[less - 1] - m[row][col], 1);
            for (int j = less - 2; j >= 0; --j) {
                row = rowMore ? i : j;
                col = rowMore ? j : i;
                choosen1 = Math.max(dp[j] - m[row][col], 1);
                choosen2 = Math.max(dp[j + 1] - m[row][col], 1);
                dp[j] = Math.min(choosen1, choosen2);
            }
        }
        return dp[0];
    }

}

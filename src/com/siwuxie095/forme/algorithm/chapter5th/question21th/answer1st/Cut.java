package com.siwuxie095.forme.algorithm.chapter5th.question21th.answer1st;

/**
 *
 * @author Jiajing Li
 * @date 2019-05-14 11:02:20
 */
public class Cut {

    public static int minCut(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        int[] dp = new int[len + 1];
        dp[len] = -1;
        boolean[][] p = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (charArr[i] == charArr[j] && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

}

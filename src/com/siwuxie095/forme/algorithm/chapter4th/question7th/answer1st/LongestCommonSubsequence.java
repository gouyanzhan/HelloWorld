package com.siwuxie095.forme.algorithm.chapter4th.question7th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-06 19:20:22
 */
public class LongestCommonSubsequence {

    public static String getLCS(String str1, String str2) {
        if (null == str1 || null == str2 || "".equals(str1) || "".equals(str2)) {
            return "";
        }
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int[][] dp = getDp(charArr1, charArr2);
        int m = charArr1.length - 1;
        int n = charArr2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = charArr1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

    private static int[][] getDp(char[] charArr1, char[] charArr2) {
        int[][] dp = new int[charArr1.length][charArr2.length];
        dp[0][0] = (charArr1[0] == charArr2[0]) ? 1 : 0;
        for (int i = 1; i < charArr1.length; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], (charArr1[i] == charArr2[0] ? 1 : 0));
        }
        for (int j = 1; j < charArr2.length; ++j) {
            dp[0][j] = Math.max(dp[0][j - 1], (charArr1[0] == charArr2[j]) ? 1 : 0);
        }
        for (int i = 1; i < charArr1.length; ++i) {
            for (int j = 1; j < charArr2.length; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (charArr1[i] == charArr2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }

}

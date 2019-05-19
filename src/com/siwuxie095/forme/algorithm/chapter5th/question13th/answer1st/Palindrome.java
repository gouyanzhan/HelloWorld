package com.siwuxie095.forme.algorithm.chapter5th.question13th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-22 21:52:54
 */
public class Palindrome {

    public static String getPalindrome(String str) {
        if (null == str || str.length() < 2) {
            return str;
        }
        char[] charArr = str.toCharArray();
        int[][] dp = getDP(charArr);
        char[] res = new char[charArr.length + dp[0][charArr.length - 1]];
        int i = 0;
        int j = charArr.length - 1;
        int resl = 0;
        int resr = res.length - 1;
        while (i <= j) {
            if (charArr[i] == charArr[j]) {
                res[resl++] = charArr[i++];
                res[resr--] = charArr[j--];
            } else if (dp[i][j - 1] < dp[i + 1][j]) {
                res[resl++] = charArr[j];
                res[resr--] = charArr[j--];
            } else {
                res[resl++] = charArr[i];
                res[resr--] = charArr[i++];
            }
        }
        return String.valueOf(res);
    }


    private static int[][] getDP(char[] charArr) {
        int[][] dp = new int[charArr.length][charArr.length];
        for (int j = 1; j < charArr.length; ++j) {
            dp[j - 1][j] = (charArr[j - 1] == charArr[j]) ? 0 : 1;
            for (int i = j - 2; i > -1; --i) {
                if (charArr[i] == charArr[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp;
    }

}

package com.siwuxie095.forme.algorithm.chapter4th.question10th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-07 10:50:39
 */
public class Cross {

    /**
     * 经典动态规划方法
     */
    public static boolean isCross1(String str1, String str2, String aim) {
        if (null == str1 || null == str2 || null == aim) {
            return false;
        }
        char[] strCharArr1 = str1.toCharArray();
        char[] strCharArr2 = str2.toCharArray();
        char[] aimCharArr  = aim.toCharArray();
        if (aimCharArr.length != strCharArr1.length + strCharArr2.length) {
            return false;
        }
        boolean[][] dp = new boolean[strCharArr1.length + 1][strCharArr2.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= strCharArr1.length; ++i) {
            if (strCharArr1[i - 1] != aimCharArr[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 1; j <= strCharArr2.length; ++j) {
            if (strCharArr2[j - 1] != aimCharArr[j - 1]) {
                break;
            }
            dp[0][j] = true;
        }
        for (int i = 1; i <= strCharArr1.length; ++i) {
            for (int j = 1; j <= strCharArr2.length; ++j) {
                if ((strCharArr1[i - 1] == aimCharArr[i + j - 1] && dp[i - 1][j])
                || (strCharArr2[j - 1] == aimCharArr[i + j - 1] && dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[strCharArr1.length][strCharArr2.length];
    }

    /**
     * 经典动态规划方法 + 空间压缩
     */
    public static boolean isCross2(String str1, String str2, String aim) {
        if (null == str1 || null == str2 || null == aim) {
            return false;
        }
        char[] strCharArr1 = str1.toCharArray();
        char[] strCharArr2 = str2.toCharArray();
        char[] aimCharArr  = aim.toCharArray();
        if (aimCharArr.length != strCharArr1.length + strCharArr2.length) {
            return false;
        }
        char[] longerArr  = (strCharArr1.length >= strCharArr2.length) ? strCharArr1 : strCharArr2;
        char[] shorterArr = (strCharArr1.length < strCharArr2.length) ? strCharArr1 : strCharArr2;
        boolean[] dp = new boolean[shorterArr.length + 1];
        dp[0] = true;
        for (int i = 1; i <= shorterArr.length; ++i) {
            if (shorterArr[i - 1] != aimCharArr[i - 1]) {
                break;
            }
            dp[i] = true;
        }
        for (int i = 1; i <= longerArr.length; ++i) {
            dp[0] = dp[0] && longerArr[i - 1] == aimCharArr[i - 1];
            for (int j = 1; j <= shorterArr.length; ++j) {
                if ((longerArr[i - 1] == aimCharArr[i + j - 1] && dp[j])
                || (shorterArr[j - 1] == aimCharArr[i + j - 1] && dp[j - 1])) {
                    dp[j] = true;
                } else {
                    dp[j] = false;
                }
            }
        }
        return dp[shorterArr.length];
    }

}

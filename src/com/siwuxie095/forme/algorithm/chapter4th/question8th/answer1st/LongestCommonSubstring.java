package com.siwuxie095.forme.algorithm.chapter4th.question8th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-06 20:57:20
 */
public class LongestCommonSubstring {

    //region 经典动态规划方法

    public static String getLCS1(String str1, String str2) {
        if (null == str1 || null == str2 || "".equals(str1) || "".equals(str2)) {
            return "";
        }
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int[][] dp = getDp(charArr1, charArr2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < charArr1.length; ++i) {
            for (int j = 0; j < charArr2.length; ++j) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    private static int[][] getDp(char[] charArr1, char[] charArr2) {
        int[][] dp = new int[charArr1.length][charArr2.length];
        for (int i = 0; i < charArr1.length; ++i) {
            if (charArr1[i] == charArr2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < charArr2.length; ++j) {
            if (charArr1[0] == charArr2[j]) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < charArr1.length; ++i) {
            for (int j = 1; j < charArr2.length; ++j) {
                if (charArr1[i] == charArr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }
    //endregion


    //region 经典动态规划方法 + 空间压缩

    public static String getLCS2(String str1, String str2) {
        if (null == str1 || null == str2 || "".equals(str1) || "".equals(str2)) {
            return "";
        }
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        // 斜线开始位置的行
        int row = 0;
        // 斜线开始位置的列
        int col = charArr2.length - 1;
        // 记录最大长度
        int max = 0;
        // 最大长度更新时，记录子串的结尾位置
        int end = 0;
        while (row < charArr1.length) {
            int i = row;
            int j = col;
            int len = 0;
            // 从 (i, j) 开始向右下方遍历
            while (i < charArr1.length && j < charArr2.length) {
                if (charArr1[i] != charArr2[j]) {
                    len = 0;
                } else {
                    len++;
                }
                // 记录最大值，以及结束字符的位置
                if (len > max) {
                    end = i;
                    max = len;
                }
                i++;
                j++;
            }
                // 斜线开始位置的列先向左移动
            if (col > 0) {
                col--;
                // 列移动到最左之后，行向下移动
            } else {
                row++;
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }
    //endregion

}

package com.siwuxie095.forme.algorithm.chapter5th.question14th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-24 09:32:32
 */
public class Valid {

    public static boolean isValid(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        char[] charArr = str.toCharArray();
        int status = 0;
        for (int i = 0; i < charArr.length; ++i) {
            if (charArr[i] != '(' && charArr[i] != ')') {
                return false;
            }
            if (charArr[i] == ')' && --status < 0) {
                return false;
            }
            if (charArr[i] == '(') {
                status++;
            }
        }
        return status == 0;
    }

    public static int maxLength(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }
        char[] charArr = str.toCharArray();
        int[] dp = new int[charArr.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < charArr.length; ++i) {
            if (charArr[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && charArr[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}

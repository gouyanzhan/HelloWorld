package com.siwuxie095.forme.algorithm.chapter5th.question19th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-09 09:54:36
 */
public class Point {

    public static String pointNewChar(String s, int k) {
        if (null == s || "".equals(s) || k < 0 || k >= s.length()) {
            return "";
        }
        char[] charArr = s.toCharArray();
        int uNum = 0;
        for (int i = k - 1; i >= 0; i--) {
            if (!Character.isUpperCase(charArr[i])) {
                break;
            }
            uNum++;
        }
        if ((uNum & 1) == 1) {
            return s.substring(k - 1, k + 1);
        }
        if (Character.isUpperCase(charArr[k])) {
            return s.substring(k, k + 2);
        }
        return String.valueOf(charArr[k]);
    }

}

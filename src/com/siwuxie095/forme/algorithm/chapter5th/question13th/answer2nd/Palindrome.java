package com.siwuxie095.forme.algorithm.chapter5th.question13th.answer2nd;

import java.util.Set;

/**
 * @author Jiajing Li
 * @date 2019-04-22 21:53:39
 */
public class Palindrome {

    public static String getPalindrome(String str, String lps) {
        if (null == str || "".equals(str)) {
            return "";
        }
        char[] strCharArr = str.toCharArray();
        char[] lpsCharArr = lps.toCharArray();

        char[] res = new char[2 * strCharArr.length - lpsCharArr.length];
        int strl = 0;
        int strr = strCharArr.length - 1;
        int lpsl = 0;
        int lpsr = lpsCharArr.length - 1;
        int resl = 0;
        int resr = res.length - 1;
        int tmpl = 0;
        int tmpr = 0;
        while (lpsl <= lpsr) {
            tmpl = strl;
            tmpr = strr;
            while (strCharArr[strl] != lpsCharArr[lpsl]) {
                strl++;
            }
            while (strCharArr[strr] != lpsCharArr[lpsr]) {
                strr--;
            }
            set(res, resl, resr, strCharArr, tmpl, strl, strr, tmpr);
            resl += strl - tmpl + tmpr - strr;
            resr -= strl - tmpl + tmpr - strr;
            res[resl++] = strCharArr[strl++];
            res[resr--] = strCharArr[strr--];
            lpsl++;
            lpsr--;
        }
        return String.valueOf(res);
    }

    private static void set(char[] res, int resl, int resr, char[] charArr,
                     int ls, int le, int rs, int re) {
        for (int i = ls; i < le; ++i) {
            res[resl++] = charArr[i];
            res[resr--] = charArr[i];
        }
        for (int i = re; i > rs; --i) {
            res[resl++] = charArr[i];
            res[resr--] = charArr[i];
        }
    }

}

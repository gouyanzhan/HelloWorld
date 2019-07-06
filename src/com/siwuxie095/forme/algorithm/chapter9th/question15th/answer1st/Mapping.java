package com.siwuxie095.forme.algorithm.chapter9th.question15th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-07-06 15:16:10
 */
public class Mapping {

    //region 数字转字符串

    public static String getString(char[] chArr, int n) {
        if (null == chArr || chArr.length == 0 || n < 1) {
            return "";
        }
        int cur = 1;
        int base = chArr.length;
        int len = 0;
        while (n >= cur) {
            len++;
            n -= cur;
            cur *= base;
        }
        char[] res = new char[len];
        int index = 0;
        int nCur = 0;
        do {
            cur /= base;
            nCur = n / cur;
            res[index++] = getKthCharAtChArr(chArr, nCur + 1);
            n %= cur;
        } while (index != res.length);
        return String.valueOf(res);
    }

    private static char getKthCharAtChArr(char[] chArr, int k) {
        if (k < 1 || k > chArr.length) {
            return 0;
        }
        return chArr[k - 1];
    }

    //endregion


    //region 字符串转数字

    public static int getNum(char[] charArr, String str) {
        if (null == charArr || charArr.length == 0) {
            return 0;
        }
        char[] strArr = str.toCharArray();
        int base = charArr.length;
        int cur = 1;
        int res = 0;
        for (int i = strArr.length - 1; i != -1; i--) {
            res += getNthNumFromChArr(charArr,strArr[i]) * cur;
            cur *= base;
        }
        return res;
    }

    private static int getNthNumFromChArr(char[] chArr, char ch) {
        int res = -1;
        for (int i = 0; i != chArr.length; i++) {
            if (chArr[i] == ch) {
                res = i + 1;
                break;
            }
        }
        return res;
    }

    //endregion

}

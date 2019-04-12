package com.siwuxie095.forme.algorithm.chapter5th.question6th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-12 09:13:59
 */
public class Replace {

    public static String replace(String str, String from, String to) {
        if (null == str || null == from || "".equals(str) || "".equals(from)) {
            return str;
        }
        char[] strCharArr = str.toCharArray();
        char[] fromCharArr = from.toCharArray();
        int match = 0;
        for (int i = 0; i < strCharArr.length; ++i) {
            if (strCharArr[i] == fromCharArr[match++]) {
                if (match == fromCharArr.length) {
                    clear(strCharArr, i, fromCharArr.length);
                    match = 0;
                }
            } else {
                match = 0;
            }
        }
        String res = "";
        String curr = "";
        for (int i = 0; i < strCharArr.length; ++i) {
            if (strCharArr[i] != 0) {
                curr = curr + String.valueOf(strCharArr[i]);
            }
            if (strCharArr[i] == 0 && (i == 0 || strCharArr[i - 1] != 0)) {
                res = res + curr + to;
                curr = "";
            }
        }
        if (!"".equals(curr)) {
            res = res + curr;
        }
        return res;
    }

    private static void clear(char[] charArr, int end, int len) {
        while (len-- != 0) {
            charArr[end--] = 0;
        }
    }

}

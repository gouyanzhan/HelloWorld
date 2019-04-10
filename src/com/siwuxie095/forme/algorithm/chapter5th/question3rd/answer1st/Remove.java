package com.siwuxie095.forme.algorithm.chapter5th.question3rd.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-09 22:21:56
 */
public class Remove {

    public static String removeKZeros(String str, int k) {
        if (null == str || k < 1) {
            return str;
        }
        char[] charArr = str.toCharArray();
        int count = 0, start = -1;
        for (int i = 0; i != charArr.length; ++i) {
            if (charArr[i] == '0') {
                count++;
                start = (start == -1) ? i : start;
            } else {
                if (count == k) {
                    while (count-- != 0) {
                        charArr[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }
        if (count == k) {
            while (count-- != 0) {
                charArr[start++] = 0;
            }
        }
        return String.valueOf(charArr);
    }

}

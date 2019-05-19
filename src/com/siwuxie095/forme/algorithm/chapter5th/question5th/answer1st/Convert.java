package com.siwuxie095.forme.algorithm.chapter5th.question5th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-11 22:42:31
 */
public class Convert {

    public static int convert(String str) {
        if (null == str || "".equals(str)) {
            // 不能转
            return 0;
        }
        char[] charArr = str.toCharArray();
        if (!isValid(charArr)) {
            // 不能转
            return 0;
        }
        boolean posi = (charArr[0] == '-') ? false : true;
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int curr = 0;
        for (int i = posi ? 0 : 1; i < charArr.length; ++i) {
            curr = '0' - charArr[i];
            if ((res < minq) || (res == minq && curr < minr)) {
                // 不能转
                return 0;
            }
            res = res * 10 + curr;
        }
        if (posi && res == Integer.MIN_VALUE) {
            // 不能转
            return 0;
        }
        return posi ? -res : res;
    }

    private static boolean isValid(char[] charArr) {
        if (charArr[0] != '-' && (charArr[0] < '0' || charArr[0] > '9')) {
            return false;
        }
        if (charArr[0] == '-' && (charArr.length == 1 || charArr[1] == '0')) {
            return false;
        }
        if (charArr[0] == '0' && charArr.length > 1) {
            return false;
        }
        for (int i = 1; i < charArr.length; ++i) {
           if ( charArr[i] < '0' || charArr[i] > '9') {
               return false;
           }
        }
        return true;
    }

}

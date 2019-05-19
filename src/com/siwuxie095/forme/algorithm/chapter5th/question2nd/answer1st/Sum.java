package com.siwuxie095.forme.algorithm.chapter5th.question2nd.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-08 23:27:37
 */
public class Sum {

    public static int numSum(String str) {
        if (null == str) {
            return 0;
        }
        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int curr = 0;
        for (int i = 0; i < charArr.length; ++i) {
            curr = charArr[i] - '0';
            if (curr < 0 || curr > 9) {
                res += num;
                num = 0;
                if (charArr[i] == '-') {
                    if (i - 1 > -1 && charArr[i - 1] == '-') {
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? curr : - curr);
            }
        }
        res += num;
        return res;
    }

}

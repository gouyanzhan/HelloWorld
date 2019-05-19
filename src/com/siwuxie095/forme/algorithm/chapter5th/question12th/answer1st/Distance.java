package com.siwuxie095.forme.algorithm.chapter5th.question12th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-22 09:36:08
 */
public class Distance {

    public static int minDistance(String[] strArr, String str1, String str2) {
        if (null == str1 || null == str2) {
            return -1;
        }
        if (str1.equals(str2)) {
            return 0;
        }
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i != strArr.length; ++i) {
            if (strArr[i].equals(str1)) {
                min = Math.min(min, last2 == -1 ? min : i - last2);
                last1 = i;
            }
            if (strArr[i].equals(str2)) {
                min = Math.min(min, last1 == -1 ? min : i - last1);
                    last2 = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}

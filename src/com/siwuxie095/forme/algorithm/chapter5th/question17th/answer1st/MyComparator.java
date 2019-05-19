package com.siwuxie095.forme.algorithm.chapter5th.question17th.answer1st;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiajing Li
 * @date 2019-04-28 09:23:55
 */
public class MyComparator implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        return (a + b).compareTo(b + a);
    }

    public static String lowestString(String[] strArr) {
        if (null == strArr || strArr.length == 0) {
            return "";
        }
        // 根据新的比较方式排序
        Arrays.sort(strArr, new MyComparator());
        String res = "";
        for (int i = 0; i < strArr.length; i++) {
            res += strArr[i];
        }
        //return res.toUpperCase();
        return res;
    }
}

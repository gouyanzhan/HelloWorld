package com.siwuxie095.forme.algorithm.chapter5th.question9th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-16 20:47:31
 */
public class Index {

    public static int getIndex(String[] strArr, String str) {
        if (null == strArr || strArr.length == 0 || null == str) {
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = strArr.length - 1;
        int mid = 0;
        int i = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (null != strArr[mid] && strArr[mid].equals(str)) {
                res = mid;
                right = mid - 1;
            } else if (null != strArr[mid]) {
                if (strArr[mid].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            } else {
                i = mid;
                while (null == strArr[i] && --i >= left) {}
                if (i < left || strArr[i].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    res = strArr[i].equals(str) ? i : res;
                    right = i - 1;
                }
            }
        }
        return res;
    }

}

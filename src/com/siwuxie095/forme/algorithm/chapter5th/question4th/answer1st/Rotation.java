package com.siwuxie095.forme.algorithm.chapter5th.question4th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-11 09:22:53
 */
public class Rotation {

    public static boolean isRotation(String a, String b) {
        if (null == a || null == b || a.length() != b.length()) {
            return false;
        }
        String b2 = b + b;
        return getIndexOf(b2, a) != -1;
    }

    //region KMP 算法
    
    private static int getIndexOf(String s, String m) {
        if (null == s || null == m || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] sCharArr = s.toCharArray();
        char[] mCharArr = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(mCharArr);
        while (si < sCharArr.length && mi < mCharArr.length) {
            if (sCharArr[si] == mCharArr[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }
        return (mi == mCharArr.length) ? si - mi : -1;
    }

    private static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }
    
    //endregion
}

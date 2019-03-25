package com.siwuxie095.forme.algorithm.chapter3rd.question12th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-25 22:31:32
 */
public class SubTree {

    public static boolean isSubTree(Node t1, Node t2) {
        String t1Str = serialByPre(t1);
        System.out.println(t1Str);
        String t2Str = serialByPre(t2);
        System.out.println(t2Str);
        return getIndexOf(t1Str, t2Str) != -1;
    }

    private static String serialByPre(Node head) {
        if (null == head) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    /**
     * KMP
     */
    private static int getIndexOf(String s, String m) {
        if (null == s || null == m || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si -mi : -1;
    }

    private static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
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

}

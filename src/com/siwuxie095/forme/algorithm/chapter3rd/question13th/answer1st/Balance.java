package com.siwuxie095.forme.algorithm.chapter3rd.question13th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-26 09:14:47
 */
public class Balance {

    public static boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    private static int getHeight(Node head, int level, boolean[] res) {
        if (null == head) {
            return level;
        }
        int leftH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rightH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(leftH - rightH) > 1) {
            res[0] = false;
        }
        return Math.max(leftH, rightH);
    }

}

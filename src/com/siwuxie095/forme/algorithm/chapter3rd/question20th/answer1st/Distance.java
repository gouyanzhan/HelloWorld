package com.siwuxie095.forme.algorithm.chapter3rd.question20th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-31 10:58:38
 */
public class Distance {

    public static int maxDistance(Node head) {
        int[] recordArr = new int[1];
        return postOrder(head, recordArr);
    }

    private static int postOrder(Node head, int[] recordArr) {
        if (null == head) {
            recordArr[0] = 0;
            return 0;
        }
        int lMax = postOrder(head.left, recordArr);
        int maxFromLeft = recordArr[0];
        int rMax = postOrder(head.right, recordArr);
        int maxFromRight = recordArr[0];
        int currNodeMax = maxFromLeft + maxFromRight + 1;
        recordArr[0] = Math.max(maxFromLeft, maxFromRight) + 1;
        return Math.max(Math.max(lMax, rMax), currNodeMax);

    }

}

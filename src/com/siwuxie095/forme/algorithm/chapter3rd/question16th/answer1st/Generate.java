package com.siwuxie095.forme.algorithm.chapter3rd.question16th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-26 22:58:40
 */
public class Generate {

    public static Node generateTree(int[] sortArr) {
        if (null == sortArr) {
            return null;
        }
        return generate(sortArr, 0, sortArr.length - 1);
    }

    private static Node generate(int[] sortArr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node head = new Node(sortArr[mid]);
        head.left = generate(sortArr, start, mid - 1);
        head.right = generate(sortArr, mid + 1, end);
        return head;
    }

}

package com.siwuxie095.forme.algorithm.chapter3rd.question14th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-26 12:33:12
 */
public class PostArray {

    public static boolean isPostArray(int[] arr) {
        if (null == arr || arr.length == 0) {
            return false;
        }
        return isPost(arr, 0, arr.length - 1);
    }

    private static boolean isPost(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;
        for (int i = start; i < end; ++i) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = (more == end) ? i : more;
            }
        }
        if (less == -1 || more == end) {
            return isPost(arr, start, end - 1);
        }
        if (less != more - 1) {
            return false;
        }
        return isPost(arr, start, less) && isPost(arr, more, end - 1);
    }

    public static Node postArrayToBST(int[] postArr) {
        if (null == postArr) {
            return null;
        }
        return postToBST(postArr, 0, postArr.length - 1);
    }

    private static Node postToBST(int[] postArr, int start, int end) {
        if (start > end) {
            return null;
        }
        Node head = new Node(postArr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; ++i) {
            if (postArr[end] > postArr[i]) {
                less = i;
            } else {
                more = (more == end) ? i : more;
            }
        }
        head.left = postToBST(postArr, start, less);
        head.right = postToBST(postArr, more, end - 1);
        return head;
    }

}

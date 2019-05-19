package com.siwuxie095.forme.algorithm.chapter3rd.question7th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-21 12:41:51
 */
public class SubBST {

    public static Node biggestSubBST(Node head) {
        // 用于存搜索二叉子树的节点数、最小值和最大值
        int[] recordArr = new int[3];
        return postOrder(head, recordArr);
    }

    /**
     * 后序遍历：左-右-根
     */
    private static Node postOrder(Node head, int[] recordArr) {
        if (null == head) {
            recordArr[0] = 0;
            recordArr[1] = Integer.MAX_VALUE;
            recordArr[2] = Integer.MIN_VALUE;
            return null;
        }
        int value = head.value;
        Node leftNode = head.left;
        Node rightNode = head.right;
        Node leftBST = postOrder(leftNode, recordArr);
        int leftSize = recordArr[0];
        int leftMin = recordArr[1];
        int leftMax = recordArr[2];
        Node rightBST = postOrder(rightNode, recordArr);
        int rightSize = recordArr[0];
        int rightMin = recordArr[1];
        int rightMax = recordArr[2];
        recordArr[1] = Math.min(leftMin, value);
        recordArr[2] = Math.max(rightMax, value);
        if (leftNode == leftBST && rightNode == rightBST && leftMax < value && rightMin > value) {
            recordArr[0] = leftSize + rightSize + 1;
            return head;
        }
        recordArr[0] = Math.max(leftSize, rightSize);
        return leftSize > rightSize ? leftBST : rightBST;
    }

}

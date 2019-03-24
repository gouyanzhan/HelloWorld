package com.siwuxie095.forme.algorithm.chapter3rd.question8th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-21 22:32:57
 */
public class MaxTopo {

    public static int bstTopoSize(Node head) {
        if (null == head) {
            return 0;
        }
        int max = maxTopo(head, head);
        max = Math.max(bstTopoSize(head.left), max);
        max = Math.max(bstTopoSize(head.right), max);
        return max;
    }

    private static int maxTopo(Node head, Node curr) {
        if (null != head && null != curr && isBSTNode(head, curr, curr.value)) {
            return maxTopo(head, curr.left) + maxTopo(head, curr.right) + 1;
        }
        return 0;
    }

    private static boolean isBSTNode(Node head, Node curr, int currValue) {
        if (null == head) {
            return false;
        }
        if (head == curr) {
            return true;
        }
        return isBSTNode((head.value > currValue) ? head.left : head.right, curr, currValue);
    }

}

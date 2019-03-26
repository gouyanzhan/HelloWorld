package com.siwuxie095.forme.algorithm.chapter3rd.question15th.answer1st;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiajing Li
 * @date 2019-03-26 21:48:06
 */
public class Judge {

    /**
     * 是否是搜索二叉树（Binary Search Tree）
     */
    public static boolean isBST(Node head) {
        if (null == head) {
            return true;
        }
        boolean res = true;
        Node prev = null;
        Node curr1 = head;
        Node curr2 = null;
        while (null != curr1) {
            curr2 = curr1.left;
            if (null != curr2) {
                while (null != curr2.right && curr2.right != curr1) {
                    curr2 = curr2.right;
                }
                if (null == curr2.right) {
                    curr2.right = curr1;
                    curr1 = curr1.left;
                    continue;
                } else {
                    curr2.right = null;
                }
            }
            if (null != prev && prev.value > curr1.value) {
                res = false;
            }
            prev = curr1;
            curr1 = curr1.right;
        }
        return res;
    }

    /**
     * 是否是完全二叉树（Complete Binary Tree）
     */
    public static boolean isCBT(Node head) {
        if (null == head) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (null != l || null != r)) || (null == l && null != r)) {
                return false;
            }
            if (null != l) {
                queue.offer(l);
            }
            if (null != r) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }

}

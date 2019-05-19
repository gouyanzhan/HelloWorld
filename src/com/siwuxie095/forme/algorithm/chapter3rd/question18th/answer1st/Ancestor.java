package com.siwuxie095.forme.algorithm.chapter3rd.question18th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-27 22:11:46
 */
public class Ancestor {

    public static Node lowestAncestor(Node head, Node o1, Node o2) {
        if (null == head || head == o1 || head== o2) {
            return head;
        }
        Node left = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);
        if (null != left && null != right) {
            return head;
        }
        return null != left ? left : right;
    }

}

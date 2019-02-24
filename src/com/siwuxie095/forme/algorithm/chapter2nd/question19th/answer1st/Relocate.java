package com.siwuxie095.forme.algorithm.chapter2nd.question19th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-24 22:14:59
 */
public class Relocate {

    public static void relocate(Node head) {
        if (null == head || null == head.next) {
            return;
        }
        Node mid = head;
        Node right = head.next;
        /*
         * 找到中间节点
         */
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        /*
         * 左右半区分离
         */
        right = mid.next;
        mid.next = null;
        /*
         * 按要求合并
         */
        mergeLR(head, right);
    }

    private static void mergeLR(Node left, Node right) {
        Node nextNode = null;
        while (left.next != null) {
            nextNode = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = nextNode;
        }
        // 临界
        left.next = right;
    }

}

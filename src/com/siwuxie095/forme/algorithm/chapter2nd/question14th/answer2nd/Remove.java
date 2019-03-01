package com.siwuxie095.forme.algorithm.chapter2nd.question14th.answer2nd;

/**
 * @author Jiajing Li
 * @date 2019-02-22 22:06:30
 */
public class Remove {

    public static Node removeValue(Node head, int num) {
        /*
         * 找到第一个值不为 num 的节点，作为新头节点
         */
        while (null != head) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        // 当前节点之前的最近一个值不为 num 的节点
        Node prevNode = head;
        // 当前节点
        Node currNode = head;
        while (null != currNode) {
            if (currNode.value == num) {
                prevNode.next = currNode.next;
            } else {
                prevNode = currNode;
            }
            currNode = currNode.next;
        }
        return head;
    }

}

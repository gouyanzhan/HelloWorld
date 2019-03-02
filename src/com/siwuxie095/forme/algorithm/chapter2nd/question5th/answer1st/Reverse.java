package com.siwuxie095.forme.algorithm.chapter2nd.question5th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-17 20:04:04
 */
public class Reverse {

    /**
     * 反转部分单向链表
     *
     * @param head 头节点
     * @param from 反转开始的位置（注意：头节点处是位置 1，即 从 1 开始）
     * @param to   反转结束的位置
     * @return 反转后的头节点
     */
    public static Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fPrev = null;
        Node tNext = null;
        /*
         * 以 node1 为基础，遍历整个链表，计算出链表长度，
         * 并找到 fPrev 和 tNext
         */
        while (null != node1) {
            len++;
            fPrev = (len == from - 1) ? node1 : fPrev;
            tNext = (len == to + 1) ? node1 : tNext;
            node1 = node1.next;
        }
        /*
         * 如果不满足条件，直接返回 head
         */
        if (from > to || from < 1 || to > len) {
            return head;
        }

        // 将 node1 作为反转前反转部分的第一个节点
        node1 = (null == fPrev) ? head : fPrev.next;
        // 将 node2 作为基础，遍历反转部分
        Node node2 = node1.next;
        // 先将 node1 链接到 tNext 上
        node1.next = tNext;
        // nextNode 是 node2 的下一个节点
        Node nextNode = null;

        while (node2 != tNext) {
            nextNode = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = nextNode;
        }
        /*
         * 反转部分不包含原头节点，那就链上最后一环
         *
         * （经过一番移动，node1 变成了反转前反转部分的最后一个节点）
         */
        if (null != fPrev) {
            fPrev.next = node1;
            return head;
        }
        /*
         * 反转部分包含原头节点，返回新的头节点
         */
        return node1;
    }

}

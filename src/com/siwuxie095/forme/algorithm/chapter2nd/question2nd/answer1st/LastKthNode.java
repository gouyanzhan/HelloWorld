package com.siwuxie095.forme.algorithm.chapter2nd.question2nd.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-15 21:51:37
 */
public class LastKthNode {

    /**
     * 在单链表中删除倒数第 K 个节点
     *
     * @param head 头节点
     * @param lastKth 倒数第 K 个
     * @return 头节点
     */
    public static Node removeLastKthNode(Node head, int lastKth) {
        // 头节点为空 或 lastKth 小于 1，直接返回，不用删除
        if (null == head || lastKth < 1) {
            return head;
        }
        /*
         * 第一次遍历
         */
        Node curr = head;
        while (null != curr) {
            lastKth--;
            curr = curr.next;
        }
        /*
         * lastKth > 0，直接返回整个链表
         * lastKth = 0，删除头节点
         */
        if (lastKth == 0) {
            head = head.next;
        }
        /*
         * lastKth < 0，第二次遍历，找到要删除节点的前一个节点，便能顺利删除
         */
        if (lastKth < 0) {
            curr = head;
            while (++lastKth != 0) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }

        return head;
    }

    /**
     * 在双链表中删除倒数第 K 个节点
     *
     * @param head 头节点
     * @param lastKth 倒数第 K 个
     * @return 头节点
     */
    public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        // 头节点为空 或 lastKth 小于 1，直接返回，不用删除
        if (null == head || lastKth < 1) {
            return head;
        }
        /*
         * 第一次遍历
         */
        DoubleNode curr = head;
        while (null != curr) {
            lastKth--;
            curr = curr.next;
        }
        /*
         * lastKth > 0，直接返回整个链表
         * lastKth = 0，删除头节点
         */
        if (lastKth == 0) {
            head = head.next;
            head.prev = null;
        }
        /*
         * lastKth < 0，第二次遍历，找到要删除节点的前一个节点，便能顺利删除
         */
        if (lastKth < 0) {
            curr = head;
            while (++lastKth != 0) {
                curr = curr.next;
            }
            DoubleNode newNext = curr.next.next;
            curr.next = newNext;
            if (null != newNext) {
                newNext.prev = curr;
            }
        }

        return head;
    }

}

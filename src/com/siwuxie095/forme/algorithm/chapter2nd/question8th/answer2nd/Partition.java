package com.siwuxie095.forme.algorithm.chapter2nd.question8th.answer2nd;

/**
 * @author Jiajing Li
 * @date 2019-02-18 22:43:24
 */
public class Partition {

    public static Node listPartition(Node head, int pivot) {
        // small 链表的头
        Node sHead = null;
        // small 链表的尾
        Node sTail = null;
        // equal 链表的头
        Node eHead = null;
        // equal 链表的尾
        Node eTail = null;
        // big 链表的头
        Node bHead = null;
        // big 链表的尾
        Node bTail = null;

        // 保存下一个节点
        Node nextNode = null;
        /*
         * 所有节点分进三个链表中
         */
        while (head != null) {
            nextNode = head.next;
            // 每遍历一个，就把 head 断掉
            head.next = null;
            if (head.value < pivot) {
                if (null == sHead) {
                    sHead = head;
                    sTail = head;
                } else {
                    sTail.next = head;
                    sTail = head;
                }
            } else if (head.value == pivot) {
                if (null == eHead) {
                    eHead = head;
                    eTail = head;
                } else {
                    eTail.next = head;
                    eTail = head;
                }
            } else {
                if (null == bHead) {
                    bHead = head;
                    bTail = head;
                } else {
                    bTail.next = head;
                    bTail = head;
                }
            }
            head = nextNode;
        }
        /*
         * small 和 equal 链起来，即 小的和相等的重新链接
         */
        if (sTail != null) {
            sTail.next = eHead;
            eTail = (null == eTail) ? sTail : eTail;
        }
        /*
         * equal 和 big 链起来，即 相等的和大的重新链接
         */
        if (eTail != null) {
          eTail.next = bHead;
        }
        // 返回链表的新头节点
        return sHead != null ? sHead : (eHead != null ? eHead : bHead);
    }

}

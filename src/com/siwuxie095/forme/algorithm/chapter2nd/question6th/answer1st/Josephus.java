package com.siwuxie095.forme.algorithm.chapter2nd.question6th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-17 21:21:35
 */
public class Josephus {

    /**
     * 对于约瑟夫环，每报数到 m 的人就自杀（从环形链表中删除）
     */
    public static Node josephusKill(Node head, int m) {
        // 头节点为空 或 只有一个节点 或 报数小于 1
        if (null == head || head.next == head || m < 1) {
            return head;
        }
        // 通过遍历，找到尾节点
        Node tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        int count = 0;
        while (head != tail) {
            if (++count == m) {
                // 报数到 m，删除掉 head 处的节点
                tail.next = head.next;
                // 重置报数
                count = 0;
            } else {
                tail = tail.next;
            }
            head = tail.next;
        }

        return head;
    }

}

package com.siwuxie095.forme.algorithm.chapter2nd.question18th.answer1st;


/**
 * @author Jiajing Li
 * @date 2019-02-24 21:35:56
 */
public class Merge {

    public static Node merge(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return null != head1 ? head1 : head2;
        }
        /*
         * 初始化
         */
        Node head = (head1.value < head2.value) ? head1 : head2;
        Node currNode1 = (head == head1) ? head1 : head2;
        Node currNode2 = (head == head1) ? head2 : head1;
        // 上一次比较时，较小的节点
        Node prevNode = null;
        // 下一个节点
        Node nextNode = null;
        /*
         * 由于上面的初始化，所以第一次进循环，一定是 currNode1 的值
         * 小于等于 currNode2 的值
         */
        while (null != currNode1 && null != currNode2) {
            if (currNode1.value <= currNode2.value) {
                prevNode = currNode1;
                currNode1 = currNode1.next;
            } else {
                nextNode = currNode2.next;
                prevNode.next = currNode2;
                currNode2.next = currNode1;
                prevNode = currNode2;
                currNode2 = nextNode;
            }
        }
        prevNode.next = (null == currNode1) ? currNode2 : currNode1;
        return head;
    }

}

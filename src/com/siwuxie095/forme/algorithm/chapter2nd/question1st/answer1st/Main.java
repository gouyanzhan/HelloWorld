package com.siwuxie095.forme.algorithm.chapter2nd.question1st.answer1st;

/**
 * 打印两个有序链表的公共部分
 *
 * 题目：
 * 给定两个有序链表的头指针 head1 和 head2，打印两个链表的公共部分。
 *
 * 解答：
 * 因为是有序链表，所以从两个链表的头开始进行如下判断：
 * 1）如果 head1 的值小于 head2 的值，则 head1 向后移动；
 * 2）如果 head2 的值小于 head1 的值，则 head2 向后移动；
 * 3）如果 head1 的值与 head2 的值相等，则打印这个值，然后 head1 和 head2 都向后移动。
 *
 * 边界条件：head1 或 head2 有任何一个移动到 null，整个过程停止。
 *
 * 注意：只是打印公共部分，不是打印连续的公共部分
 *
 * @author Jiajing Li
 * @date 2019-02-13 22:22:21
 */
public class Main {

    public static void main(String[] args) {
        Node head1 = initLinkedList1();
        Node head2 = initLinkedList2();
        Common.printCommonPart(head1, head2);
    }

    private static Node initLinkedList1() {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(1);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        // 其实可以不用显式说明 node4 指向 null，默认初始化的时候就是 null
        node4.next = null;

        return node1;
    }

    private static Node initLinkedList2() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        return node1;
    }

}

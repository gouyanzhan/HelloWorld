package com.siwuxie095.forme.algorithm.chapter2nd.question12th.answer2nd;

/**
 * 将单链表的每 K 个节点之间逆序
 *
 * 题目：
 * 给定一个单链表单头节点 head，实现一个调整单链表的函数，使得每 K 个节点
 * 之间逆序，如果最后不够 K 个节点一组，则不调整最后几个节点。
 * 如：
 * 链表：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null，K = 3。
 * 调整后为：3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8 -> null。其
 * 中 7、8 不调整，因为不够一组。
 *
 * 解答：
 * 首先，如果 K 的值小于 2，不用进行任何调整。因为 K < 1 没有意义，而 K
 * = 1 时，代表每 1 个节点为一组进行逆序，原链表也没有任何变化。
 *
 * 进阶解法：不需要栈结构，在原链表中直接调整。
 * 用变量记录每一组开始的第一个节点和最后一个节点，然后直接逆序调整，把这一
 * 组的节点都逆序。和普通解法一样，同样要注意第一个节点的特殊处理，以及之后
 * 每个组在逆序重链之后，需要让该组的第一个节点链接上一组的最后一个节点，让
 * 该组的最后一个节点链接下一组的第一个节点。
 *
 * 进阶解法的时间复杂度是 O(N)，额外空间复杂度是 O(1)。
 *
 * @author Jiajing Li
 * @date 2019-02-21 12:54:21
 */
public class Main {

    public static void main(String[] args) {
        Node head = initNode();
        int K = 3;
        System.out.println(Reverse.reverseKNode(head, K));
    }

    private static Node initNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;

        return node1;
    }

}

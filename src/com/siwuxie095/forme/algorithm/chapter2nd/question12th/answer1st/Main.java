package com.siwuxie095.forme.algorithm.chapter2nd.question12th.answer1st;

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
 * 普通解法：利用栈结构。
 * 1、从左到右遍历链表，如果栈的大小不等于 K，就将节点不断压入栈中。
 * 2、当栈的大小第一次到达 K 时，说明第一次凑齐了 K 个节点进行逆序，从栈
 * 中依次弹出这些节点，并根据弹出的顺序重新链接，这一组逆序完成后，需要记
 * 录一下新的头部，同时第一组的最后一个节点（原来是头节点）应该链接下一个
 * 节点。
 * 3、步骤 2 之后，当栈的大小每次达到 K 时，说明又凑齐了一组应该进行逆序
 * 的节点，从栈中依次弹出这些节点，并根据弹出的顺序重新链接。这一组逆序完
 * 成后，该组的第一个节点应该被上一组的最后一个节点链接上，该组的最后一个
 * 节点应该链接下一组的第一个节点。然后继续去凑下一组，直到链表都被遍历完。
 * 4、最后应该返回 newHead，作为链表新的头节点。
 *
 * 普通解法的时间复杂度是 O(N)，额外空间复杂度是 O(N)。
 *
 * @author Jiajing Li
 * @date 2019-02-21 12:43:33
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

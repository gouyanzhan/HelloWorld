package com.siwuxie095.forme.algorithm.chapter2nd.question5th.answer1st;

/**
 * 反转部分单向链表
 *
 * 题目：
 * 给定一个单向链表的头节点 head，以及两个整数 from 和 to，在单向链表上把第 from 个节点
 * 到第 to 个节点这一部分进行反转。（头节点是第 1 个节点，所以 from 要大于等于 1）
 *
 * 如：
 * 1 -> 2 -> 3 -> 4 -> 5 -> null，from = 2，to = 4
 * 反转后的结果为：1 -> 4 -> 3 -> 2 -> 5 -> null
 * 再如：
 * 1 -> 2 -> 3 -> null，from = 1，to = 3
 * 反转后的结果为：3 -> 2 -> 1 -> null
 *
 * 要求：
 * 1、如果链表长度为 N，时间复杂度为 O(N)，额外空间复杂度要求为 O(1)。
 * 2、如果不满足 1<= from <= to <= N，则不用反转。
 *
 * 解答：
 * 本题有可能存在换头的问题，即 当 from = 1 时，所以函数应该返回反转后的新头节点，整个
 * 处理过程如下：
 * 1、先判断是否满足 1 <= from <= to <= N，如果不满足，则直接返回原头节点。
 * 2、找到第 from-1 个节点 fPrev 和第 to+1 个节点 tNext。fPrev 即是要反转部分的前
 * 一个节点，tNext 是反转部分的后一个节点。把反转的部分先反转，然后正确连接 fPrev 和
 * tNext。
 * 3、如果 fPrev 为 null，说明反转部分是包含头节点的，即 from = 1，则返回新的头节点，
 * 即 没反转之前反转部分的最后一个节点，也是反转之后反转部分的第一个节点；如果 fPrev 不
 * 为 null，则返回旧的头节点。
 *
 * @author Jiajing Li
 * @date 2019-02-17 20:03:47
 */
public class Main {

    public static void main(String[] args) {
        Node head = initNode();
        System.out.println("反转部分单向链表，反转前：" + head);
        System.out.println("反转部分单向链表，反转后：" + Reverse.reversePart(head, 2, 4));
    }

    private static Node initNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }

}

package com.siwuxie095.forme.algorithm.chapter2nd.question4th.answer1st;


/**
 * 反转单向双向链表
 *
 * 题目：
 * 分别实现反转单向链表和双向链表的函数。
 *
 * 要求：如果链表的长度为 N，时间复杂度要求为 O(N)，额外空间复杂度要求为 O(1)。
 *
 * 解答：
 * 直接看代码实现即可。
 *
 * @author Jiajing Li
 * @date 2019-02-17 18:42:50
 */
public class Main {

    public static void main(String[] args) {
        Node headNode = initNode();
        System.out.println("单向链表，逆转前：" + headNode);
        System.out.println("单向链表，逆转后：" + Reverse.reverseList(headNode));
        System.out.println("---------------------------");
        DoubleNode headDoubleNode = initDoubleNode();
        System.out.println("双向链表，逆转前：" + headDoubleNode);
        System.out.println("双向链表，逆转后：" + Reverse.reverseList(headDoubleNode));
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

    private static DoubleNode initDoubleNode() {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        DoubleNode node5 = new DoubleNode(5);

        node1.prev = null;
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = null;

        return node1;
    }

}

package com.siwuxie095.forme.algorithm.chapter2nd.question7th.answer2nd;

/**
 * 判断一个链表是否为回文结构
 *
 * 题目：
 * 给定一个链表的头节点 head，请判断该链表是否为回文结构。
 * 如：
 * 1 -> 2 -> 1，返回 true。
 * 1 -> 2 -> 2 -> 1，返回 true。
 * 15 -> 6 -> 15，返回 true。
 * 1 -> 2 -> 3，返回 false。
 *
 * 解答：
 * 再看方法二：方法二对方法一进行了优化，但还是利用栈结构。但其实并不需要将所有
 * 的节点都压入栈中，只用压入一半的节点即可。
 * 首先假设链表的长度为 N。如果 N 是偶数，前 N/2 的节点叫做左半区，后 N/2 的
 * 节点叫做右半区。如果 N 是奇数，忽略处于最中间的节点，还是前 N/2 的节点叫做左
 * 半区，后 N/2 的节点叫做右半区。
 * 如：
 * 链表 1 -> 2 -> 2 -> 1，左半区为 1，2；右半区为 2，1。
 * 链表 1 -> 2 -> 3 -> 2 -> 1，左半区为 1，2；右半区为 2，1。
 * 方法二就是把整个链表的右半部分压入栈中，压入完成后，再检查栈顶到栈底值出现的顺
 * 序是否和链表左半部分的值相对应。
 *
 * 方法二可以直观的理解为将链表的右半部分"折过去"，然后让它和左半部分比较。
 *
 * 方法二也需要一个额外的栈结构，并且需要把一半的节点都压入栈中，所以时间复杂度是
 * O(N)，额外空间复杂度是 O(N/2)。
 *
 * @author Jiajing Li
 * @date 2019-02-18 09:30:45
 */
public class Main {

    public static void main(String[] args) {
        Node head = initNode1();
        System.out.println(Palindrome.isPalindrome(head));
        System.out.println("---------------------------");
        head = initNode2();
        System.out.println(Palindrome.isPalindrome(head));
    }

    private static Node initNode1() {
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

    private static Node initNode2() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }

}

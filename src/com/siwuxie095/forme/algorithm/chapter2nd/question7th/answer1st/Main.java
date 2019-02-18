package com.siwuxie095.forme.algorithm.chapter2nd.question7th.answer1st;

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
 * 先看方法一：利用栈结构。从左到右遍历链表，遍历的过程中把每个节点依次压入栈中。
 * 因为栈是先进后出的，所以在遍历完成后，从栈顶到栈底的节点值出现顺序会与原链表
 * 从左到右的节点值出现顺序相反。
 * 那么如果一个链表是回文结构，逆序之后，值出现的顺序其实还是一样的；而如果不是
 * 回文结构，顺序就肯定对不上。
 *
 * 方法一需要一个额外的栈结构，并且需要把所有的节点都压入栈中，所以时间复杂度是
 * O(N)，额外空间复杂度是 O(N)。
 *
 * @author Jiajing Li
 * @date 2019-02-18 09:10:43
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

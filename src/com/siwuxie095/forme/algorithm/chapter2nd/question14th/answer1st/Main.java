package com.siwuxie095.forme.algorithm.chapter2nd.question14th.answer1st;

/**
 * 在单链表中删除指定值的节点
 *
 * 题目：
 * 给定一个链表的头节点 head 和一个整数 num，请实现函数将值为 num 的节点全部删除。
 * 如：
 * 链表为 1 -> 2 -> 3 -> 4 -> null，num = 3，链表调整后为 1 -> 2 -> 4 -> null。
 *
 * 解答：
 * 方法一：利用栈或者其他容器收集节点的方法。
 * 将值不为 num 的节点用栈收集起来，收集完成后重新链接即可。最后将栈底的节点作为新的
 * 头节点返回。
 *
 * 此法的时间复杂度为 O(N)，额外空间复杂度为 O(N)。
 *
 * @author Jiajing Li
 * @date 2019-02-22 21:54:36
 */
public class Main {

    public static void main(String[] args) {
        Node head = initNode();
        int num = 4;
        System.out.println(Remove.removeValue(head, num));
    }

    private static Node initNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        return node1;
    }

}

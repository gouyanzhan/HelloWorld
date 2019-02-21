package com.siwuxie095.forme.algorithm.chapter2nd.question13th.answer2nd;

/**
 * 删除无序单链表中值重复出现的节点
 *
 * 题目：
 * 给定一个无序单链表的头节点 head，删除其中值重复出现的节点。
 * 如：
 * 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 2 -> 1 -> 1 -> null，
 * 删除值重复的节点之后为 1 -> 2 -> 3 -> 4 -> null。
 *
 * 解答：
 * 方法二：类似选择排序的过程。
 * 如：
 * 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 2 -> 1 -> 1 -> null。
 * 1、首先是头节点，值为 1，往后检查所有值为 1 的节点，全部删除。链表变成 ...
 * 2、然后是第二个节点，值为 2，往后检查所有值为 2 的节点，全部删除，链表变成 ...
 * 3、... ...
 * 4、最终，链表变成 1 -> 2 -> 3 -> 4 -> null。
 *
 * 此法的时间复杂度是 O(N^2)，额外空间复杂度是 O(1)。
 *
 * @author Jiajing Li
 * @date 2019-02-21 23:20:35
 */
public class Main {

    public static void main(String[] args) {
        Node head = initNode();
        Remove.removeRepeatNode(head);
        System.out.println(head);
    }

    private static Node initNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(1);
        Node node6 = new Node(2);
        Node node7 = new Node(3);
        Node node8 = new Node(4);

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

package com.siwuxie095.forme.algorithm.chapter2nd.question19th.answer1st;

/**
 * 按照左右半区的方式重新组合单链表
 *
 * 题目：
 * 给定一个单链表的头节点 head，链表长度为 N。如果 N 为偶数，那么
 * 前 N/2 个节点算作左半区，后 N/2 个节点算作右半区；如果 N 为奇数，
 * 那么前 N/2 个节点算作左半区，后 N/2+1 个节点算作右半区。左半区从
 * 左到右依次记为 L1 -> L2 -> ...，右半区从左到右依次记为 R1 -> R2
 * -> ...，请将单链表调整成 L1 -> R1 -> L2 -> R2 -> ... 的形式。
 *
 * 如：
 * 1 -> null，调整为 1 -> null。
 * 1 -> 2 -> null，调整为 1 -> 2 -> null。
 * 1 -> 2 -> 3 -> null，调整为 1 -> 2 -> 3 -> null。
 * 1 -> 2 -> 3 -> 4 -> null，调整为 1 -> 3 -> 2 -> 4 -> null。
 *
 * 解答：
 * 假设链表的长度为 N，直接给出时间复杂度为 O(N)、额外空间复杂度为
 * O(1) 的方法。具体过程如下：
 * 1、如果链表为空 或 长度为 1，不用调整，过程直接结束。
 * 2、链表的长度大于 1 时，遍历一遍找到左半区的最后一个节点，记为 mid。
 * 3、遍历一遍找到 mid 之后，将左半区和右半区分离成两个链表，分别记为
 * left（即 head） 和 right（即 mid.next）。
 * 4、将两个链表按要求合并起来。
 *
 * @author Jiajing Li
 * @date 2019-02-24 22:14:45
 */
public class Main {

    public static void main(String[] args) {
        Node head = initNode();
        Relocate.relocate(head);
        System.out.println(head);
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

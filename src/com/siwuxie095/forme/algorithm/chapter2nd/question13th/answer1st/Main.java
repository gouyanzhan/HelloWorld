package com.siwuxie095.forme.algorithm.chapter2nd.question13th.answer1st;

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
 * 方法一：利用哈希表 HashSet。
 * 1、生成一个哈希表，因为头节点是不用删除的节点，所以首先将头节点的值
 * 放进哈希表。
 * 2、从头节点的下一个节点开始往后遍历节点，假设当前遍历到 currNode 节
 * 点，先检查 currNode 的值是否在哈希表中：如果在，说明 currNode 的值
 * 是之前出现过的，就将 currNode 节点删除，删除的方式是将最近一个没有被
 * 删除的节点（currNode 的上一个节点） prevNode 链接到 currNode 的下
 * 一个节点，即 prevNode.next = currNode.next。如果不在，将 currNode
 * 的值放进哈希表，同时令 preNode = currNode，即 更新最近一个没有被删除
 * 的节点。
 *
 * 此法的时间复杂度是 O(N)，额外空间复杂度是 O(N)。
 *
 * @author Jiajing Li
 * @date 2019-02-21 22:59:01
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

package com.siwuxie095.forme.algorithm.chapter2nd.question14th.answer2nd;

/**
 * 在单链表中删除指定值的节点
 *
 * 题目：
 * 给定一个链表的头节点 head 和一个整数 num，请实现函数将值为 num 的节点全部删除。
 * 如：
 * 链表为 1 -> 2 -> 3 -> 4 -> null，num = 3，链表调整后为 1 -> 2 -> 4 -> null。
 *
 * 解答：
 * 方法二：不用任何容器而直接调整的方法。
 * 首先从链表头开始，找到第一个值不为 num 的节点作为新的头节点，这个节点肯定是不用删
 * 除的，记为 newHead。
 * 继续往后遍历，假设当前节点为 currNode，如果 currNode 节点值等于 num，就将 currNode
 * 删除，删除的方式是将之前最近一个值不等于 num 的节点 prevNode 链接到 currNode 的
 * 下一个节点，即 prevNode.next = currNode.next；如果 currNode 节点值不等于 num，
 * 就令 prevNode = currNode，即 更新最近一个值不等于 num 的节点。
 *
 * 此法的时间复杂度为 O(N)，额外空间复杂度为 O(1)。
 *
 * @author Jiajing Li
 * @date 2019-02-22 22:06:16
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

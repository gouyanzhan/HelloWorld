package com.siwuxie095.forme.algorithm.chapter2nd.question18th.answer1st;

/**
 * 合并两个有序的单链表
 *
 * 题目：
 * 给定两个有序单链表的头节点 head1 和 head2，请合并两个有序链表，
 * 合并后的链表依然有序，并返回合并后链表的头节点。
 * 如：
 * 0 -> 2 -> 3 -> 7 -> null
 * 1 -> 3 -> 5 -> 7 -> 9 -> null
 * 合并后的链表为：0 -> 1 -> 2 -> 3 -> 3 -> 5 -> 7 -> 7 -> 9 -> null
 *
 * 解答：
 * 假设两个链表的长度分别为 M 和 N，直接给出时间复杂度为 O(M+N)、
 * 额外空间复杂度为 O(1) 的方法。具体过程如下：
 * 1、如果两个链表中有一个为空，说明无须合并过程，返回另一个链表的
 * 头节点即可。
 * 2、比较 head1 和 head2 的值，小的节点也是合并后链表的最小节点，
 * 这个节点无疑应该是合并链表的头节点，记为 head；在之后的步骤里，哪
 * 个链表的头节点的值更小，另一个链表的所有节点都会依次插入到这个链表
 * 中。
 * 3、不妨设 head 节点所在的链表为链表 1，另一个链表为链表 2。链表 1
 * 和链表 2 都从头部开始一起遍历，比较每次遍历到的两个节点的值，分别
 * 记为 currNode1 和 currNode2。然后根据大小关系作出不同的调整，同
 * 时用一个变量 prevNode 表示上次比较时值较小的节点。
 * 4、如果链表 1 先走完，此时 currNode1 = null，prevNode 为链表 1
 * 的最后一个节点，那么就把 prevNode 的 next 指针指向链表 2 的当前
 * 节点 currNode2，表示把链表 2 没遍历到的有序部分直接拼接到最后，调
 * 整结束。如果链表 2 先走完，说明链表 2 的所有节点都已经插入到链表 1
 * 中，调整结束。
 * 5、返回合并后的链表头节点 head。
 *
 * @author Jiajing Li
 * @date 2019-02-24 21:35:38
 */
public class Main {

    public static void main(String[] args) {
        Node head1 = initNode1();
        Node head2 = initNode2();
        System.out.println(Merge.merge(head1, head2));
    }

    private static Node initNode1() {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node5 = new Node(5);

        node1.next = node3;
        node3.next = node5;
        node5.next = null;

        return node1;
    }

    private static Node initNode2() {
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node6 = new Node(6);

        node2.next = node4;
        node4.next = node6;
        node6.next = null;

        return node2;
    }

}

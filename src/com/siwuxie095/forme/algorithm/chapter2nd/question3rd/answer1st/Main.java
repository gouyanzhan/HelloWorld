package com.siwuxie095.forme.algorithm.chapter2nd.question3rd.answer1st;

/**
 * 删除链表的中间节点和 a/b 处的节点
 *
 * （a/b 即 b 分之 a）
 *
 * 题目：
 * 给定链表的头节点 head，实现删除链表的中间节点的函数。
 * 如：
 * 链表为空 或 只有一个节点时，不删除任何节点；
 * 链表为 1 -> 2，删除节点 1；
 * 链表为 1 -> 2 -> 3，删除节点 2；
 * 链表为 1 -> 2 -> 3 -> 4，删除节点 2；
 * 链表为 1 -> 2 -> 3 -> 4 -> 5，删除节点 3；
 *
 * 给定链表的头节点 head、整数 a 和整数 b，实现删除位于 a/b 处节点的函数。
 * 如：
 * 链表：1 -> 2 -> 3 -> 4 -> 5，假设 a/b 的值为 r（r 可以为小数）。
 * 如果 r 等于 0，不删除任何节点。
 * 如果 r 在区间 (0，1/5]，删除节点 1；
 * 如果 r 在区间 (1/5，2/5]，删除节点 2；
 * 如果 r 在区间 (2/5，3/5]，删除节点 3；
 * 如果 r 在区间 (3/5，4/5]，删除节点 4；
 * 如果 r 在区间 (4/5，1]，删除节点 5；
 * 如果 r 大于 1，不删除任何节点。
 *
 * 解答：
 * 先分析原问题，如果链表为空 或 长度为 1，不需要调整，则直接返回；
 * 如果链表长度为 2，将头节点删除即可；当链表长度为 3，应该删除第
 * 2 个节点；当链表的长度为 4，应该删除第 2 个节点；当链表的长度
 * 为 5，应该删除第 3 个节点 ...
 * 也就是链表长度每增加 2，要删除的节点就后移一个节点。而如果要删
 * 除一个节点，则需要找到待删除节点的前一个节点。
 *
 * @author Jiajing Li
 * @date 2019-02-16 22:07:45
 */
public class Main {

    public static void main(String[] args) {
        Node head = initNode();
        System.out.println(Remove.removeMidNode(head));
        System.out.println("----------------------------");
        head = initNode();
        System.out.println(Remove.removeByRatio(head, 3, 5));
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

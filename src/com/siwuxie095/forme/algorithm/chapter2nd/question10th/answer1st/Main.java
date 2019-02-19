package com.siwuxie095.forme.algorithm.chapter2nd.question10th.answer1st;

/**
 * 两个单链表生成相加链表
 *
 * 题目：
 * 假设链表中每一个节点的值都在 0～9 之间，那么链表整体就可以代表一个整数。
 * 如：
 * 9 -> 3 -> 7，可以代表整数 937。
 * 给定两个这种链表的头节点 head1 和 head2，请生成代表两个整数相加值的结
 * 果链表。
 * 如：链表 1 为 9 -> 3 -> 7，链表 2 为 6 -> 3，最后生成的结果链表为
 * 1 -> 0 -> 0 -> 0。
 *
 * 解答：
 * 普通解法：将两个链表先算出各自所代表的整数，然后求出两个整数的和，最后将
 * 这个和转换成链表的形式。
 * 但是这种方法有一个很大的问题，链表的长度可以很长，可以表达一个很大的整数，
 * 因此转成系统中的 int 类型时可能会溢出，所以不推荐这种方法。
 *
 * @author Jiajing Li
 * @date 2019-02-19 11:30:28
 */
public class Main {

    public static void main(String[] args) {
        Node head1 = initNode1();
        Node head2 = initNode2();
        System.out.println(Add.addList(head1, head2));
    }

    private static Node initNode1() {
        Node node1 = new Node(9);
        Node node2 = new Node(3);
        Node node3 = new Node(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        return node1;
    }

    private static Node initNode2() {
        Node node1 = new Node(6);
        Node node2 = new Node(3);

        node1.next = node2;
        node2.next = null;

        return node1;
    }

}

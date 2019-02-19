package com.siwuxie095.forme.algorithm.chapter2nd.question10th.answer3rd;

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
 * 进阶解法二：利用链表的逆序求解，可以省掉用栈的空间。
 * 1、将两个链表逆序，这样就可以一次得到从低位到高位的数字。
 * 2、同时遍历两个逆序后的链表，这样就依次得到两个链表从低位到高位的数字，
 * 在这个过程中生成相加链表即可，同时需要关注每一步是否有进位，用 ca 表
 * 示（ca 是 carry 的缩写）。
 * 3、当两个链表都遍历完成后，还要关注进位信息是否为 1，如果为 1，还要
 * 生成一个节点值为 1 的新节点。
 * 4、将两个逆序的链表再逆序一次，即 调整成原来的样子。
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

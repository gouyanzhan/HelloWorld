package com.siwuxie095.forme.algorithm.chapter2nd.question7th.answer3rd;

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
 * 进阶：如果链表的长度为 N，时间复杂度达到 O(N)，额外空间复杂度达到 O(1)。
 *
 * 解答：
 * 再看方法三：方法三不需要栈和其他数据结构，只用有限的几个变量，其额外空间复杂度
 * 为 O(1)，就可以在时间复杂度为 O(N) 内完成所有的过程，也就是满足进阶的要求。
 *
 * 其具体过程如下：
 * 1、首先改变链表右半区的结构，使整个右半区反转，最后指向中间节点。
 * 如：
 * 1 -> 2 -> 3 -> 2 -> 1，右半区反转后为： 1 -> 2 -> 3（中间节点） <- 2 <- 1；
 * 1 -> 2 -> 3 -> 3 -> 2 -> 1，右半区反转后为：1 -> 2 -> 3（中间节点） <- 3 <- 2 <- 1。
 * 将左半区的最左边的节点（原链表的头节点）记为 leftStart，将右半区反转之后的
 * 最右边的节点（原链表的尾节点）记为 rightStart。
 * 2、leftStart 和 rightStart 同时向中间节点移动，移动每一步都比较 leftStart
 * 和 rightStart 节点的值，看是否一样。如果都一样，说明链表为回文结构，否则不是回
 * 文结构。
 * 3、不管最后返回的是 true 还是 false，在返回之前都应该把链表恢复成原来的样子。
 * 4、链表恢复成原来的结构后，返回检查结果。
 *
 * 整个过程只需要申请三个 Node 类型的变量。
 *
 * @author Jiajing Li
 * @date 2019-02-18 09:57:49
 */
public class Main {

    public static void main(String[] args) {
        Node head = initNode1();
        System.out.println(Palindrome.isPalindrome(head));
        System.out.println("检查链表是否恢复：" + head);
        System.out.println("---------------------------");
        head = initNode2();
        System.out.println(Palindrome.isPalindrome(head));
        System.out.println("检查链表是否恢复：" + head);
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

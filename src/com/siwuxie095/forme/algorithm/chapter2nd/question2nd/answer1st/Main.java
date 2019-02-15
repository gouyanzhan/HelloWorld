package com.siwuxie095.forme.algorithm.chapter2nd.question2nd.answer1st;

/**
 * 在单链表和双链表中删除倒数第 K 个节点
 *
 * 题目：
 * 分别实现两个函数，一个可以删除单链表中倒数第 K 个节点，另一个可以
 * 删除双链表中倒数第 K 个节点。
 *
 * 单链表 即 单向链表。双链表 即 双向链表。
 *
 * 解答：
 * 1、对于单链表：
 * 如果链表为空，或者 K 小于 1，此时参数无效，直接返回即可。除此之外，
 * 让链表从头开始走到尾，每移动一步，就让 K 减 1。
 * 1）如果最终 K 大于 0，则表明根本不存在倒数第 K 个节点，此时不用删除，
 * 直接返回整个链表即可。
 * 2）如果最终 K 等于 0，则表明头节点即为倒数第 K 个节点，此时直接返回
 * head.next，作为整个链表的头节点，相当于删除了原 head。
 * 3）如果最终 K 小于 0，比较复杂，可以先分析一下：要想删除倒数第 K 个
 * 节点，实际上就是要找到倒数第 K 个节点的前一个节点，把该节点的下一个节
 * 点指向倒数第 K 个节点的下一个节点，就相当于删除了倒数第 K 个节点。
 * 如果链表长度为 N，显然，倒数第 K 个节点的前一个节点是第 N - K 个节点。
 * 而经过第一次遍历后，K 的值是 K - N，所以只要再做第二次遍历，遍历的同时
 * 对 K 加 1。当 K 等于 0 时的节点，就是所要的第 N - K 个节点，即 重新
 * 遍历 N - K 个节点即可。
 * 具体的：重新从头节点开始走，每移动一步，K 加 1。当 K 等于 0 时，移动停
 * 止，移动到的节点就是要删除节点的前一个节点。
 *
 * 2、对于双链表：
 * 注意一下 prev 指针的重连即可。
 *
 * @author Jiajing Li
 * @date 2019-02-15 21:50:51
 */
public class Main {

    public static void main(String[] args) {
        Node headNode = initNode();
        DoubleNode headDoubleNode = initDoubleNode();
        int lastKth = 3;

        System.out.println(LastKthNode.removeLastKthNode(headNode, lastKth));
        System.out.println("----------------------------------------------");
        System.out.println(LastKthNode.removeLastKthNode(headDoubleNode, lastKth));

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

    private static DoubleNode initDoubleNode() {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        DoubleNode node5 = new DoubleNode(5);

        node1.prev = null;
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = null;

        return node1;
    }

}

package com.siwuxie095.forme.algorithm.chapter2nd.question8th.answer1st;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 *
 * 题目：
 * 给定一个单向链表的头节点 head，节点的值类型是整型，再给定一个整数 pivot。实现一个调整
 * 链表的函数，将链表调整为左部分都是值小于 pivot 的节点，中间部分都是值等于 pivot 的节
 * 点，右部分都是值大于 pivot 的节点。除了这个要求外，对调整后的节点顺序没有更多要求。
 * 如：
 * 链表 9 -> 0 -> 4 -> 5 -> 1，pivot = 3。
 * 调整后的链表可以是 1 -> 0 -> 4 -> 9 -> 5，也可以是 0 -> 1 -> 9 -> 5 -> 4。总之，
 * 满足左部分都是小于 3 的节点，中间部分都是等于 3 的节点（本例中这个部分为空），右部分都是
 * 大于 3 的节点即可。对某部分内部的节点顺序不做要求。
 *
 * 解答：
 * 普通解法：该解法时间复杂度是 O(N)，额外空间复杂度是 O(N)，就是把链表中的所有节点放入一个
 * 额外的数组中，然后统一调整位置的办法。具体过程如下：
 * 1、先遍历一遍链表，为了得到链表的长度，假设长度为 N。
 * 2、生成长度为 N 的 Node 类型的数组 nodeArr，然后遍历一遍链表，将节点依次放进 nodeArr 中。
 * 这里不使用 LinkedList 或 ArrayList 等结构，因为一个纯粹的数组结构比较有利于步骤 3 的调整。
 * 3、在 nodeArr 中把小于 pivot 的节点放在左边，把相等的放中间，把大于的放在右边。也就是改进了
 * 快速排序中 partition 的调整过程，即 代码中的 arrPartition 方法。（具体见 8 - 23）
 * 4、经过步骤 3 的调整后，nodeArr 是满足题目要求的节点顺序，只要把 nodeArr 中的节点依次重连
 * 起来即可，整个过程结束。
 *
 * @author Jiajing Li
 * @date 2019-02-18 19:06:02
 */
public class Main {

    public static void main(String[] args) {
        Node head = initNode();
        // pivot 即 枢纽
        int pivot = 3;
        System.out.println(Partition.listPartition(head, pivot));
    }

    private static Node initNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(5);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }

}

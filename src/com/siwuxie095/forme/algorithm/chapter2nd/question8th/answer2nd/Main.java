package com.siwuxie095.forme.algorithm.chapter2nd.question8th.answer2nd;

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
 * 进阶：在原问题的要求上再增加如下两个要求。
 * 1、在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左到右的顺序与原链表中节点
 * 的先后次序一样。
 * 如：
 * 链表 9 -> 0 -> 4 -> 5 -> 1，pivot = 3。调整后是 0 -> 1 -> 9 -> 4 -> 5。在满足原
 * 要求的同时，左部分节点从左到右为 0、1，在原链表中也是先出现 0，后出现 1；中间部分在本例
 * 中为空，不讨论；右部分节点从左到右为 9、4、5，在原链表中也是先出现 9，再出现 4，后出现 5。
 * 2、如果链表长度为 N，时间复杂度请达到 O(N)，额外空间复杂度请达到 O(1)。
 *
 * 解答：
 * 进阶解法：现在对每部分都增加了节点顺序要求，同时时间复杂度为 O(N)，额外空间复杂度为 O(1)。
 * 既然额外空间复杂度为 O(1)，说明实现时只能使用有限的几个变量来完成所有的调整。
 * 具体过程如下：
 * 1、将原链表的所有节点依次划分进三个链表，三个链表是 small、equal、big，分别代表左部分、
 * 中间部分、右部分。
 * 如：
 * 链表 7 -> 9 -> 1 -> 8 -> 5 -> 2 -> 5，pivot = 5。在划分之后,三个部分分别为：
 * small: 1 -> 2 -> null
 * equal: 5 -> 5 -> null
 * big:   7 -> 9 -> 8 -> null
 * 2、将 small、equal、big 三个链表重新串起来即可。
 * 3、整个过程需要特别注意 null 节点的判断和处理。
 *
 * （主要考察了利用有限几个变量调整链表的代码能力）
 *
 * @author Jiajing Li
 * @date 2019-02-18 22:43:11
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

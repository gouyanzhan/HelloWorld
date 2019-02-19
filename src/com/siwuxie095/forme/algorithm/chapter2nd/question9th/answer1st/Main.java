package com.siwuxie095.forme.algorithm.chapter2nd.question9th.answer1st;

/**
 * 复制含有随机指针节点的链表
 *
 * 题目：
 * 有这样一种特殊的链表节点类：Node 类中的 value 是节点值，next 指针和正常单链表中 next
 * 指针的意义一样，都指向下一个节点，rand 指针是 Node 类中新增的指针，这个指针可能指向链表
 * 中的任意一个节点，也可能指向 null。
 * 给定一个由 Node 节点类型组成的无环单链表的头节点 head（注意：无环是相对于 next 指针而言），
 * 请实现一个函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。
 * 如：
 * 链表： 1 -> 2 -> 3 -> null，假设 1 的 rand 指针指向 3；2 的 rand 指针指向 null；3 的
 * rand 指针指向 1。复制后的链表应该也是这种结构，比如：1^ -> 2^ -> 3^ -> null。1^ 的 rand
 * 指针指向 3^；2^ 的 rand 指针指向 null；3^ 的 rand 指针指向 1^。最后返回 1^。
 *
 * 解答：
 * 普通解法：普通解法可以做到时间复杂度为 O(N)，额外空间复杂度为 O(N)，需要使用到哈希表 HashMap
 * 结构，具体过程如下：
 * 1、首先从左到右遍历链表，对每个节点都复制生成相应都副本节点，然后将对应关系放到哈希表 map 中。此
 * 步完成后，原链表没有任何变化，每一个副本节点的 next 和 rand 指针都指向 null。
 * 2、再次从左到右遍历链表，此时就可以设置每一个副本节点的 next 和 rand 指针。
 * 3、将新链表的头节点返回即可。
 *
 * 哈希表的增删改查的时间复杂度都是 O(1)，普通解法一共只遍历链表两遍，所以普通解法的时间复杂度为 O(N)，
 * 因为使用了哈希表来保存原节点与副本节点的对应关系，所以额外空间复杂度为 O(N)。
 *
 * @author Jiajing Li
 * @date 2019-02-19 09:22:37
 */
public class Main {

    public static void main(String[] args) {
        Node head = initNode();
        Node newHead = Rand.copyListWithRand(head);
        int count = 0;
        while (newHead != null) {
            Integer currValue = newHead.value;
            Integer nextValue = (null == newHead.next) ? null : newHead.next.value;
            Integer randValue = (null == newHead.rand) ? null : newHead.rand.value;
            System.out.println("第 " + (++count) + " 个节点的 value = " + currValue + "，next 指向的节点的 value = " + nextValue + "，rand 指向的节点的 value = " + randValue);
            newHead = newHead.next;
        }
    }

    private static Node initNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        node1.rand = node3;
        node2.rand = null;
        node3.rand = node1;

        return node1;
    }

}

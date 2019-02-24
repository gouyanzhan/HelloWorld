package com.siwuxie095.forme.algorithm.chapter2nd.question17th.answer1st;

/**
 * 向有序的环形单链表中插入新节点
 *
 * 题目：
 * 一个环形单链表从头节点 head 开始不降序（即 升序或相等），同时由
 * 最后的节点指回头节点。给定这样一个环形单链表的头节点 head 和一个
 * 整数 num，请生成节点值为 num 的新节点，并插入到这个环形链表中，保
 * 证调整后的链表依然有序。
 *
 * 解答：
 * 直接给出时间复杂度为 O(N)、额外空间复杂度为 O(1) 的方法。具体过
 * 程如下：
 * 1、生成节点值为 num 的新节点，记为 node。
 * 2、如果链表为空，让 node 自己组成环形链表，然后直接返回 node。
 * 3、如果链表不为空，令遍历 prevNode = head，currNode = head.next，
 * 然后令 prevNode 和 currNode 同步移动下去，如果遇到 prevNode 的
 * 节点值小于或等于 num，并且 currNode 的节点值大于或等于 num，说明
 * node 应该在 prevNode 节点和 currNode 节点之间插入，插入 node，
 * 然后返回 head 即可。
 * 4、如果 prevNode 和 currNode 转了一圈，这期间都没有发现步骤 3
 * 所说的情况，说明 node 应该插入到头节点的前面，这种情况之所以会发生，
 * 要么是因为 node 节点的值比链表中每个节点的值都大，要么是因为 node
 * 的值比链表中每个节点的值都小。
 * 5、如果 node 节点的值比链表中每个节点的值都大，返回原来的节点即可；
 * 如果 node 节点的值比链表中每个节点的值都小，应该把 node 作为链表新
 * 的头节点返回。
 *
 * @author Jiajing Li
 * @date 2019-02-24 21:02:51
 */
public class Main {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        int num = 4;
        System.out.println(Insert.insertNum(node1, num).value);
    }

}

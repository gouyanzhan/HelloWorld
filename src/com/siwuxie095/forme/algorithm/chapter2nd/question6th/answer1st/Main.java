package com.siwuxie095.forme.algorithm.chapter2nd.question6th.answer1st;

/**
 * 环形单链表的约瑟夫问题
 *
 * 题目：
 * 据说著名犹太历史学家 Josephus 有过以下故事：在罗马人占领桥塔帕特后，39 个
 * 犹太人与 Josephus 即他的朋友躲到一个洞中，39 个犹太人决定宁愿死也不要被敌
 * 人抓到，于是决定了一个自杀方式，41 个人排成一个圆圈，由第 1 个人开始报数，
 * 报数到 3 的人就自杀，然后再由下一个人重新报 1，报数到 3 的人再自杀，这样依
 * 次下去，直到剩下最后一个人时，那个人就可以自由选择自己的命运。
 * 这就是著名的约瑟夫问题。现在请用单向环形链表描述该结构并呈现整个自杀过程。
 *
 * 输入：一个环形单向链表的头节点 head 和报数的值 m。
 * 输出：最后生存下来的节点，且这个节点自己组成环形单向链表，其他节点都删掉。
 *
 * 解答：
 * 先来看看普通解法是如何实现的，其实非常简单，方法如下：
 * 1、如果链表为空，或链表节点数为 1，或 m 的值小于 1，则不用调整就直接返回。
 * 2、在环形链表中遍历每个节点，不断转圈，不断让每个节点报数。
 * 3、当报数达到 m 时，就删除当前报数的节点。
 * 4、删除节点后，别忘了还要把剩下的节点继续链成环状，继续转圈报数，继续删除。
 * 5、不停的删除，直到环形链表只剩下一个节点，过程结束。
 *
 * 显然，每删除一个节点，都需要遍历 m 次，一共需要删除的节点数为 n-1，所以普
 * 通解法的时间复杂度是 O(n*m)。
 *
 * @author Jiajing Li
 * @date 2019-02-17 21:21:03
 */
public class Main {

    public static void main(String[] args) {
        Node head = initNode();
        Node finalNode = Josephus.josephusKill(head, 3);
        System.out.println("最后剩下的那个节点（且自循环）：" + finalNode.value + " - " + finalNode.next.value);
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
        node5.next = node1;

        return node1;
    }

}

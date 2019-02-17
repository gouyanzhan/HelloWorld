package com.siwuxie095.forme.algorithm.chapter2nd.question4th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-17 18:43:28
 */
public class Reverse {

    /**
     * 反转单向链表
     */
    public static Node reverseList(Node headNode) {
        // 上一个节点
        Node prevNode = null;
        // 下一个节点
        Node nextNode = null;
        while (headNode != null) {
            nextNode = headNode.next;
            headNode.next = prevNode;
            prevNode = headNode;
            headNode = nextNode;
        }
        // 逆转后的头节点
        return prevNode;
    }

    /**
     * 反转双向链表
     */
    public static DoubleNode reverseList(DoubleNode headNode) {
        // 上一个节点
        DoubleNode prevNode = null;
        // 下一个节点
        DoubleNode nextNode = null;
        while (headNode != null) {
            nextNode = headNode.next;
            headNode.next = prevNode;
            headNode.prev = nextNode;
            prevNode = headNode;
            headNode = nextNode;
        }
        // 逆转后的头节点
        return prevNode;
    }

}

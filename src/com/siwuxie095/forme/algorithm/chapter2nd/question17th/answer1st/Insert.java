package com.siwuxie095.forme.algorithm.chapter2nd.question17th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-24 21:03:04
 */
public class Insert {

    public static Node insertNum(Node head, int num) {
        Node node = new Node(num);
        if (null == head) {
            node.next = node;
            return node;
        }
        // 当前节点的上一个节点
        Node prevNode = head;
        // 当前节点
        Node currNode = head.next;
        // 转了一圈，就跳出去
        while (currNode != head) {
            if (prevNode.value <= num && currNode.value >= num) {
                break;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = node;
        node.next = currNode;
        return head.value < num ? head : node;
    }

}

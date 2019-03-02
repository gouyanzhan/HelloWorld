package com.siwuxie095.forme.algorithm.chapter2nd.question9th.answer2nd;

/**
 * @author Jiajing Li
 * @date 2019-02-19 10:22:28
 */
public class Rand {

    public static Node copyListWithRand(Node head) {
        if (null == head) {
            return null;
        }
        /*
         * 复制并链接每一个节点
         */
        Node currNode = head;
        Node nextNode = null;
        while (null != currNode) {
            nextNode = currNode.next;
            // 生成当前节点的副本节点，并链在当前节点后
            currNode.next = new Node(currNode.value);
            currNode.next.next = nextNode;
            currNode = nextNode;
        }
        /*
         * 设置副本节点的 rand 指针
         */
        currNode = head;
        Node copyNode = null;
        while (null != currNode) {
            nextNode = currNode.next.next;
            copyNode = currNode.next;
            copyNode.rand = (null != currNode.rand) ? currNode.rand.next : null;
            currNode = nextNode;
        }
        /*
         * 将副本节点拆分出来形成新链表
         */
        Node res = head.next;
        currNode = head;
        while (null != currNode) {
            nextNode = currNode.next.next;
            copyNode = currNode.next;
            currNode.next = nextNode;
            copyNode.next = (null != nextNode) ? nextNode.next : null;
            currNode = nextNode;
        }
        // 返回新链表的头节点
        return res;
    }

}

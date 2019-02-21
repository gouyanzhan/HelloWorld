package com.siwuxie095.forme.algorithm.chapter2nd.question12th.answer2nd;

/**
 * @author Jiajing Li
 * @date 2019-02-21 12:54:34
 */
public class Reverse {

    public static Node reverseKNode(Node head, int K) {
        if (K < 2) {
            return head;
        }
        // 当前节点
        Node currNode = head;
        // 当前组的第一个节点
        Node start = null;
        // 上一组的最后一个节点
        Node prevNode = null;
        // 既起到了遍历的作用，同时也是下一组的第一个节点
        Node nextNode = null;
        int count = 1;
        while (currNode != null) {
            nextNode = currNode.next;
            if (count == K) {
                start = (null == prevNode) ? head : prevNode.next;
                /*
                 * 只有第一组时，prevNode 才会等于 null，取 currNode，即 第一组的最后一个节点；
                 * 后面 head 就不再变了
                 */
                head = (null == prevNode) ? currNode : head;
                resign(prevNode, start, currNode, nextNode);
                prevNode = start;
                count = 0;
            }
            count++;
            currNode = nextNode;
        }
        return head;
    }

    /**
     * left 即 上一组的最后一个节点，right 即 下一组的第一个节点；
     * start 即 当前组的第一个节点，end 即 当前组的最后一个节点。
     */
    private static void resign(Node left, Node start, Node end, Node right) {
        /*
         * 逆序当前组
         */
        Node prevNode =  start;
        Node currNode = start.next;
        Node nextNode = null;
        while (currNode != right) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        /*
         * 上一组的最后一个节点链上当前组的第一个节点（已经逆序过了）
         */
        if (left != null) {
            left.next = end;
        }
        /*
         * 当前组的最后一个节点链上下一组的第一个节点（已经逆序过了）
         */
        start.next = right;
    }

}

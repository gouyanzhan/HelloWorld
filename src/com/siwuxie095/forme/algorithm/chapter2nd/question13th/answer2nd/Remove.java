package com.siwuxie095.forme.algorithm.chapter2nd.question13th.answer2nd;

/**
 * @author Jiajing Li
 * @date 2019-02-21 23:20:51
 */
public class Remove {

    /**
     * 头节点不会被删除，所以不用返回头节点
     */
    public static void removeRepeatNode(Node head) {
        // 当前节点（用于外层遍历）
        Node currNode = head;
        // 当前节点的下一个节点的上一个节点（一开始是当前节点，进行内层遍历时，就变成了下一个节点的上一个节点）
        Node prevNode = null;
        // 当前节点的下一个节点（用于内层遍历）
        Node nextNode = null;
        /*
         * 外层遍历
         */
        while (null != currNode) {
            prevNode = currNode;
            nextNode = currNode.next;
            /*
             * 内层遍历
             */
            while (null != nextNode) {
                if (currNode.value == nextNode.value) {
                    prevNode.next = nextNode.next;
                } else {
                    prevNode = nextNode;
                }
                nextNode = nextNode.next;
            }
            currNode = currNode.next;
        }
    }

}

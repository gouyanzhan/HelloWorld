package com.siwuxie095.forme.algorithm.chapter2nd.question15th.answer1st;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiajing Li
 * @date 2019-02-22 22:27:17
 */
public class Convert {

    public static Node convert(Node head) {
        Queue<Node> queue = new LinkedList<>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty()) {
            return head;
        }

        // 从队头拿到第一个节点（同时从队列中移除）
        head = queue.poll();
        // 当前节点的上一个节点
        Node prevNode = head;
        prevNode.left = null;
        // 当前节点
        Node currNode = null;
        while (!queue.isEmpty()) {
            currNode = queue.poll();
            prevNode.right = currNode;
            currNode.left = prevNode;
            prevNode = currNode;
        }
        // 最后一个节点的 right 指向 null
        prevNode.right = null;
        return head;
    }

    /**
     * 中序遍历，将遍历结果依次放入队列中
     *
     * 注意：Queue 的 add() 方法，当超出容量限制时，放不进去，会抛异常，
     * 而 offer() 方法，当超出容量限制时，放不进去，不会抛异常，只会返回
     * false。
     *
     * 另外：向队列中添加元素，是从队尾添加的
     */
    private static void inOrderToQueue(Node head, Queue<Node> queue) {
        if (null == head) {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
    }

}

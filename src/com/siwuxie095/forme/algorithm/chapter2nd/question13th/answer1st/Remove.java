package com.siwuxie095.forme.algorithm.chapter2nd.question13th.answer1st;

import java.util.HashSet;

/**
 * @author Jiajing Li
 * @date 2019-02-21 22:59:51
 */
public class Remove {

    /**
     * 头节点不会被删除，所以不用返回头节点
     */
    public static void removeRepeatNode(Node head) {
        if (null == head) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(head.value);
        // 当前节点的上一个节点
        Node prevNode = head;
        // 当前节点
        Node currNode = head.next;
        while (currNode != null) {
            // 包含 即 重复
            if (set.contains(currNode.value)) {
                // 删除当前节点
                prevNode.next = currNode.next;
            } else {
                set.add(currNode.value);
                prevNode = currNode;
            }
            currNode = currNode.next;
        }
    }

}

package com.siwuxie095.forme.algorithm.chapter2nd.question16th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-24 18:06:12
 */
public class Remove {

    public static void removeNodeWired(Node anyNode) {
        if (null == anyNode) {
            return;
        }
        // 任意节点的下一个节点
        Node nextNode = anyNode.next;
        if (null == nextNode) {
            throw new RuntimeException("can not remove last node.");
        }
        // 将下一个节点的值赋值给该任意节点
        anyNode.value = nextNode.value;
        // 将下一个节点删除（其实相当于删除了该任意节点）
        anyNode.next = nextNode.next;
    }

}

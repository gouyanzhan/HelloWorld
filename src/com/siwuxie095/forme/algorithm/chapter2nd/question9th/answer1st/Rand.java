package com.siwuxie095.forme.algorithm.chapter2nd.question9th.answer1st;

import java.util.HashMap;

/**
 * @author Jiajing Li
 * @date 2019-02-19 09:23:10
 */
public class Rand {

    public static Node copyListWithRand(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        /*
         * 第一次遍历，先生成每一个副本节点（此时只生成了 value），并放到哈希表中，与原节点形成对应关系。
         */
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.value));
            curr = curr.next;
        }
        /*
         * 第二次遍历，开始指定每一个副本节点的 next 和 rand 指针所指向的节点。
         */
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).rand = map.get(curr.rand);
            curr = curr.next;
        }
        // 返回新链表的头节点
        return map.get(head);
    }

}

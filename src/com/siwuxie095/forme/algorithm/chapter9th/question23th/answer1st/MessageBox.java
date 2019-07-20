package com.siwuxie095.forme.algorithm.chapter9th.question23th.answer1st;

import java.util.HashMap;

/**
 * @author Jiajing Li
 * @date 2019-07-18 22:15:02
 */
public class MessageBox {

    private HashMap<Integer, Node> headMap;

    private HashMap<Integer, Node> tailMap;

    private int lastPrint;

    public MessageBox() {
        headMap = new HashMap<>();
        tailMap = new HashMap<>();
        lastPrint = 0;
    }

    public void receive(int num) {
        if (num < 1) {
            return;
        }
        Node cur = new Node(num);
        headMap.put(num, cur);
        tailMap.put(num, cur);
        if (tailMap.containsKey(num -1)) {
            tailMap.get(num - 1).next = cur;
            tailMap.remove(num - 1);
            headMap.remove(num);
        }
        if (headMap.containsKey(num + 1)) {
            cur.next = headMap.get(num + 1);
            tailMap.remove(num);
            headMap.remove(num + 1);
        }
        if (headMap.containsKey(lastPrint + 1)) {
            print();
        }
    }

    private void print() {
        Node node = headMap.get(++lastPrint);
        headMap.remove(lastPrint);
        while (node != null) {
            System.out.print(node.num + " ");
            node = node.next;
            lastPrint++;
        }
        tailMap.remove(--lastPrint);
        System.out.println();
    }
}

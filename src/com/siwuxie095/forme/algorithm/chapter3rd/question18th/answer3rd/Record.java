package com.siwuxie095.forme.algorithm.chapter3rd.question18th.answer3rd;

import java.util.HashMap;

/**
 * @author Jiajing Li
 * @date 2019-03-27 22:52:16
 */
public class Record {

    private HashMap<Node, HashMap<Node, Node>> map;

    public Record(Node head) {
        map = new HashMap<>();
        initMap(head);
        setMap(head);
    }

    private void initMap(Node head) {
        if (null == head) {
            return;
        }
        map.put(head, new HashMap<>());
        initMap(head.left);
        initMap(head.right);
    }

    private void setMap(Node head) {
        if (null == head) {
            return;
        }
        headRecord(head.left, head);
        headRecord(head.right, head);
        subRecord(head);
        setMap(head.left);
        setMap(head.right);
    }

    private void headRecord(Node n, Node h) {
        if (null == n) {
            return;
        }
        map.get(n).put(h, h);
        headRecord(n.left, h);
        headRecord(n.right, h);
    }

    private void subRecord(Node head) {
        if (null == head) {
            return;
        }
        preLeft(head.left, head.right, head);
        subRecord(head.left);
        subRecord(head.right);
    }

    private void preLeft(Node l, Node r, Node h) {
        if (null == l) {
            return;
        }
        preRight(l, r, h);
        preLeft(l.left, r, h);
        preLeft(l.right, r, h);
    }

    private void preRight(Node l, Node r, Node h) {
        if (null == r) {
            return;
        }
        map.get(l).put(r, h);
        preRight(l, r.left, h);
        preRight(l, r.right, h);
    }

    public Node query(Node o1, Node o2) {
        if (o1 == o2) {
            return o1;
        }
        if (map.containsKey(o1)) {
            return map.get(o1).get(o2);
        }
        if (map.containsKey(o2)) {
            return map.get(o2).get(o1);
        }
        return null;
    }

}

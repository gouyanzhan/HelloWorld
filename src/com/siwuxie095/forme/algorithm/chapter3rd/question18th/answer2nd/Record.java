package com.siwuxie095.forme.algorithm.chapter3rd.question18th.answer2nd;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Jiajing Li
 * @date 2019-03-27 22:51:56
 */
public class Record {

    private HashMap<Node, Node> map;

    public Record(Node head) {
        map = new HashMap<>();
        if (null != head) {
            map.put(head, null);
        }
        setMap(head);
    }

    private void setMap(Node head) {
        if (null == head) {
            return;
        }
        if (null != head.left) {
            map.put(head.left, head);
        }
        if (null != head.right) {
            map.put(head.right, head);
        }
        setMap(head.left);
        setMap(head.right);
    }

    public Node query(Node o1, Node o2) {
        HashSet<Node> path = new HashSet<>();
        while (map.containsKey(o1)) {
            path.add(o1);
            o1 = map.get(o1);
        }
        while (!path.contains(o2)) {
            o2 = map.get(o2);
        }
        return o2;
    }
}

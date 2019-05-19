package com.siwuxie095.forme.algorithm.chapter3rd.question19th.answer1st;

import java.util.HashMap;

/**
 * @author Jiajing Li
 * @date 2019-03-28 18:43:38
 */
public class DisjointSets {

    public HashMap<Node, Node> fatherMap;

    public HashMap<Node, Integer> rankMap;

    public DisjointSets() {
        fatherMap = new HashMap<>();
        rankMap = new HashMap<>();
    }

    public void makeSets(Node head) {
        fatherMap.clear();
        rankMap.clear();
        preOrderMake(head);
    }

    private void preOrderMake(Node head) {
        if (null == head) {
            return;
        }
        fatherMap.put(head, head);
        rankMap.put(head, 0);
        preOrderMake(head.left);
        preOrderMake(head.right);
    }

    public Node findFather(Node n) {
        Node father = fatherMap.get(n);
        if (father != n) {
            father = findFather(father);
        }
        fatherMap.put(n, father);
        return father;
    }

    public void union(Node a, Node b) {
        if (null == a || null == b) {
            return;
        }
        Node aFather = findFather(a);
        Node bFather = findFather(b);
        if (aFather != bFather) {
            int aFatherRank = rankMap.get(aFather);
            int bFatherRank = rankMap.get(bFather);
            if (aFatherRank < bFatherRank) {
                fatherMap.put(aFather, bFather);
            } else if (aFatherRank > bFatherRank) {
                fatherMap.put(bFather, aFather);
            } else {
                fatherMap.put(bFather, aFather);
                rankMap.put(aFather, aFatherRank + 1);
            }
        }
    }

}

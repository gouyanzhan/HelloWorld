package com.siwuxie095.forme.algorithm.chapter3rd.question19th.answer1st;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Jiajing Li
 * @date 2019-03-28 18:43:54
 */
public class Tarjan {

    private HashMap<Node, LinkedList<Node>> queryMap;
    private HashMap<Node, LinkedList<Integer>> indexMap;
    private HashMap<Node, Node> ancestorMap;
    private DisjointSets sets;

    public Tarjan() {
        queryMap = new HashMap<>();
        indexMap = new HashMap<>();
        ancestorMap = new HashMap<>();
        sets = new DisjointSets();
    }

    public Node[] query(Node head, Query[] queryArr) {
        Node[] answerArr = new Node[queryArr.length];
        setQueryArr(queryArr, answerArr);
        sets.makeSets(head);
        setAnswerArr(head, answerArr);
        return answerArr;
    }

    private void setQueryArr(Query[] queryArr, Node[] answerArr) {
        Node o1 = null;
        Node o2 = null;
        for (int i = 0; i != answerArr.length; ++i) {
            o1 = queryArr[i].o1;
            o2 = queryArr[i].o2;
            if (o1 == o2 || null == o1 || null == o2) {
                answerArr[i] = (null != o1) ? o1 : o2;
            } else {
                if (!queryMap.containsKey(o1)) {
                    queryMap.put(o1, new LinkedList<>());
                    indexMap.put(o1, new LinkedList<>());
                }
                if (!queryMap.containsKey(o2)) {
                    queryMap.put(o2, new LinkedList<>());
                    indexMap.put(o2, new LinkedList<>());
                }
                queryMap.get(o1).add(o2);
                indexMap.get(o1).add(i);
                queryMap.get(o2).add(o1);
                indexMap.get(o2).add(i);
            }
        }
    }

    private void setAnswerArr(Node head, Node[] answerArr) {
        if (null == head) {
            return;
        }
        setAnswerArr(head.left, answerArr);
        sets.union(head.left, head);
        ancestorMap.put(sets.findFather(head), head);
        setAnswerArr(head.right, answerArr);
        sets.union(head.right, head);
        ancestorMap.put(sets.findFather(head), head);
        LinkedList<Node> nList = queryMap.get(head);
        LinkedList<Integer> iList = indexMap.get(head);
        Node node = null;
        Node nodeFather = null;
        int index = 0;
        while (null != nList && !nList.isEmpty()) {
            node = nList.poll();
            index = iList.poll();
            nodeFather = sets.findFather(node);
            if (ancestorMap.containsKey(nodeFather)) {
                answerArr[index] = ancestorMap.get(nodeFather);
            }
        }
    }

}

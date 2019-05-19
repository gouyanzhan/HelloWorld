package com.siwuxie095.forme.algorithm.chapter3rd.question23th.answer1st;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2019-03-31 14:22:49
 */
public class Generate {

    public static int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < i + 1; ++j) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }

    public static List<Node> generateTrees(int n) {
        return generate(1, n);
    }

    private static List<Node> generate(int start, int end) {
        List<Node> resList = new LinkedList<>();
        if (start > end) {
            resList.add(null);
        }
        Node head = null;
        for (int i = start; i < end + 1; ++i) {
            head = new Node(i);
            List<Node> lSubList = generate(start, i - 1);
            List<Node> rSubList = generate(i + 1, end);
            for (Node l : lSubList) {
                for (Node r : rSubList) {
                    head.left = l;
                    head.right = r;
                    resList.add(cloneTree(head));
                }
            }
        }
        return resList;
    }

    private static Node cloneTree(Node head) {
        if (null == head) {
            return null;
        }
        Node res = new Node(head.value);
        res.left = cloneTree(head.left);
        res.right = cloneTree(head.right);
        return res;
    }

}

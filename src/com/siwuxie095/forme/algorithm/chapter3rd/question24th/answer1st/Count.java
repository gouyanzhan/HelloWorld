package com.siwuxie095.forme.algorithm.chapter3rd.question24th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-31 15:02:41
 */
public class Count {

    public static int nodeNum(Node head) {
        if (null == head) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    private static int bs(Node node, int level, int height) {
        if (level == height) {
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == height) {
            return (1 << (height - level)) + bs(node.right, level + 1, height);
        } else {
            return (1 << (height - level - 1)) + bs(node.left, level + 1, height);
        }
    }

    private static int mostLeftLevel(Node node, int level) {
        while (null != node) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

}

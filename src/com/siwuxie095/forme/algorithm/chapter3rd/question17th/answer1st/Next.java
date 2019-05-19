package com.siwuxie095.forme.algorithm.chapter3rd.question17th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-27 09:08:51
 */
public class Next {

    public static Node getNextNode(Node node) {
        if (null == node) {
            return null;
        }
        if (null != node.right) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (null != parent && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node getLeftMost(Node node) {
        if (null == node) {
            return null;
        }
        while (null != node.left) {
            node = node.left;
        }
        return node;
    }

}

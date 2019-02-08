package com.siwuxie095.forme.algorithm.chapter1st.question8th.answer1st;

/**
 * 二叉树节点
 *
 * @author Jiajing Li
 * @date 2019-02-08 17:20:02
 */
public class Node {

    public int value;

    public Node left;

    public Node right;

    public Node(int data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

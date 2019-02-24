package com.siwuxie095.forme.algorithm.chapter2nd.question15th.answer2nd;

/**
 * @author Jiajing Li
 * @date 2019-02-24 10:53:58
 */
public class Node {

    public int value;

    /**
     * 树的左孩子，即 left 指针，相当于双向链表的上一个节点，即 prev 指针
     */
    public Node left;

    /**
     * 树的右孩子，即 right 指针，相当于双向链表的下一个节点，即 next 指针
     */
    public Node right;

    public Node(int data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", right=" + right +
                '}';
    }

}

package com.siwuxie095.forme.algorithm.chapter2nd.question12th.answer2nd;

/**
 * @author Jiajing Li
 * @date 2019-02-21 12:54:26
 */
public class Node {

    public int value;

    public Node next;

    public Node(int data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

}

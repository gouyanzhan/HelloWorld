package com.siwuxie095.forme.algorithm.chapter2nd.question8th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-18 19:06:14
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

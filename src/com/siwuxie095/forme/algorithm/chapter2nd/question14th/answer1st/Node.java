package com.siwuxie095.forme.algorithm.chapter2nd.question14th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-22 21:54:44
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

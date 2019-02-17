package com.siwuxie095.forme.algorithm.chapter2nd.question4th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-17 18:43:00
 */
public class Node {

    public int value;

    /**
     * 下一个节点
     */
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

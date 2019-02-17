package com.siwuxie095.forme.algorithm.chapter2nd.question4th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-17 18:43:19
 */
public class DoubleNode {

    public int value;

    /**
     * 上一个节点
     */
    public DoubleNode prev;

    /**
     * 下一个节点
     */
    public DoubleNode next;

    public DoubleNode(int data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

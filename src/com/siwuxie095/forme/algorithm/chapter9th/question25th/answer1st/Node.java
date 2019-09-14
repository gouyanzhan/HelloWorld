package com.siwuxie095.forme.algorithm.chapter9th.question25th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-07-21 23:23:49
 */
public class Node<K> {

    public K value;

    public Node<K> left;

    public Node<K> right;

    public Node<K> parent;

    public Node(K data) {
        this.value = data;
    }
}

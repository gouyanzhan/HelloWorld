package com.siwuxie095.forme.algorithm.chapter9th.question24th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-07-20 21:41:07
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

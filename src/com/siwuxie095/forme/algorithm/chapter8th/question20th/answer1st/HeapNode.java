package com.siwuxie095.forme.algorithm.chapter8th.question20th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-09 21:38:08
 */
public class HeapNode {
    /**
     * 值是什么
     */
    public int value;
    /**
     * 来自哪个数组
     */
    public int arrNum;
    /**
     * 来自数组的哪个位置
     */
    public int index;

    public HeapNode(int value, int arrNum, int index) {
        this.value = value;
        this.arrNum = arrNum;
        this.index = index;
    }
}

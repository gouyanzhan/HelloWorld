package com.siwuxie095.forme.algorithm.chapter1st.question8th.answer1st;

/**
 * 构造数组的 MaxTree
 *
 * 题目：
 * 一个数组的 MaxTree 的定义如下：
 * 1、数组必须没有重复元素。
 * 2、MaxTree 是一棵二叉树，数组的每一个值对应一个二叉树节点。
 * 3、包括 MaxTree 树在内，且在其中的每一棵子树上，值最大的节点都是树的头。
 *
 * 给定一个没有重复元素的数组 arr，写出生成这个数组的 MaxTree 的函数，要求
 * 如果数组长度为 N，则时间复杂度为 O(N)、额外空间复杂度为 O(N)。
 *
 * 解答：
 * 以下列原则来建立这棵树：
 * 1、每一个数的父节点是它左边第一个比它大的数和它右边第一个比它大的数中，较小
 * 的那个。
 * 2、如果一个数左边没有比它大的数，右边也没有。也就是说这个数是整个数组的最大
 * 值，那么这个数是 MaxTree 的头节点。
 *
 * 【二叉树，即 每个节点最多有两个子树的树结构（一个父节点只能有两个子节点）】
 *
 * @author Jiajing Li
 * @date 2019-02-08 17:19:52
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        Node head = MaxTree.getMaxTree(arr);
        System.out.println(head);
    }

}

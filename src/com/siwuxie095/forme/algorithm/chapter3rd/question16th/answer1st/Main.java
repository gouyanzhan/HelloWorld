package com.siwuxie095.forme.algorithm.chapter3rd.question16th.answer1st;

/**
 * 通过有序数组生成平衡二叉树
 *
 * 题目：
 * 给定一个有序数组 sortArr，已知其中没有重复值，用这个有序数组生成一棵平衡搜索二叉树，
 * 并且该搜索二叉树中序遍历的结果与 sortArr 一致。
 *
 * 解答：
 * 本题的递归过程比较简单，用有序数组中最中间的数生成搜索二叉树的头节点，然后用这个数左
 * 边的数生成左子树，用右边的数生成右子树即可。
 *
 *
 * PS：平衡二叉树，也称平衡二叉搜索树 或 平衡搜索二叉树，也称 AVL 树，是一种特殊的搜索
 * 二叉树（即 在搜索二叉树上延伸出来的），它可以是：
 * （1）一棵空树。
 * （2）一棵非空树，但要求：
 * 1）左子树和右子树但深度（高度）之差的绝对值不超过 1。
 * 2）左子树和右子树都是平衡二叉树。
 *
 * @author Jiajing Li
 * @date 2019-03-26 22:58:23
 */
public class Main {

    public static void main(String[] args) {
        int[] sortArr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node head = Generate.generateTree(sortArr);
        System.out.println(head.value);
    }

}

package com.siwuxie095.forme.algorithm.chapter3rd.question15th.answer1st;

/**
 * 判断一棵二叉树是否为搜索二叉树和完全二叉树
 *
 * 题目：
 * 给定一个二叉树的头节点 head，已知其中没有重复值的节点，实现两个函数分别判断这棵二叉树
 * 是否是搜索二叉树和完全二叉树。
 *
 * 解答：
 * 判断一棵二叉树是否是搜索二叉树，只要改写一个二叉树中序遍历，在遍历的过程中看节点值是否
 * 都是递增的即可。这里改写的是 Morris 中序遍历，所以时间复杂度为 O(N)，额外空间复杂度
 * 为 O(1)。需要注意的是，Morris 遍历分调整二叉树结构和恢复二叉树结构两个阶段，所以，当
 * 发现节点值降序时，不能直接返回 false，这么做可能会跳过恢复阶段，从而破坏二叉树结构。
 *
 * 判断一棵二叉树是否是完全二叉树，依据以下标准会使判断过程变得简单且易实现：
 * 1、按层遍历二叉树，从每层的左边向右边依次遍历所有的节点。
 * 2、如果当前节点有右孩子，但没有左孩子，直接返回 false。
 * 3、如果当前节点并不是左右孩子全有，那之后的节点必须都为叶节点，否则返回 false。
 * 4、遍历过程中如果不返回 false，遍历结束后返回 true。
 *
 *
 * PS：搜索二叉树，也称 二叉搜索树、二叉查找树、二叉排序树，它可以是：
 * （1）一棵空树。
 * （2）一棵非空树，但要求：
 * 1）左子树不空时，左子树的所有节点值均小于根节点的值。
 * 2）右子树不空时，右子树的所有节点值均大于根节点的值。
 *
 * 【显然，搜索二叉树的左右子树，也都是搜索二叉树】
 *
 * PS：完全二叉树，即 若二叉树的深度为 h，除第 h 层外，其它各层的节点数都达到最大个数，
 * 第 h 层的所有节点都连续集中在最左边。
 *
 * @author Jiajing Li
 * @date 2019-03-26 21:47:43
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        System.out.println(Judge.isBST(head));
        System.out.println(Judge.isCBT(head));
    }

    private static Node initTree() {
        Node node1 = new Node(10);
        Node node2 = new Node(5);
        Node node3 = new Node(15);
        Node node4 = new Node(1);
        Node node5 = new Node(8);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        return node1;
    }

}

package com.siwuxie095.forme.algorithm.chapter3rd.question18th.answer1st;

/**
 * 在二叉树中找到两个节点的最近公共祖先
 *
 * 题目：
 * 给定一棵二叉树的头节点 head，以及这棵树中的两个节点 o1 和 o2，请返回
 * o1 和 o2 的最近公共祖先节点。
 *
 * 一棵二叉树如下：
 *               1
 *          /        \
 *      2               3
 *   /     \          /    \
 * 4        5       6       7
 *                        /
 *                      8
 *
 * 4 和 5 的最近公共祖先节点为 2； 5 和 2 的最近公共祖先节点为 2；
 * 6 和 8 的最近公共祖先节点为 3； 5 和 8 的最近工作祖先节点为 1；
 *
 * 进阶：如果查询两个节点的最近公共祖先的操作十分频繁，想法让单条查询时间
 * 减少。
 *
 * 解答：
 * 先来解决原问题，后序遍历二叉树，假设遍历到的当前节点为 curr。因为是后序遍历，
 * 所以先处理 curr 的两棵子树。假设处理左子树时返回节点为 left，处理右子树时返
 * 回节点为 right。
 * 1、如果发现 curr 等于 null，或者 o1、o2，则返回 curr。
 * 2、如果 left 和 right 都为空，说明 curr 整棵子树上没有发现过 o1 或 o2，
 * 返回 null。
 * 3、如果 left 和 right 都不为空，说明左子树上发现过 o1 或 o2，右子树上也
 * 发现过 o2 或 o1，说明 o1 向上与 o2 向上的过程中，首次在 curr 相遇，返回
 * curr。
 * 4、如果 left 和 right 有一个为空，一个不为空，假设不为空的那个记为 node，
 * 此时 node 到底是什么？有两种可能，要么 node 是 o1 或 o2 中的一个，要么
 * node 已经是 o1 和 o2 的最近公共祖先。不管哪种情况，直接返回 node 即可。
 *
 * @author Jiajing Li
 * @date 2019-03-27 22:11:30
 */
public class Main {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node7.left = node8;

        System.out.println( Ancestor.lowestAncestor(node1, node4, node5).value);
        System.out.println( Ancestor.lowestAncestor(node1, node5, node8).value);
    }

}

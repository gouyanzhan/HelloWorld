package com.siwuxie095.forme.algorithm.chapter3rd.question18th.answer3rd;

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
 * 再进阶：给定二叉树的头节点 head，同时给定所有想要进行的查询。二叉树的
 * 节点数量为 N，查询条数为 M，请在时间复杂度为 O(N+M)内返回所有查询的
 * 结果。
 *
 * 解答：
 * 进阶问题其实是先花较大的力气建立一种记录，以后执行每次查询时就可以完全根据记录进行查询。
 * 记录的方式可以有很多种，这里提供两种记录结构以供参考，两种记录各有优缺点。
 *
 * 结构二：直接建立任意两个节点之间的最近公共祖先记录，便于以后查询时直接查。
 *
 * 建立记录的具体过程如下：
 * 1、对于二叉树中的每棵子树（一共 N 棵）都进行步骤 2。
 * 2、假设子树的头节点为 h，h 所有的后代节点和 h 节点的最近公共祖先都是 h，记录下来。h
 * 左子树的每个节点和 h 右子树的每个节点的最近公共祖先都是 h，记录下来。
 *
 * 为了保证记录不重复，设计一种好的实现方式是这种结构实现的重点。
 *
 * 如果二叉树的节点数为 N，想要记录每两个节点之间的信息，信息的条数为 ((N-1) * N) / 2。
 * 所以建立结构二的过程的额外空间复杂度为 O(N^2)，时间复杂度为 O(N^2)，单次查询的时间复
 * 杂度为 O(1)。
 *
 * @author Jiajing Li
 * @date 2019-03-27 22:52:03
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

        Record record = new Record(node1);
        System.out.println(record.query(node4, node5).value);
        System.out.println(record.query(node5, node8).value);
    }

}

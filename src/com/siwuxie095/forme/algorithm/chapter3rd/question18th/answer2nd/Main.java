package com.siwuxie095.forme.algorithm.chapter3rd.question18th.answer2nd;

import com.siwuxie095.forme.algorithm.chapter3rd.question18th.answer1st.Ancestor;

import java.util.HashMap;

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
 * 进阶问题其实是先花较大的力气建立一种记录，以后执行每次查询时就可以完全根据记录进行查询。
 * 记录的方式可以有很多种，这里提供两种记录结构以供参考，两种记录各有优缺点。
 *
 * 结构一：建立二叉树中每个节点对应的父节点信息，是一张哈希表（HashMap）。
 *
 * 对于本题而言，哈希表中的信息如下：
 *      key         value
 *      1           null
 *      2           1
 *      3           1
 *      4           2
 *      5           2
 *      6           3
 *      7           3
 *      8           7
 * key 代表二叉树中的一个节点，value 代表其对应的父节点。只用遍历一次二叉树，这张表就可以
 * 创建好，以后每次查询都可以根据这张哈希表进行。
 *
 * 假设想查 4 和 8 的最近公共祖先节点，方法是使用如上的哈希表（HashMap）,记为 A，把包括
 * 4 在内的所有 4 的祖先节点放进另一个哈希表（HashSet）中，记为 B，所以 B = {4，2，1}。
 * 然后通过 A，从 8 开始逐渐往上移动到头节点。首先是 8，发现不在 B 中；然后是 7，发现也不
 * 在 B 中；接下来是 3，依然不在 B 中；最后是 1，发现在 B 中。那么 1 就是 4 和 8 的最近
 * 公共祖先。只要在移动过程中发现某个节点在 B 中，这个节点就是要求的公共祖先节点。
 *
 * 很明显，结构一建立记录的过程时间复杂度为 O(N)、额外空间复杂度为 O(N)。查询操作时，时间
 * 复杂度为 O(h)，h 为二叉树的高度。
 *
 * @author Jiajing Li
 * @date 2019-03-27 22:51:38
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

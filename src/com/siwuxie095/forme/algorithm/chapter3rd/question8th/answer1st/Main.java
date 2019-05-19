package com.siwuxie095.forme.algorithm.chapter3rd.question8th.answer1st;

/**
 * 找到二叉树中符合搜索二叉树条件的最大拓扑结构
 *
 * 题目：
 * 给定一棵二叉树的头节点 head，已知所有节点的值都不一样，返回其中最大的且符合搜索二叉树条件的
 * 最大拓扑结构的大小。
 *
 * 一棵二叉树如下：
 *                   6
 *           /               \
 *      1                       12
 *   /     \                /         \
 * 0        3           10              13
 *                    /    \          /    \
 *                  4       14      20      16
 *                /  \     /  \
 *              2     5  11    15
 *
 * 其中最大的且符合搜索二叉树条件的最大拓扑结构如下：
 *                 6
 *          /              \
 *      1                     12
 *   /     \               /      \
 * 0        3           10          13
 *                                      \
 *                                        16
 * 这个拓扑结构节点数为 8，所以返回 8。
 *
 * 解答：
 * 方法一：二叉树的节点数为 N，时间复杂度为 O(N^2) 的方法。
 * 首先来看这样一个问题，以节点 h 为头的树中，在拓扑结构中也必须以 h 为头的情况下，怎么找到符合
 * 搜索二叉树条件的最大结构？这个问题有一种比较容易理解的解法，即 先考察 h 的孩子节点，根据孩子
 * 节点的值从 h 开始按照二叉搜索的方式移动，如果最后能移动到同一个孩子节点上，说明这个孩子节点
 * 可以作为这个拓扑的一部分，并继续考察这个孩子节点的孩子节点，一直延伸下去。
 *
 * 下面以本例说明：假设在以 12 这个节点为头的子树中，要求拓扑结构也必须以 12 为头，如何找到最多
 * 的节点，并且整个拓扑结构是符合二叉树条件的？
 * （1）考察节点 12。将 12 的左右孩子加入考察队列，即 {10，13}。
 * （2）考察节点 10。10 小于 12，应该在 12 的左边，于是顺着 12 的左边能找到 10，所以 10 可以
 * 加入拓扑结构，同时将 10 的左右孩子加入考察队列，即 {13，4，14}。
 * （3）考察节点 13。13 大于 12，应该在 12 的右边，于是顺着 12 的右边能找到 13，所以 13 可以
 * 加入拓扑结构，同时将 13 的左右孩子加入考察队列，即 {4，14，20，16}。
 * （4）考察节点 4。4 小于 12，应该在 12 的左边，4 小于 10，应该在 10 的左边，于是顺着 12 的
 * 左边，再顺着 10 的左边能找到 4，所以 4 可以加入拓扑结构，同时将 4 的左右孩子加入考察队列，即
 * {14，20，16，2，5}。
 * （5）考察节点 14。12 大于 12，应该在 12 的右边，但是顺着 12 的右边并找不到 14，所以 14 不
 * 可以加入拓扑结构。此时，考察队列，即 {20，16，2，5}。
 * （6）考察节点 20。20 大于 12，应该在 12 的右边，但是顺着 12 的右边并找不到 20，所以 20 不
 * 可以加入拓扑结构。此时，考察队列，即 {16，2，5}。
 * （7）... ... 以此类推。显然，16、2、5 都能加入拓扑结构。
 * 即 找到了必须以 12 为头，且整个拓扑结构是符合搜索二叉树条件的最大结构，这个结构的节点数是 7。
 *
 * 也就是说，根据一个节点值的大小，判断它是在 h 的左边还是右边，顺着该方向，如果能移动到该节点，
 * 即 该节点可以作为以 h 为头的拓扑的一部分。
 *
 * 这就解决了以 h 为头的树中，在拓扑结构也必须以 h 为头的情况下，怎么找到符合搜索二叉树条件的最大
 * 结构的问题。接下来只要遍历所有二叉树的节点，并以每个节点为头的子树中都求一遍其中的最大拓扑结构，
 * 其中最大的那个就是想要的结构，返回它的大小即可。
 *
 * 由于把所有的子树（N个）都找了一次最大拓扑，每找一次所考察的节点数都可能是 O(N) 个，所以时间复
 * 杂度为 O(N^2)。
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
 * 拓扑结构，即 点、线相连形成的结构
 *
 * @author Jiajing Li
 * @date 2019-03-21 22:32:19
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        System.out.println(MaxTopo.bstTopoSize(head));
    }

    public static Node initTree() {
        Node node1 = new Node(6);
        Node node2 = new Node(1);
        Node node3 = new Node(12);
        Node node4 = new Node(0);
        Node node5 = new Node(3);
        Node node6 = new Node(10);
        Node node7 = new Node(13);
        Node node8 = new Node(4);
        Node node9 = new Node(14);
        Node node10 = new Node(20);
        Node node11 = new Node(16);
        Node node12 = new Node(2);
        Node node13 = new Node(5);
        Node node14 = new Node(11);
        Node node15 = new Node(15);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node6.left = node8;
        node6.right = node9;

        node7.left = node10;
        node7.right = node11;

        node8.left = node12;
        node8.right = node13;

        node9.left = node14;
        node9.right = node15;

        return node1;
    }

}

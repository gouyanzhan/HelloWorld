package com.siwuxie095.forme.algorithm.chapter3rd.question8th.answer2nd;

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
 * 方法二：二叉树的节点数为 N，时间复杂度最好为 O(N)，最差为 O(N*logN) 的方法。
 * 先来说一个对方法二非常重要的概念：拓扑贡献记录。下面以本例说明：对于以 10 为头的子树，本身就
 * 是一棵搜索二叉树，那么整棵子树都可以作为以 10 为头的符合搜索二叉树条件的拓扑结构。如果对这个
 * 拓扑结构建立贡献记录，就是下面的样子。
 *                    10（3，3）
 *                  /           \
 *          4（1，1）              14（1，1）
 *         /       \              /      \
 *   2（0，0）    5（0，0）  11（0，0）     15（0，0）
 * 每个节点的旁边都有被括号括起来的两个值，称其为当前节点的左右子树对当前节点的拓扑贡献记录。第
 * 一个值代表当前节点的左子树可以为当前节点的拓扑贡献几个节点，第二个值代表当前节点的右子树可以
 * 为当前节点的拓扑贡献几个节点。
 *
 * 整个方法的核心就是如果分别得到来 h 左右两个孩子为头的拓扑贡献记录，可以快速得到以 h 为头的
 * 拓扑贡献记录。
 *
 * 当得到以 h 为头的拓扑贡献记录后，相当于求出了以 h 为头的最大拓扑的大小。方法二正是不断利用
 * 这种方法，从小树的记录整合成大叔的记录，从而求出整棵树中符合搜索二叉树的最大拓扑结构的大小。
 * 所以整个过程大体来说是利用二叉树的后序遍历，对每个节点来说，先生成其左孩的记录，然后是右孩子
 * 的记录，接着把两组记录修改成以这个节点为头的拓扑贡献记录，并找出所有节点的最大拓扑大小中最大
 * 的那个。
 *
 * 二叉树越趋近于棒状结构，方法二的时间复杂度越低，也越趋近于 O(N)；二叉树越趋近于满二叉树结构，
 * 方法二的时间复杂度越高，但最差也仅仅是 O(N*logN)。
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
 * @date 2019-03-21 22:39:35
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

package com.siwuxie095.forme.algorithm.chapter3rd.question7th.answer1st;

/**
 * 找到二叉树中的最大搜索二叉子树
 *
 * 题目：
 * 给定一棵二叉树的头节点 head，已知其中所有节点的值都不一样，找到含有节点最多的搜索二叉树，
 * 并返回这棵子树的头节点。
 *
 * 一棵二叉树如下：
 *               6
 *          /          \
 *      1                 12
 *
 *   /     \          /        \
 * 0        3       10          13
 *                 /   \       /   \
 *               4      14    20    16
 *              / \     /  \
 *             2   5  11   15
 *
 * 其中最大的搜索二叉子树如下：
 *           10
 *        /     \
 *      4       14
 *     / \      /  \
 *   2   5    11    15
 *
 * 要求：如果节点数为 N，二叉树的高度为 h，要求时间复杂度为 O(N)，额外空间复杂度为 O(h)。
 *
 * 解答：
 * 以节点 node 为头的树中，最大的搜索二叉子树只可能来自以下两种情况。
 * （1）第一种：如果来自 node 左子树上的最大搜索二叉子树是以 node.left 为头的；来自 node
 * 右子树上的最大搜索二叉子树是以 node.right 为头的；node 左子树上的最大搜索二叉子树的
 * 最大值小于 node.value；node 右子树上的最大搜索二叉子树的最小值大于 node.value，那
 * 么以 node 为头的整棵树都是搜索二叉树。
 * （2）第二种：如果不满足第一种情况，说明以节点 node 为头的树整体不能连成搜索二叉树。这
 * 种情况下，以 node 为头的树上的最大搜索搜索二叉子树是来自 node 的左子树上的最大搜索二
 * 叉子树和来自 node 的右子树上的最大搜索二叉子树之间，节点数较多的那个。
 *
 * 通过以上分析，求解的具体过程如下：
 * 1、整体过程是二叉树的后序遍历。
 * 2、遍历到当前节点记为 curr 时，先遍历 curr 的左子树收集 4 个信息，分别是左子树上最大
 * 搜索二叉子树的头节点（leftBST）、节点数（leftSize）、最小值（leftMin）和最大值（leftMax）。
 * 再遍历 curr 的右子树收集 4 个信息，分别是右子树上最大搜索二叉子树的头节点（rightBST）、
 * 节点数（rightSize）、最小值（rightMin）和最大值（rightMax）。
 * 3、根据步骤 2 搜集到的信息，判断是否满足第一种情况，如果满足第一种情况，就返回 curr，
 * 如果满足第二种情况，就返回 leftBST 和 rightBST 中较大的一个。
 * 4、可以使用全局变量的方式实现步骤 2 中收集节点数、最小值和最大值的问题。
 *
 * @author Jiajing Li
 * @date 2019-03-21 12:41:16
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        Node newHead = SubBST.biggestSubBST(head);
        Integer newHeadValue = newHead.value;
        Integer leftValue = (null == newHead.left) ? null : newHead.left.value;
        Integer rightValue = (null == newHead.right) ? null : newHead.right.value;
        System.out.println(newHeadValue + " - " + leftValue + " - " + rightValue);
    }

    private static Node initTree() {
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

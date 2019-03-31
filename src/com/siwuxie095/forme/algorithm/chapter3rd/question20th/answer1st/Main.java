package com.siwuxie095.forme.algorithm.chapter3rd.question20th.answer1st;

/**
 * 二叉树节点间的最大距离问题
 *
 * 题目：
 * 从二叉树的节点 A 出发，可以向上或向下走，但沿途的节点只能经过一次，当到达节点 B 时，
 * 路径上的节点数叫作 A 到 B 的距离。给定一棵二叉树的头节点，求整棵树上节点间的最大距离。
 *
 * 一棵二叉树如下：
 *                   1
 *              /         \
 *          2               3
 *        /    \          /   \
 *      4       5       6       7
 *
 * 节点 4 和节点 2 的距离为 2，节点 5 和节点 6 的距离为 5。
 *
 * 要求：如果二叉树的节点数为 N，时间复杂度为 O(N)。
 *
 * 解答：
 * 一个以 h 为头的树上，最大距离只可能来自以下三种情况：
 * （1）h 左子树上的最大距离。
 * （2）h 右子树上的最大距离。
 * （3）h 左子树上离 h.left 最远的距离 + 1 + h 右子树上离 h.right 最远的距离。
 * （注意：这里的 1 就是 h 节点本身）
 * 三个值中最大的那个就是整棵 h 树中最远的距离。
 *
 * 根据如上分析，设计解法的过程如下：
 * 1、整个过程为后序遍历，在二叉树的每棵子树上执行步骤 2。
 * 2、假设子树头为 h，处理 h 左子树，得到两个信息，左子树上的最大距离记为 lMax，左子树
 * 上距离 h 左孩子的最远距离记为 maxFromLeft。同理，处理 h 右子树得到右子树上的最大距
 * 离记为 rMax，右子树上距离 h 右孩子的最远距离记为 maxFromRight。那么 maxFromLeft
 * + 1 + maxFromRight 就是跨 h 节点情况下的最大距离，再与 lMax 和 rMax 比较，把三
 * 者中的最值作为 h 树上的最大距离返回。maxFromLeft + 1 就是 h 左子树上离 h 最远的点
 * 到 h 的距离，maxFromRight + 1 就是 h 右子树上离 h 最远的点到 h 的距离，选两者中最
 * 大的一个作为 h 树上距离 h 最远的距离返回。如何返回两个值？一个正常返回，另一个用全局变
 * 量表示，即 recordArr[0]。
 *
 * @author Jiajing Li
 * @date 2019-03-31 10:58:23
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        System.out.println(Distance.maxDistance(head));;
    }

    private static Node initTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        return node1;
    }

}

package com.siwuxie095.forme.algorithm.chapter2nd.question15th.answer1st;

/**
 * 将搜索二叉树转换成双向链表
 *
 * 题目：
 * 对二叉树的节点来说，有本身的值域，有指向左孩子和右孩子的两个指针，即 left 和 right；对双向链表
 * 的节点来说，有本身的值域，有指向上一个节点和下一个节点的两个指针，即 prev 和 next。在结构上，两
 * 钟结构有相似性，现在有一棵搜索二叉树，请将其转换为一个有序的双向链表。
 *
 * 一棵搜索二叉树如下所示：
 *              6
 *          /     \
 *        4         7
 *      /  \          \
 *    2     5           9
 *   / \             /
 * 1    3           8
 *
 * 这棵搜索二叉树转换后的双向链表从头到尾依次是 1 ～ 9。对每一个节点来说，原来的 right 指针等价于
 * 转换后的 next 指针，原来的 left 指针等价于转换后的 prev 指针，最后返回转换后的双向链表头节点。
 *
 * PS：搜索二叉树，也称 二叉搜索树、二叉查找树、二叉排序树，它可以是：
 * （1）一棵空树。
 * （2）一棵非空树，但要求：
 * 1）左子树不空时，左子树的所有节点值均小于根节点的值。
 * 2）右子树不空时，右子树的所有节点值均大于根节点的值。
 *
 * 【显然，搜索二叉树的左右子树，也都是搜索二叉树】
 *
 * 解答：
 * 方法一：用队列等容器收集二叉树中序遍历结果的方法。具体过程如下：
 * 1、生成一个队列，记为 queue，按照二叉树中序遍历的顺序，将每个节点放入 queue 中。
 * 2、从 queue 中依次弹出节点，并按照弹出的顺序重连所有的节点即可。
 *
 * 此法的时间复杂度为 O(N)，额外空间复杂度为 O(N)。
 *
 * PS：关于搜索二叉树的前序遍历、中序遍历、后序遍历都属于深度优先遍历：
 * （1）前序遍历：根 - 左 - 右；
 * （2）中序遍历：左 - 根 - 右；
 * （3）后序遍历：左 - 右 - 根；
 *
 * @author Jiajing Li
 * @date 2019-02-22 22:26:43
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        Node newHead = Convert.convert(head);
        System.out.println(newHead);
    }

    private static Node initTree() {
        Node node6 = new Node(6);
        Node node4 = new Node(4);
        Node node7 = new Node(7);
        node6.left = node4;
        node6.right = node7;

        Node node2 = new Node(2);
        Node node5 = new Node(5);
        node4.left = node2;
        node4.right = node5;

        Node node1 = new Node(1);
        Node node3 = new Node(3);
        node2.left = node1;
        node2.right = node3;

        Node node9 = new Node(9);
        node7.right = node9;

        Node node8 = new Node(8);
        node9.left = node8;

        return node6;
    }

}

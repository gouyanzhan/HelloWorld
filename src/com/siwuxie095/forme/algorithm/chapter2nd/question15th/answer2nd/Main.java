package com.siwuxie095.forme.algorithm.chapter2nd.question15th.answer2nd;

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
 * 方法二：利用递归函数，除此之外，不使用任何容器的方法。具体过程如下：
 * 1、实现递归函数 process，process 的功能是将一棵搜索二叉树转换为一个结构有点特殊的有序双向链表。
 * 结构特殊是指这个双向链表尾节点的 right 指针指向该双向链表的头节点。process 最终返回这个链表的尾
 * 节点。
 *
 * 总之，process 函数的功能是将一棵搜索二叉树变成有序的双向链表，然后让最大值节点的 right 指针指向
 * 最小值节点，最后返回最大值节点。
 *
 * 先用 process 处理左子树，就将左子树转换成了有序双向链表，同时返回尾节点，记为 leftE；再用 process
 * 处理右子树，就将右子树转换成了有序双向链表，同时返回尾节点，记为 rightE。
 * 接下来，把左子树返回的尾节点的 right 指针指向根节点；把根节点的 right 指针指向右子树的头节点（可
 * 以通过右子树返回的尾节点的 right 指针找到），同时把右子树的头节点的 left 指针指向根节点；最后把右
 * 子树返回的尾节点的 right 指针指向左子树的头节点（可以通过左子树返回的尾节点的 right 指针找到）。
 *
 * 一开始时把整棵树的头节点（根节点）作为参数传进 process，然后每棵子树都会经历递归的过程。为什么要将
 * 有序双向链表的尾节点链接头节点之后再返回尾节点呢？因为用这种方式可以快速找到双向链表的头尾两端，从而
 * 省去了通过遍历过程才能找到两端的麻烦。
 *
 * 2、通过 process 过程得到的双向链表是尾节点的 right 指针指向头节点的结构。所以，最终需要将尾节点的
 * right 指针设置为 null，来让双向链表变成正常的样子。
 *
 * 此法的时间复杂度为 O(N)，额外空间复杂度为 O(h)，h 为搜索二叉树的高度。
 *
 * @author Jiajing Li
 * @date 2019-02-24 10:53:51
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

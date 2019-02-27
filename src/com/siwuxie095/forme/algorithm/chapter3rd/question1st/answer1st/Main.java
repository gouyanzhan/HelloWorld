package com.siwuxie095.forme.algorithm.chapter3rd.question1st.answer1st;

/**
 * 分别用递归和非递归的方式实现二叉树的先序、中序和后序遍历
 *
 * 题目：
 * 用递归和非递归的方式，分别按照二叉树先序、中序和后序打印所有的节点。我们约定：
 * 先序遍历顺序为根、左、右；
 * 中序遍历顺序为左、根、右；
 * 后序遍历顺序为左、右、根；
 *
 * PS：
 * （1）先序、中序、后序遍历都属于深度优先遍历；
 * （2）先序遍历 也作 前序遍历；
 *
 * 解答：
 * 先用递归的方式实现：比较简单，直接看代码即可。
 *
 * @author Jiajing Li
 * @date 2019-02-25 17:42:09
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        Recursive.preOrderRecur(head);
        System.out.println();
        System.out.println();
        Recursive.inOrderRecur(head);
        System.out.println();
        System.out.println();
        Recursive.postOrderRecur(head);
    }

    /**
     *   一棵二叉树如下所示：
     *              6
     *          /     \
     *        4         7
     *      /  \          \
     *    2     5           9
     *   / \             /
     * 1    3           8
     */
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

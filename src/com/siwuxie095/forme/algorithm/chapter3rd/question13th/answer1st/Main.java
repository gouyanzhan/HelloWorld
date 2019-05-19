package com.siwuxie095.forme.algorithm.chapter3rd.question13th.answer1st;

/**
 * 判断二叉树是否为平衡二叉树
 *
 * 题目：
 * 平衡二叉树的性质为：要么是一棵空树，要么任何一个节点的左右子树高度差的绝对值不超过 1。
 * 给定一棵二叉树的头节点 head，判断这棵二叉树是否为平衡二叉树。
 *
 * 要求：如果二叉树的节点数为 N，要求时间复杂度为 O(N)。
 *
 * 解答：
 * 解法的整体过程为二叉树的后序遍历（左-右-根），对任何一个节点 node 来说，先遍历
 * node 的左子树，遍历过程中收集两个信息，node 的左子树是否为平衡二叉树，node 的
 * 左子树最深到哪一层记为 leftH。如果发现 node 的左子树不是平衡二叉树，无须进行任
 * 何后续过程，此时返回什么已不重要，因为已经发现整棵树不是平衡二叉树，退出遍历过程；
 * 如果 node 的左子树是平衡二叉树，node 的右子树最深到哪一层记为 rightH。如果发
 * 现 node 的右子树不是平衡二叉树，无须进行任何后续过程，返回什么也不重要，因为已经
 * 发现整棵树不是平衡二叉树，退出遍历过程；如果 node 的右子树也是平衡二叉树，就看
 * leftH 和 rightH 差的绝对值是否大于 1，如果大于 1，说明已经发现整棵树不是平衡
 * 二叉树，如果不大于 1，就返回 leftH 和 rightH 中较大的一个。
 *
 * 判断的全部过程参看 isBalance 方法。在递归函数 getHeight 中，一旦发现不符合
 * 平衡二叉树的性质，递归过程会迅速退出，此时返回什么根本不重要。boolean[] res
 * 长度为 1，其功能相当于一个全局的 boolean 变量。
 *
 * 整个后序遍历的过程中，每个节点最多遍历一次，如果中途发现不满足平衡二叉树的性质，
 * 整个过程会迅速退出，没遍历到的节点也不用遍历了，所以时间复杂度为 O(N)。
 *
 * @author Jiajing Li
 * @date 2019-03-26 09:14:33
 */
public class Main {

    public static void main(String[] args) {
        Node head1 = initTree1();
        System.out.println(Balance.isBalance(head1));
        Node head2 = initTree2();
        System.out.println(Balance.isBalance(head2));
    }

    private static Node initTree1() {
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

    private static Node initTree2() {
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

        node4.left = node6;
        node4.right = node7;

        return node1;
    }

}

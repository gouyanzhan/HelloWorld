package com.siwuxie095.forme.algorithm.chapter3rd.question24th.answer1st;

/**
 * 统计完全二叉树的节点数
 *
 * 题目：
 * 给定一棵完全二叉树的头节点 head，返回这棵树的节点个数。
 *
 * 要求：如果完全二叉树的节点数为 N，请实现时间复杂度低于 O(N) 的解法。
 *
 * 解答：
 * 遍历整棵树当然可以求出节点数，但这肯定不是最优解法，这里不再详述。如果
 * 完全二叉树的层数为 h，本解法可以做到时间复杂度为 O(h^2)，具体过程如下：
 * 1、如果 head == null，说明是空树，直接返回 0。
 * 2、如果不是空树，就求树的高度，求法是找到树的最左节点看能到哪一层，层数
 * 记为 h。
 * 3、这一步是求解的主要逻辑，也是一个递归过程记为 bs(node, l, h)，node
 * 表示当前节点，l 表示 node 所在的层数，h 表示整棵树的层数始终不变的。返
 * 回值表示以 node 为头的完全二叉树的节点数是多少。初始时 node 为头节点
 * head，l 为 1，因为 head 在第 1 层，一共有 h 层始终不变。
 *
 * 每一层只会选择一个节点 node 进行 bs 的递归过程，所以调用 bs 函数的次数
 * 为 O(h)。每次调用 bs 函数时，都会查看 node 右子树的最左节点，所以会遍历
 * O(h) 个节点，整个过程的时间复杂度为 O(h^2)。
 *
 * @author Jiajing Li
 * @date 2019-03-31 15:02:28
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        System.out.println(Count.nodeNum(head));
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

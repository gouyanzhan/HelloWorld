package com.siwuxie095.forme.algorithm.chapter3rd.question11th.answer1st;

/**
 * 判断 t1 树是否包含 t2 树全部的拓扑结构
 *
 * 题目：
 * 给定彼此独立的两棵树的头节点分别为 t1 和 t2，判断 t1 树是否包含 t2 树全部的拓扑结构。
 *
 * t1 树如下：
 *                      1
 *               /             \
 *            2                    3
 *        /       \            /       \
 *     4            5       6           7
 *    / \         /
 *  8     9     10
 *
 *  t2 树如下：
 *           2
 *         /   \
 *      4       5
 *    /
 *  8
 *
 * t1 树包含 t2 树全部的拓扑结构，所以返回 true。
 *
 * 解答：
 * 如果 t1 中某棵子树头节点的值与 t2 头节点的值一样，则从这两个头节点开始匹配，匹配的每
 * 一步都让 t1 上的节点跟着 t2 的先序遍历移动，每移动一步，都检查 t1 的当前节点是否与 t2
 * 当前节点的值一样。
 * 如果匹配的过程中发现有不匹配的情况，直接返回 false。说明 t1 的当前子树从头节点开始，
 * 无法与 t2 匹配，那么再去寻找 t1 的下一棵子树。t1 的每棵子树上都有可能匹配出 t2，所
 * 以都要检查一遍。
 * 所以，如果 t1 的节点数为 N，t2 的节点数为 M，该方法的时间复杂度为 O(N*M)。
 *
 * @author Jiajing Li
 * @date 2019-03-25 18:24:57
 */
public class Main {

    public static void main(String[] args) {
        Node t1 = initTree1();
        Node t2 = initTree2();
        System.out.println(Contain.contains(t1, t2));
    }

    private static Node initTree1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node5.left = node10;

        return node1;
    }

    private static Node initTree2() {
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        Node node4 = new Node(8);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;

        return node1;
    }


}

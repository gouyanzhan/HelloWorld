package com.siwuxie095.forme.algorithm.chapter3rd.question12th.answer1st;

/**
 * 判断 t1 树中是否有与 t2 树拓扑结构完全相同的子树
 *
 * 题目：
 * 给定彼此独立的两棵树头节点分别为 t1 和 t2，判断 t1 中是否有与 t2 树拓扑结构
 * 完全相同的子树。
 *
 * t1 树如下：
 *                      1
 *               /             \
 *            2                    3
 *        /       \            /       \
 *     4            5       6           7
 *      \         /
 *       8      9
 *
 * t2 树如下：
 *           2
 *       /       \
 *    4            5
 *      \      /
 *        8  9
 *
 * 显然，t1 树有与 t2 树拓扑结构完全相同的子树，所以返回 true。
 *
 * 但如果 t2 树如下：
 *           2
 *       /       \
 *    4            5
 *      \
 *        8
 *
 * 则 t1 树就没有与 t2 树拓扑结构完全相同的子树，所以返回 false。
 *
 * 解答：
 * 如果 t1 的节点数为 N，t2 的节点数为 M，本题最优解是时间复杂度为 O(N+M) 的方法。
 * 先简单介绍一个时间复杂度为 O(N*M) 的方法，对于 t1 的每棵子树，都去判断是否与 t2
 * 树的拓扑结构完全一样，这个过程的时间复杂度为 O(M)，t1 的子树一共有 N 棵，所以时间
 * 复杂度为 O(N*M)。
 * 下面重点介绍一下时间复杂度为 O(N+M) 的方法，首先是把 t1 树和 t2 树按照先序遍历的
 * 方式序列化，t1 树序列化后的结果记为 t1Str，t2 树序列化后的结果为 t2Str。接下来，
 * 只要验证 t2Str 是否是 t1Str 的子串即可，这个用 KMP 算法可以在线性时间内解决。所
 * 以 t1 序列化的过程为 O(N)，t2 序列化的过程为 O(M)，KMP 解决 t1Str 和 t2Str 的
 * 匹配问题 O(N+M)，所以时间复杂度为 O(N+M)。
 *
 * @author Jiajing Li
 * @date 2019-03-25 22:31:15
 */
public class Main {

    public static void main(String[] args) {
        Node t1 = initTree1();
        Node t2 = initTree2();
        System.out.println(SubTree.isSubTree(t1, t2));;
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

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.right = node8;

        node5.left = node9;

        return node1;
    }

    private static Node initTree2() {
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        Node node4 = new Node(8);
        Node node5 = new Node(9);

        node1.left = node2;
        node1.right = node3;

        node2.right = node4;
        // 注释掉这一行的区别
        node3.left = node5;

        return node1;
    }

}

package com.siwuxie095.forme.algorithm.chapter3rd.qustion2nd.answer1st;

/**
 * 打印二叉树的边界节点
 *
 * 题目：
 * 给定一棵二叉树的头节点 head，按照如下两种标准分别实现二叉树边界
 * 节点的逆时针打印。
 *
 * 标准一：
 * 1、头节点为边界节点。
 * 2、叶节点为边界节点。
 * 3、如果节点在其所在的层中是最左或最右的，那么也是边界节点。
 *
 * 标准二：
 * 1、头节点为边界节点。
 * 2、叶节点为边界节点。
 * 3、树左边界延伸下去的路径为边界节点。
 * 4、树右边界延伸下去的路径为边界节点。
 *
 * 一棵二叉树如下所示：
 *                          1
 *           /                          \
 *          2                            3
 *           \                         /   \
 *            4                        5    6
 *        /     \                   /    \
 *      7        8                9      10
 *                \             /
 *                 11          12
 *                / \         / \
 *              13  14      15  16
 *
 * 按照标准一的打印结果为：1、2、4、7、11、13、14、15、16、12、10、6、3
 * 按照标准二的打印结果为：1、2、4、7、13、14、15、16、10、6、3
 *
 * 要求：
 * 1、如果节点数为 N，两种标准实现的时间复杂度要求都为 O(N)，额外
 * 空间复杂度要求都为 O(h)，h 为二叉树的高度。
 * 2、两种标准都要求逆时针顺序且不重复打印所有的边界节点。
 *
 * 解答：
 * 按照标准一的要求实现打印的具体过程如下：
 * 1、得到二叉树每一层上最左和最右的节点。
 * 2、从上到下打印所有层中的最左节点。对本例，即打印：1、2、4、7、
 * 11、13。
 * 3、先序遍历（根-左-右）二叉树，打印那些不属于某一层最左或最右的
 * 节点，但同时又是叶节点的节点。对本例，即打印：14、15。
 * 4、从下到上打印所有层中的最右节点，但该节点不能既是最左节点，又
 * 是最右节点。对本例，即打印：16、12、10、6、3。
 *
 * 按照标准二的要求实现打印的具体过程如下：
 * 1、从头节点开始往下寻找，只要找到第一个既有左孩子，又有右孩子的
 * 节点，记为 h，直接进入步骤 2。在这个寻找的过程中，找过的节点都
 * 打印。对本例，即打印：1。
 * 2、h 的左子树先进入步骤 3 的打印过程；h 的右子树再进入步骤 4
 * 的打印过程；最后返回。
 * 3、打印左边界的延伸路径以及 h 左子树上的所有叶节点，具体参考方
 * 法 printLeftEdge()。
 * 4、打印右边界的延伸路径以及 h 右子树上的所有叶节点，具体参考方
 * 法 printRightEdge()。
 *
 * @author Jiajing Li
 * @date 2019-03-03 19:36:07
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        Print1.printEdge(head);
        System.out.println("\n-----------");
        Print2.printEdge(head);
    }

    private static Node initTree() {
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
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);
        Node node16 = new Node(16);

        node1.left = node2;
        node1.right = node3;

        node2.right = node4;
        node3.left = node5;
        node3.right = node6;

        node4.left = node7;
        node4.right = node8;
        node5.left = node9;
        node5.right = node10;

        node8.right = node11;
        node9.left = node12;

        node11.left = node13;
        node11.right = node14;

        node12.left = node15;
        node12.right = node16;

        return node1;
    }

}

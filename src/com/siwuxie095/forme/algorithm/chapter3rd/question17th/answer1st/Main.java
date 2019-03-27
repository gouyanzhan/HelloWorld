package com.siwuxie095.forme.algorithm.chapter3rd.question17th.answer1st;

/**
 * 在二叉树中找到一个节点的后继节点
 *
 * 题目：
 * 现在有一种新的二叉树节点类型，即 除了值、指向左孩子的 left 指针、指向右孩子的 right 指针之外，
 * 还有一个指向父节点的 parent 指针。假设有一棵 Node 类型的节点组成的二叉树，树中每个节点的 parent
 * 指针都正确指向自己的父节点，头节点的 parent 指针指向 null。只给一个在二叉树中的某个节点 node，
 * 请实现返回 node 的后继节点的函数。在二叉树的中序遍历的序列中，node 的下一个节点叫作 node 的后
 * 继节点。
 *
 * 一棵二叉树如下：
 *                            6
 *                     /               \
 *              3                           9
 *          /       \                   /       \
 *        1          4                8          10
 *                /     \           /
 *             2         5        7
 *
 * 中序遍历结果为：1、2、3、4、5、6、7、8、9、10。
 * 所以节点 1 的后继为节点 2，节点 2 的后继为节点 3 ... 节点 10 的后继为 null。
 *
 * 解答：
 * 先介绍一种时间复杂度和空间复杂度较高但易于理解的方法。既然新类型的二叉树节点有指向父节点的指针，
 * 那么一直往上移动，自然可以找到头节点。找到头节点之后，在进行二叉树的中序遍历，生成中序遍历序列，
 * 然后在这个序列中找到 node 节点的下一个节点返回即可。如果二叉树的节点数为 N，这种方法要把二叉
 * 树的所有节点至少遍历一遍，生成中序遍历的序列还需要大小为 N 的空间，所以该方法的时间复杂度和额
 * 外空间复杂度都为 O(N)。这里不再详述。
 *
 * 最优解法不必遍历所有的节点，如果 node 节点和 node 后继节点之间的实际距离为 L，最优解法只用
 * 走过 L 个节点，时间复杂度为 O(L)，额外空间复杂度为 O(1)。接下来详细说明最优解法是如何找到 node
 * 的后继节点的。
 * （1）情况一：如果 node 有右子树，那么后继节点就是右子树上最左边的节点。
 * （2）情况二：如果 node 没有右子树，那么先看 node 是不是 node 父节点的左孩子，如果是左孩子，
 * 那么此时 node 的父节点就是 node 的后继节点；如果是右孩子，就向上寻找 node 的后继节点，假设
 * 向上移动到的节点记为 s，s 的父节点记为 p，如果发现 s 是 p 的左孩子，那么节点 p 就是 node
 * 节点的后继节点，否则就一直向上移动。
 * （3）情况三：如果在情况二中一直向上寻找，都移动到空节点时还是没有发现 node 的后继节点，说明
 * node 根本不存在后继节点。
 *
 * 情况一和情况二遍历的节点就是 node 到 node 后继节点这条路径上的节点；情况三遍历的节点数也不
 * 会超过二叉树的高度。
 *
 * @author Jiajing Li
 * @date 2019-03-27 09:08:37
 */
public class Main {

    public static void main(String[] args) {
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

        node6.left = node3;
        node6.right = node9;
        node6.parent = null;

        node3.left = node1;
        node3.right = node4;
        node3.parent = node6;

        node9.left = node8;
        node9.right = node10;
        node9.parent = node6;

        node1.left = null;
        node1.right = null;
        node1.parent = node3;

        node4.left = node2;
        node4.right = node5;
        node4.parent = node3;


        node8.left = node7;
        node8.right = null;
        node8.parent = node9;

        node10.left = null;
        node10.right = null;
        node10.parent = node9;

        node2.left = null;
        node2.right = null;
        node2.parent = node4;

        node5.left = null;
        node5.right = null;
        node5.parent = node4;

        node7.left = null;
        node7.right = null;
        node7.parent = node8;

        System.out.println("Next.getNextNode(node1).value = " + Next.getNextNode(node1).value);
        System.out.println("Next.getNextNode(node2).value = " + Next.getNextNode(node2).value);
        System.out.println("Next.getNextNode(node3).value = " + Next.getNextNode(node3).value);
        System.out.println("Next.getNextNode(node10).value = " + Next.getNextNode(node10));
    }

}

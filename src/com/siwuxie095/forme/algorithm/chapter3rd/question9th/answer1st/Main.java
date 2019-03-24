package com.siwuxie095.forme.algorithm.chapter3rd.question9th.answer1st;

/**
 * 二叉树的按层打印与 ZigZag 打印
 *
 * 题目：
 * 给定一棵二叉树的头节点 head，分别实现按层打印和 ZigZag 打印二叉树的函数。
 *
 * 一棵二叉树如下：
 *               1
 *          /         \
 *       2              3
 *    /               /   \
 * 4               5        6
 *               /   \
 *             7      8
 *
 * 按层打印时，输出格式必须如下：
 * Level 1 : 1
 * Level 2 : 2 3
 * Level 3 : 4 5 6
 * Level 4 : 7 8
 *
 * ZigZag 打印时，输出格式必须如下：
 * Level 1 from left to right : 1
 * Level 2 from right to left : 3 2
 * Level 3 from left to right : 4 5 6
 * Level 4 from right to left : 8 7
 *
 * 解答：
 * 1、按层打印的实现：
 * 按层打印原本是十分基础的内容，对二叉树做简单的宽度优先遍历即可，但本题确有
 * 额外的要求，那就是同一层的节点必须打印在同一行上，并且要求输出行号。这需要
 * 在原来宽度优先遍历的基础上做一些改进。所以关键问题是如何知道该换行。只需要
 * 用两个 Node 类型的变量 last 和 nLast 就可以解决这个问题。last 变量表
 * 示正在打印当前行的最右节点，nLast 表示下一行的最右节点。假设每一层都做从
 * 左到右的宽度优先遍历，如果发现遍历到的节点等于 last，说明该换行了。换行之
 * 后只要令 last = nLast，就可以继续下一行的打印过程，此过程重复，直到所有
 * 的节点都打印完。那么问题就变成了如何更新 nLast？只需要让 nLast 一直跟踪
 * 记录宽度优先队列中最新加入的节点即可。这是因为最新加入队列的节点一定是目前
 * 已经发现的下一行的最右节点。所以在当前行打印完时，nLast 一定是下一行所有
 * 节点中的最右节点。
 *
 * 2、ZigZag 打印的实现：
 * 先简单介绍一种不推荐的方法，即 使用 ArrayList 结构的方法。两个 ArrayList
 * 结构记为 list1 和 list2，用 list1 去收集当前层的节点，然后从左到右打印
 * 当前层，接着把当前层的孩子节点放进 list2，并从右到左打印，接下来再把 list2
 * 的所有节点的孩子节点放入 list1，如此反复。不推荐的原因是 ArrayList 结构
 * 为动态数组，在这个结构中，当元素数量增加到一定规模时将发生扩容操作，扩容操
 * 作的时间复杂度为 O(N) 是比较高的，这个结构增加和删除元素的时间复杂度也较高。
 * 总之，用这个结构对本题来讲，数据结构不够纯粹和干净，如果读者不充分理解这个
 * 结构的底层实现，最好不要使用，而且还需要两个 ArrayList 结构。
 *
 * 这里提供的方法只使用了一个双端队列，具体为 Java 中的 LinkedList 结构，这
 * 个结构的底层实现就是非常纯粹的双端队列结构，而且这里也仅使用到双端队列结构的
 * 基本操作。大体过程 即 首先生成双端队列结构 dq，然后遵循以下两个原则：
 * （1）原则一：如果是从左到右的过程，那么一律从 dq 的头部弹出节点，如果弹出的
 * 节点没有孩子节点，当然不用放入任何节点到 dq 中；如果当前节点有孩子节点，先让
 * 左孩子从尾部进入 dq，再让右孩子从尾部进入 dq。
 * （2）原则二：如果是从右到左的过程，那么一律从 dq 的尾部弹出节点，如果弹出的
 * 节点没有孩子节点，当然不用放入任何节点到 dq 中；如果当前节点有孩子节点，先让
 * 右孩子从头部进入 dq，再让左孩子从头部进入 dq。
 *
 * 用原则一和原则二的过程切换，可以完成 ZigZag 的打印过程，所以现在只剩下一个
 * 问题，如何确定切换原则一和原则二的时机，其实还是如何确定每一层最后一个节点的
 * 问题。在 ZigZag 打印过程中，下一层最后打印的节点是当前层有孩子的节点中最先
 * 进入 dq 的节点。
 *
 * @author Jiajing Li
 * @date 2019-03-24 21:36:29
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();

        System.out.println("按层打印：");
        Print.printByLevel(head);

        System.out.println();

        System.out.println("ZigZag 打印：");
        Print.printByZigZag(head);
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

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;

        node3.left = node5;
        node3.right = node6;

        node5.left = node7;
        node5.right = node8;

        return node1;
    }

}

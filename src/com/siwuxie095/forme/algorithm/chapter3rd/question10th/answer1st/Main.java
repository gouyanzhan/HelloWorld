package com.siwuxie095.forme.algorithm.chapter3rd.question10th.answer1st;

/**
 * 调整搜索二叉树中两个错误的节点
 *
 * 问题：
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，
 * 请找到这两个错误节点并返回。已知二叉树中所有节点的值都不一样，给定二叉树的头节点 head，返
 * 回一个长度为 2 的二叉树节点类型的数组 errArr，errArr[0] 表示一个错误节点，errArr[1]
 * 表示另一个错误节点。
 *
 * 进阶：如果在愿问题中得到了这两个错误节点，当然可以通过交换两个节点的节点值的方式让整棵二
 * 叉树重新成为搜索二叉树。但现在要求不能这么做，而是在结构上完全交换两个节点的位置，请实现
 * 调整的函数。
 *
 * 解答：
 * 原问题：找到两个错误节点。如果对所有的节点值都不一样的搜索二叉树进行中序遍历，那么出现的
 * 节点值会一直升序。所以，如果又两个节点的位置错了，就一定会出现降序。
 * 如果在中序遍历时，节点值出现了两次降序，第一个错误的节点为第一次降序时较大的节点，第二个
 * 错误的节点为第二次降序时较小的节点。
 * 如果在中序遍历时，节点值只出现了一次降序，第一个错误节点为这次降序时较大的节点，第二个错
 * 误节点为这次降序时较小的节点。
 * 寻找两个错误节点的过程可以总结为：第一个错误节点为第一次降序时较大的节点，第二个错误节点
 * 为最后一次降序时较小的节点。
 * 所以，只要改写一个基本的中序遍历，就可以完成原问题的要求。当然，也可以改写递归、非递归、
 * 或 Morris 遍历都可以。
 *
 * 进阶问题：在结构上交换这两个错误节点。若要在结构上交换两个错误节点，首先应该找到两个错误
 * 节点各自的父节点，随便改写一个二叉树的遍历即可。
 * 找到两个错误节点各自父节点的过程，参考 getTwoErrParentArr 方法，该方法返回长度为 2
 * 的 Node 类型的数组 parentArr，parentArr[0] 表示第一个错误节点的父节点，parentArr[1]
 * 表示第二个错误节点的父节点。
 * 找到两个错误节点的父节点后：
 * （1）第一个错误节点记为 err1，err1 的父节点记为 err1P，err1 的左孩子记为 err1L，
 * err1 的右孩子记为 err1R。
 * （2）第二个错误节点记为 err2，err2 的父节点记为 err2P，err2 的左孩子记为 err2L，
 * err2 的右孩子记为 err2R。
 *
 * 在结构上交换两个节点，实际上就是把两个节点互换环境。粗略的说，就是让 err2 成为 err1P
 * 的孩子节点，让 err1L 和 e1R 成为 err2 的孩子节点；让 err1 成为 err2P 的孩子节点，
 * 让 err2L 和 err2R 成为 err1 的孩子节点。但这只说粗略的理解，在实际交换的过程中有很
 * 多情况需要特殊处理。比如：如果 err1 是头节点，意味着 err1P 为 null，那么让 err2 成
 * 为 err1P 的孩子节点时，关于 err1P 的任何 left 指针或 right 指针操作都会发生错误，
 * 因为 err1P 为 null 根本没有 Node 类型节点的结构。再如：如果 e1 本身就是 e2 的左孩
 * 子，即 err1 = err2L，那么让 err2L 成为 err1 的左孩子时，err1 的 left 指针将指向
 * err2L，将会指向自己，这回让整棵二叉树发生严重的结构错误。
 *
 * 换句话说，必须理清楚 err1 及其上下环境之间的关系、err2 及其上下环境之间的关系，以及两
 * 个环境之间是否有联系。有以下三个问题和一个特别注意是必须关注的。
 * （1）问题一：err1 和 err2 是否有一个是头节点？如果有，谁是头？
 * （2）问题二：err1 和 err2 是否相邻？如果相邻，谁是谁的父节点？
 * （3）问题三：err1 和 err2 分别是各自父节点的左孩子还是右孩子？
 * （4）特别注意：因为是在中序遍历时先找到 err1，后找到 err2，所以 err1 一定不是 err2
 * 的右孩子，err2 也一定不是 err1 的左孩子。
 *
 * 以上三个问题与特别注意之间相互影响，情况非常复杂，经过仔细整理，情况共有 14 种，每一种
 * 情况在调整 err1 和 err2 各自的拓扑关系时都有特殊处理。
 * （01）err1 是头，err1 是 err2 的父，此时 err2 只可能是 err1 的右孩子。
 * （02）err1 是头，err1 不是 err2 的父，err2 是 err2P 的左孩子。
 * （03）err1 是头，err1 不是 err2 的父，err2 是 err2P 的右孩子。
 *
 * （04）err2 是头，err2 是 err1 的父，此时 err1 只可能是 err2 的左孩子。
 * （05）err2 是头，err2 不是 err1 的父，err1 是 err1P 的左孩子。
 * （06）err2 是头，err2 不是 err1 的父，err1 是 err1P 的右孩子。
 *
 * （07）err1 和 err2 都不是头，err1 是 err2 的父，此时 err2 只可能是 err1 的右孩子，
 * err1 是 err1P 的左孩子。
 * （08）err1 和 err2 都不是头，err1 是 err2 的父，此时 err2 只可能是 err1 的右孩子，
 * err1 是 err1P 的右孩子。
 *
 * （09）err1 和 err2 都不是头，err2 是 err1 的父，此时 err1 只可能是 err2 的左孩子，
 * err2 是 err2P 的左孩子。
 * （10）err1 和 err2 都不是头，err2 是 err1 的父，此时 err1 只可能是 err2 的左孩子，
 * err2 是 err2P 的右孩子。
 *
 * （11）err1 和 err2 都不是头，谁也不是谁的父节点，err1 是 err1P 的左孩子，err2 是
 * err2P 的左孩子。
 * （12）err1 和 err2 都不是头，谁也不是谁的父节点，err1 是 err1P 的左孩子，err2 是
 * err2P 的右孩子。
 *
 * （13）err1 和 err2 都不是头，谁也不是谁的父节点，err1 是 err1P 的右孩子，err2 是
 * err2P 的左孩子。
 * （14）err1 和 err2 都不是头，谁也不是谁的父节点，err1 是 err1P 的右孩子，err2 是
 * err2P 的右孩子。
 *
 * 当情况 1 至情况 3 发生时，二叉树新的头节点应该为 err2；当情况 4 至情况 6 发生时，二
 * 叉树新的头节点应该为 err1；其他情况发生时，二叉树的头节点不用发生变化。
 *
 *
 * PS：搜索二叉树，也称 二叉搜索树、二叉查找树、二叉排序树，它可以是：
 * （1）一棵空树。
 * （2）一棵非空树，但要求：
 * 1）左子树不空时，左子树的所有节点值均小于根节点的值。
 * 2）右子树不空时，右子树的所有节点值均大于根节点的值。
 *
 * 【显然，搜索二叉树的左右子树，也都是搜索二叉树】
 *
 * @author Jiajing Li
 * @date 2019-03-24 23:04:15
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        Node[] errArr = Error.getTwoErrArr(head);
        System.out.println(errArr[0].value + " - " + errArr[1].value);

        head = Error.recoverTree(head);
        System.out.println(head.left.left.value + " - " + head.left.right.value);
    }

    /**
     * 一棵搜索二叉树如下：
     *              10
     *          /        \
     *      4               14
     *    /   \           /    \
     * 2        5       11      15
     *
     * 现交换 2 和 5
     */
    private static Node initTree() {
        Node node1 = new Node(10);
        Node node2 = new Node(4);
        Node node3 = new Node(14);
        Node node4 = new Node(2);
        Node node5 = new Node(5);
        Node node6 = new Node(11);
        Node node7 = new Node(15);

        node1.left = node2;
        node1.right = node3;

        node2.left = node5;
        node2.right = node4;

        node3.left = node6;
        node3.right = node7;

        return node1;
    }


}

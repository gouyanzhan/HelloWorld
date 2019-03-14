package com.siwuxie095.forme.algorithm.chapter3rd.question5th.answer1st;

/**
 * 遍历二叉树的神级方法
 *
 * 题目：
 * 给定一棵二叉树的头节点 head，完成二叉树的先序、中序、后序遍历。如果
 * 二叉树的节点数为 N，要求时间复杂度为 O(N)，额外空间复杂度为 O(1)。
 *
 * 解答：
 * 本题真正的难点在于对复杂度的要求，尤其是额外空间复杂度为 O(1) 的限制。
 * 对于常用的递归和非递归的方法虽然都能实现遍历二叉树，但都无法做到额外空
 * 间复杂度为 O(1)。这是因为遍历二叉树的递归方法实际使用了函数栈，非递归
 * 的方法使用了申请的栈，两者的额外空间都与树的高度相关，所以空间复杂度为
 * O(h)，h 为二叉树的高度。如果完全不用栈结构能完成三种遍历吗？可以。答案
 * 是使用二叉树节点中大量指向 null 的指针，本题实际上就是大名鼎鼎的 Morris
 * 遍历，由 Joseph Morris 于 1979 年发明。
 *
 * 首先来看普通的递归和非递归解法，其实都使用了栈结构，在处理完二叉树某个
 * 节点后可以回到上层去。为什么从下层回到上层会如此之难？因为二叉树的结构
 * 如此，每个节点都有指向孩子节点的指针，所以从上层到下层容易，但是没有指
 * 向父节点的指针，所以从下层到上层需要用栈结构辅助完成。
 * Morris 遍历的实质就是避免用栈结构，而是让下层到上层有指针，具体是通过
 * 让底层节点指向 null 的空闲指针指回上层的某个节点，从而完成下层到上层的
 * 移动。我们知道，二叉树的很多节点上都有大量的空闲指针，比如某些节点没有
 * 右孩子，那么这个节点的 right 指针就指向 null，我们称为空闲状态，Morris
 * 遍历正是利用了这些空闲指针。
 *
 * 在介绍 Morris 先序和后序遍历之前， 先介绍中序遍历：
 * 1、Morris 中序遍历：
 * （1）假设当前子树的头节点为 h，让 h 的左子树中最右节点的 right 指针
 * 指向 h，然后 h 的左子树继续步骤（1）的处理过程，直到遇到某一个节点没
 * 有左子树时记为 node，进入步骤（2）。
 * （2）从 node 开始通过每个节点的 right 指针进行移动，并依次打印，假设
 * 移动到的节点为 curr。对每一个 curr 节点都判断 curr 节点的左子树中最
 * 右节点是否指向 curr。
 * 1）如果是。让 curr 节点的左子树中最右节点的 right 指针指向空，也就是
 * 把步骤（1）的调整后，再逐渐调整回来，然后打印 curr，继续通过 curr 的
 * right 指针移动到下一个节点，重复步骤（2）。
 * 2）如果不是。以 curr 为头的子树重回步骤（1）执行。
 * （3）步骤（2）最终移动到 null，整个过程结束。
 *
 * 2、Morris 的先序遍历：
 * Morris 的先序遍历的实现就是 Morris 中序遍历实现的简单改写。中序遍历
 * 的打印时机放在了步骤（2）所描述的移动过程中，而先序遍历只要把打印时机
 * 放在步骤（1）发生的时候即可。步骤（1）发生的时候，正在处理以 h 为头的
 * 子树，并且是以 h 为头的子树首次进入调整过程，此时直接打印 h，就可以做
 * 到先根打印。
 *
 * 3、Morris 的后序遍历：
 * Morris 后序遍历的实现也是 Morris 中序遍历实现的改写，但包含更复杂的
 * 调整过程。总的来说，逻辑很简单，就是依次逆序打印所有节点的左子树的右边
 * 界，打印时机放在步骤（2）的条件 1）被触发的时候，也就是调回去的过程发
 * 生的时候。
 *
 * @author Jiajing Li
 * @date 2019-03-11 22:01:07
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        System.out.println("pre order:");
        Morris.morrisPre(head);
        System.out.println("in order:");
        Morris.morrisIn(head);
        System.out.println("post order:");
        Morris.morrisPost(head);
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

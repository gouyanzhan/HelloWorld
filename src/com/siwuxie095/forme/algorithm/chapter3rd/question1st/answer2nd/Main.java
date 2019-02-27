package com.siwuxie095.forme.algorithm.chapter3rd.question1st.answer2nd;

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
 * 再用非递归的方式实现：用递归方法解决的问题都能用非递归的方法实现。这是因为递归
 * 方法无非就是利用函数栈来保存信息，如果用自己申请的数据结构来代替函数栈，也可以
 * 实现相同的功能。
 *
 * 1、先序遍历，具体过程如下：
 * （1）申请一个新的栈，记为 stack。然后将头节点 head 压入 stack 中。
 * （2）从 stack 中弹出栈顶节点，记为 curr，然后打印 curr 的值，再将 curr 的
 * 右孩子（不为空的话）先压入 stack 中，最后将 curr 的左孩子（不为空的话）压入
 * stack 中。
 * （3）不断重复步骤 （2），直到 stack 为空，全部过程结束。
 *
 *
 * 2、中序遍历，具体过程如下：
 * （1）申请一个新的栈，记为 stack。初始时，令变量 curr = head。
 * （2）先把 curr 节点压入栈中，对以 curr 节点为头的整棵子树来说，依次把左边界
 * 压入栈中，即 不停的令 curr = curr.left，然后重复步骤 （2）。
 * （3）不断重复步骤 （2），直到发现 curr 为空，此时从 stack 中弹出一个节点，
 * 记为 node，打印 node 的值，并且让 curr = node.right，然后继续重复步骤（2）。
 * （4）当 stack 为空且 curr 为空时，整个过程停止。
 *
 * 【步骤（1）到步骤（4）就是依次打印左子树，然后是每棵子树的头节点，最后打印右子树。】
 *
 *
 * 3、后序遍历，具体过程如下：
 * 1）法一：用两个栈实现后序遍历：
 * （1）申请一个栈，记为 stack1，然后将头节点 head 压入 stack1 中。
 * （2）从 stack1 中弹出的节点记为 curr，然后依次将 curr 的左孩子和右孩子压入 stack1 中。
 * （3）在整个过程中，每一个从 stack1 中弹出的节点都放进 stack2 中。
 * （4）不断重复步骤（2）和步骤（3），直到 stack1 为空，过程停止。
 * （5）从 stack2 中依次弹出节点并打印，打印的顺序就是后序遍历的顺序。
 *
 * 【每棵子树的头节点都是先从 stack1 中弹出，然后把该节点的孩子节点按照先左再右的顺序压入 stack1，
 * 那么从 stack1 中弹出的顺序就是先右再左，所以从 stack1 中弹出的顺序就是根-右-左。然后 stack2
 * 重新收集的过程就是把 stack1 的弹出顺序逆序，所以从 stack2 从栈顶到栈底的顺序就变成了左-右-根。】
 *
 * 2）法二：只用一个栈实现后序遍历：
 * （1）申请一个栈，记为 stack，将头节点压入 stack 中，同时设置两个变量 h 和 c。
 * 在整个流程中，h 表示最近一次弹出并打印的节点，c 表示 stack 的栈顶节点，初始时
 * h 为头节点，c 为 null。
 * （2）每次令 c 等于当前 stack 的栈顶节点，但是不从 stack 中弹出。此时分为以下
 * 三种情况：
 * 情况一：如果 c 的左孩子不为 null，并且 h 不等于 c 的左孩子，也不等于 c 的右
 * 孩子，则把 c 的左孩子压入 stack 中。具体解释一下这么做的原因：首先 h 的意义
 * 是最近一次弹出并打印的节点，所以如果 h 等于 c 的左孩子或右孩子，说明 c 的左
 * 子树和右子树已经打印完毕，此时不应该再将 c 的左孩子放入 stack 中。否则，说
 * 明左子树还没处理过，那么此时将 c 的左孩子压入 stack 中。
 * 情况二：如果情况一不成立，并且 c 的右孩子不为 null，h 不等于 c 的右孩子，则把
 * c 的右孩子压入 stack 中。含义是如果 h 等于 c 的右孩子，说明 c 的右子树已经打
 * 印完毕，此时不应该再将 c 的右孩子放入栈中。否则，说明右子树还没有处理过，此时将
 * c 的右孩子压入 stack 中。
 * 情况三：如果情况一和情况二都不成立，说明 c 的左子树和右子树都已经打印完毕，那么
 * 从 stack 中弹出 c 并打印，然后令 h = c。
 * （3）一直重复步骤（2），直到 stack 为空，过程停止。
 *
 * @author Jiajing Li
 * @date 2019-02-25 17:51:44
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        NonRecursive.preOrderNonRecur(head);
        System.out.println();
        System.out.println();
        NonRecursive.inOrderNonRecur(head);
        System.out.println();
        System.out.println();
        NonRecursive.postOrderNonRecur1(head);
        NonRecursive.postOrderNonRecur2(head);
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

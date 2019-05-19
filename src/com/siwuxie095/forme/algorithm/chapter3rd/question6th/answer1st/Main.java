package com.siwuxie095.forme.algorithm.chapter3rd.question6th.answer1st;

/**
 * 在二叉树中找到累加和为指定值的最长路径长度
 *
 * 题目：
 * 给定一棵二叉树的头节点 head 和一个32位整数 sum，二叉树节点值类型为整型，求累加和
 * 为 sum 的最长路径长度。路径是指从某个节点往下，每次最多选择一个孩子节点或者不选所
 * 形成的节点链。
 *
 * 一个二叉树如下：
 *                  -3
 *             /          \
 *          3               -9
 *        /     \         /     \
 *      1        0       2       1
 *              / \
 *             1   6
 * 如果 sum = 6，那么累加和为 6 的最长路径为 -3、3、0、6，所以返回 4。
 * 如果 sum = -9，那么累加和为 -9 的最长路径为 -9，所以返回 1。
 *
 * 注：本题不考虑节点值相加可能溢出的情况。
 *
 * 解答：
 * 如果二叉树的节点数为 N，二叉树的高度为 h，那么时间复杂度为 O(N)，额外空间复杂度为
 * O(h)，具体过程如下：
 * 1、二叉树头节点 head 和规定值 sum 已知，生成变量 maxLen，负责记录累加和等于 sum
 * 的最长路径长度。
 * 2、生成哈希表 sumMap。它负责记录从 head 开始的一条路径上的累加和出现情况，累加和
 * 也是从 head 节点的值开始累加的。
 * （1）key 代表累加和。
 * （2）value 代表这个累加和在路径中最早出现的层数。
 * 如果在遍历到当前节点 curr 时，就能够知道从 head 到 curr 这条路径上的累加和出现情
 * 况，那么求以 curr 节点结尾的累加和为指定值的最长路径长度就非常容易。
 * 3、究竟如何去更新 sumMap，才能够做到在遍历到任何一个节点时都能有从 head 到这个节
 * 点的路径上的累加和出现情况呢？首选在 sumMap 中加入一个记录（0，0），它表示累加和
 * 0 不用包括任何节点就可以得到。然后按照二叉树先序遍历的方式遍历节点，遍历到的当前节
 * 点记为 curr，从 head 到 curr 的父节点累加和记为 prevSum，curr 所在的层数记为
 * level。将 curr.value + preSum 的值记为 currSum，就是从 head 到 curr 的累
 * 加和。如果 sumMap 中已经包含了 currSum 的记录，说明 curSum 在上层中已经出现过，
 * 那么就不更新 sumMap；如果 sumMap 不包含 currSum 的记录，说明 currSum 是第一次
 * 出现，就把（currSum，level）这个记录放入 sumMap。接下来是求解在必须以 curr 结尾
 * 的情况下，累加和为规定值的最长路径长度。然后是遍历 curr 的左子树和右子树的过程，依
 * 然按照步骤 3 去使用和更新 sumMap。以 curr 为头节点的子树处理完，当然要返回到 curr
 * 父节点，在返回前还有一项重要的工作要做，在 sumMap 中查询 currSum 这个累加和（key）
 * 出现的层数（level）,如果 value 等于 level，说明 currSum 这个累加和的记录是在遍历
 * curr 时加上去的，那就把这一条记录删除；如果 value 不等于 level，则不做任何调整。
 * 4、步骤 3 会遍历二叉树所有的节点，也会求解以每个节点结尾的情况下，累加和为规定值的最
 * 长路径长度。用 maxLen 记录其中的最大值即可。
 *
 * @author Jiajing Li
 * @date 2019-03-20 22:15:08
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        int sum = 0;
        System.out.println(Length.getMaxLength(head, sum));
    }

    private static Node initTree() {
        Node node1 = new Node(-3);
        Node node2 = new Node(3);
        Node node3 = new Node(-9);
        Node node4 = new Node(1);
        Node node5 = new Node(0);
        Node node6 = new Node(2);
        Node node7 = new Node(1);
        Node node8 = new Node(1);
        Node node9 = new Node(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.left = node8;
        node5.right = node9;

        return node1;
    }

}

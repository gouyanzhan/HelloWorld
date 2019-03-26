package com.siwuxie095.forme.algorithm.chapter3rd.question14th.answer1st;

/**
 * 根据后序数组重建搜索二叉树
 *
 * 题目：
 * 给定一个整型数组 arr，已知其中没有重复值，判断 arr 是否可能是节点值类型为整型的
 * 搜索二叉树后序遍历的结果。
 *
 * 进阶：如果整型数组 arr 中没有重复值，且已知是一棵搜索二叉树的后序遍历结果，通过
 * 数组 arr 重构二叉树。
 *
 * 解答：
 * 原问题的解法。二叉树的后序遍历为：左-右-根，所以，如果一个数组是二叉树后序遍历的
 * 结果，那么头节点的值一定会是数组的最后一个元素。根据搜索二叉树的性质，所以比后序
 * 数组最后一个元素值小的数组会在数组的左边，比数组最后一个元素值大的数组会在数组的
 * 右边。比如：arr = [2, 1, 3, 6, 5, 7, 4]，比 4 小的部分为 [2, 1, 3]，比 4
 * 大的部分为 [6, 5, 7]。如果不满足这种情况，说明这个数组一定不可能是搜索二叉树后
 * 序遍历的结果。接下来数组划分成左边数组和右边数组，相当于二叉树分出了左子树和右子树，
 * 只要递归地进行如上判断即可。
 *
 * 进阶问题的分析与原问题同理，一棵树的后序数组中最后一个值为二叉树头节点的值，数组
 * 左部分都比头节点的值小，用来生成头节点的左子树，剩下部分用来生成右子树。
 *
 * @author Jiajing Li
 * @date 2019-03-26 12:32:45
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 3, 6, 5, 7, 4};
        System.out.println(PostArray.isPostArray(arr));
        Node head = PostArray.postArrayToBST(arr);
        System.out.println(head.value);
    }

}

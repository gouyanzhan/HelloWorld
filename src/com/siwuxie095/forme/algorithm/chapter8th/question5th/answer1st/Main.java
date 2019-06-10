package com.siwuxie095.forme.algorithm.chapter8th.question5th.answer1st;

/**
 * 需要排序的最短子数组长度
 *
 * 题目：
 * 给定一个无序数组 arr，求出需要排序的最短子数组长度。
 * 比如：arr = [1, 5, 3, 4, 2, 6, 7] 返回 4，因为只有 [5, 3, 4, 2] 需要排序。
 *
 * 解答：
 * 解决这个问题可以做到时间复杂度为 O(N)，额外空间复杂度为 O(1)。
 *
 * 初始化变量 noMinIndex = -1，从右向左遍历，遍历的过程中记录右侧出现过的数的最小值，记为 min。假设当前数为 arr[i]，
 * 如果 arr[i] > min，说明如果整体有序，min 值必然会挪到 arr[i] 的左边。用 noMinIndex 记录最左边出现这种情况的位
 * 置。如果遍历完成 noMinIndex 依然等于 -1，说明从右到左始终不升序，愿数组本来就有序，直接返回 0，即 完全不需要排序。
 *
 * 接下来从左向右遍历，遍历的过程中记录左侧出现过的数的最大值，记为 max。假设当前数为 arr[i]，如果 arr[i] < max，说
 * 明如果排序，max 的值必然会挪到 arr[i] 的右边，用变量 noMaxIndex 记录最右边出现这种情况的位置。
 *
 * 遍历完成后，arr[noMinIndex .. noMaxIndex] 是真正需要排序的部分，返回它的长度即可。
 *
 * @author Jiajing Li
 * @date 2019-05-27 09:33:45
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2, 6, 7};
        System.out.println(Length.getMinLength(arr));
    }

}

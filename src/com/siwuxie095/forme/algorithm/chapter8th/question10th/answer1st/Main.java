package com.siwuxie095.forme.algorithm.chapter8th.question10th.answer1st;

/**
 * 未排序正数数组中累加和为给定值的最长子数组长度
 *
 * 题目：
 * 给定一个数组 arr，该数组无序，但每个值均为正数，再给定一个正数 k。求 arr 的所有子数组中所有元素
 * 相加和为 k 的最长子数组长度。
 * 比如：arr = [1, 2, 1, 1, 1]，k = 3。
 * 累加和为 3 的最长子数组为 [1, 1, 1]，所以结果返回 3。
 *
 * 解答：
 * 最优解可以做到时间复杂度为 O(N)，额外空间复杂度为 O(1)。首先用两个位置来标记子数组的左右两头，记
 * 为 left 和 right，开始时都在数组的最左边（left = 0，right = 0）。整体过程如下：
 * 1、开始时变量 left = 0，right = 0，代表子数组 arr[left..right]。
 * 2、变量 sum 始终表示子数组 arr[left..right] 的和，开始时 sum = arr[0]，即 arr[0..0] 的和。
 * 3、变量 len 一直记录累加和为 k 的所有子数组中最大数组的长度。开始时，len = 0。
 * 4、根据 sum 与 k 的比较结果决定时 left 移动还是 right 移动，具体如下：
 * （1）如果 sum == k，说明 arr[left..right] 累加和为 k，如果 arr[left..right] 长度大于 len，
 * 则更新 len，此时因为数组中所有的值都为正数，那么所有从 left 位置开始，在 right 之后的位置结束的
 * 子数组，即 arr[left..i]，i > right，累加和一定大于 k。所以，令 left 加 1，这表示开始考查以 left
 * 之后的位置开始的子数组，同时令 sum -= arr[left]，sum 此时开始表示 arr[left+1..right] 的累加
 * 和。
 * （2）如果 sum < k，说明 arr[left..right] 还需要加上 right 后面的值，其和才可能达到 k，所以令
 * right 加 1，sum += arr[right]。需要注意的是，right 加 1 后是否越界。
 * （3）如果 sum > k，说明所有从 left 位置开始，在 right 之后的位置结束的子数组，即 arr[left..i]，
 * i > right，累加和一定大于 k。所以令 left 加 1，这表示开始考查以 left 之后的位置开始的子数组，同
 * 时令 sum -= arr[left]，sum 此时表示 arr[left+1..right] 的累加和。
 * 5、如果 right < arr.length，重复步骤 4。否则直接返回 len，全部过程结束。
 *
 * @author Jiajing Li
 * @date 2019-05-28 23:00:24
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1};
        System.out.println(Length.getMaxLength(arr, 3));
    }

}

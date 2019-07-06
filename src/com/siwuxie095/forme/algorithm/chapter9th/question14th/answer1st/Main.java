package com.siwuxie095.forme.algorithm.chapter9th.question14th.answer1st;

/**
 * 正数数组的最小不可组成和
 *
 * 题目：
 * 给定一个正数数组 arr，其中所有的值都为整数，以下是最小不可组成和的概念：
 * （1）把 arr 每个子集内的所有元素加起来会出现很多值，其中最小的记为 min，最大的记为 max。
 * （2）在区间 [min, max] 上，如果有数不可以被 arr 某个子集相加得到，那么其中最小的那个数是 arr 的最小不可组成和。
 * （3）在区间 [min, max] 上，如果所有的数都可以被 arr 的某一个子集相加得到，那么 max+1 是 arr 的最小不可组成和。
 *
 * 请写函数返回正数数组 arr 的最小不可组成和。
 *
 * 比如：
 * arr = [3, 2, 5]。子集 {2} 相加产生 2 为 min，子集 {3, 2, 5} 相加产生 10 为 max。在区间 [2, 10] 上，4、6
 * 9 不能被任何子集相加得到，其中 4 是 arr 的最小不可组成和。
 * arr = [1, 2, 4]。子集 {1} 相加产生 1 为 min，子集 {1, 2, 4} 相加产生 7 为 max。在区间 [1, 7] 上，任何数
 * 都可以被子集相加得到，所以 8 是 arr 的最小不可组成和。
 *
 * 进阶题目：
 * 如果已知正数数组 arr 中肯定有 1 这个数，是否能更快地得到最小不可组成和？
 *
 * 解答：
 * 首先看原问题，有两种解法。
 * 解法一为暴力递归的方法，即收集每一个子集的累加和，存到一个哈希表里，然后从 min 开始递增检查，看哪一个数不在哈希表中，
 * 第一个不在哈希表中的正数就是结果。具体代码请参见 unformedSum1() 方法。
 * 如果 arr 的长度为 N，那么子集的个数为 O(2^N)，所有暴力递归方法的时间复杂度为 O(2^N)，收集子集和的过程中，递归函
 * 数 process 最多有 N 层，所以额外空间复杂度为 O(N)。
 *
 * 解法二是动态规划的方法。假设 arr 所有数的累加和为 sum，那么 arr 子集的累加和必然都在 [0, sum]，于是生成长度为 sum
 * +1 的 boolean 型数组 dp[]，dp[j] 如果为 true，则表示 j 这个累加和能够被 arr 的子集相加得到，如果为 false，则表
 * 示不能。如果 arr[0..i] 这个范围上的数组成的所有子集可以累加出 k，那么 arr[0..i+1] 这个范围上的数组成的所有子集则必
 * 然可以累加出 k+arr[i+1]。具体代码请参见 unformedSum2() 方法。
 * 更新 dp[] 时，从 arr[0..i] 的子集和状态，更新到 arr[0..i+1] 的子集和状态的过程中，0～sum 的累加和都要看是否能被
 * 加出来，所以每次更新的时间复杂度为 O(sum)。子集和状态从 arr[0] 的范围增长到 arr[0..N-1]，所以更新的次数为 N。所以
 * 解法二的时间复杂度为 O(N*sum)，额外空间就是 dp[] 的长度，即额外空间复杂度为 O(N)。
 *
 * 进阶问题。
 * 如果正数数组 arr 中肯定有 1 这个数，求最小不可组成和的过程可以得到很好的优化，优化后可以做到时间复杂度为 O(N*logN)，
 * 额外空间复杂度为 O(1)。具体过程为：
 * （1）把 arr 排序，排序之后则必有 arr[0] = 1。
 * （2）从左到右计算每个位置 i 的 range（0<= i < N）。range 代表当计算到 arr[i] 时，[1, range] 区间内的所有正数
 * 都可以被 arr[0, i-1] 的某一个子集加出来，初始时，arr[0] = 1，range = 0。
 * （3）如果 arr[i] > range + 1，因为 arr[i] 往后的数都不会出现 range + 1，所以直接返回 range + 1。如果 arr[i]
 * <= range + 1，说明 [1, range + arr[i]] 区间上的所有正数都可以被 arr[0..i] 的某一个子集加出来，所以令 range
 * += arr[i]，继续计算下一个位置。
 * （4）如果所有的位置都没有出现 arr[i] + range + 1 的情况，直接返回 range + 1。
 * 步骤（1）的时间复杂度为 O(N*logN)，步骤（2）～步骤（4）的时间复杂度为 O(N)。所以整个过程的时间复杂度为 O(N*logN)，
 * 额外空间复杂度为 O(1)。
 *
 * @author Jiajing Li
 * @date 2019-07-06 11:07:31
 */
public class Main {

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 5};
        System.out.println(Sum.unformedSum1(arr1));
        System.out.println(Sum.unformedSum2(arr1));
        System.out.println();

        int[] arr2 = {1, 2, 4};
        System.out.println(Sum.unformedSum1(arr2));
        System.out.println(Sum.unformedSum2(arr2));
        System.out.println();

        int[] arr3 = {1, 2, 3, 9};
        System.out.println(Sum.unformedSum3(arr3));
    }

}

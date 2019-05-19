package com.siwuxie095.forme.algorithm.chapter4th.question16th.answer1st;

/**
 * 数组中的最长连续序列
 *
 * 题目：
 * 给定无序数组 arr，返回其中最长的连续序列的长度。
 *
 * 比如：
 * arr = [100, 4, 200, 1, 3, 2]，最长的连续序列为 [1, 2, 3, 4]，所以返回 4。
 *
 * 解答：
 * 本题利用哈希表 HashMap 可以实现时间复杂度为 O(N)、额外空间复杂度为 O(N) 的方法。具体过程如下：
 * 1、生成哈希表 HashMap<Integer, Integer> map，key 代表遍历过的某个数，value 代表 key 这个数
 * 所在的最长连续序列的长度。同时 map 还可以表示 arr 中的一个数之前是否出现过。
 * 2、从左到右遍历 arr，假设遍历到 arr[i]。如果 arr[i] 之前出现过，直接遍历下一个数，只处理之前没出
 * 现过的 arr[i]。首先在 map 中加入记录(arr[i], 1)，代表代表目前 arr[i] 单独作为一个连续序列。然
 * 后看 map 中是否含有 arr[i] - 1，如果有，则说明 arr[i] - 1 所在的连续序列可以和 arr[i] 合并，
 * 合并后记为 A 序列。利用 map 可以得到 A 序列的长度，记为 lenA，最小值记为 leftA，最大值记为 rightA，
 * 只在 map 中更新与 leftA 和 rightA 有关的记录，更新成 (leftA, lenA) 和 (rightA, lenA)。接下
 * 来看 map 中是否含有 arr[i] + 1，如果有，则说明 arr[i] + 1 所在的连续序列可以和 A 合并，合并后
 * 记为 B 序列。利用 map 可以得到 B 序列的长度为 lenB，最小值记为 leftB，最大值记为 rightB，只在
 * map 中更新与 leftB 和 rightB 有关的记录，更新成 (leftB, lenB) 和 (rightB, lenB)。
 * 3、遍历的过程中用全局变量 max 记录每次合并出的序列的长度最大值，最后返回 max。
 *
 * 整个过程中，只是每个连续序列最小值和最大值在 map 中记录有意义，中间数的记录不再更新，因为再也不会使
 * 用到。这是因为我们只处理之前没出现的数，如果一个没出现的数能够把某个连续区间扩大，或把某两个连续区间
 * 连在一起，毫无疑问，只需要在 map 中有关这个连续区间最小值和最大值的记录。
 *
 * @author Jiajing Li
 * @date 2019-04-08 16:19:54
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] {100, 4, 200, 1, 3, 2};
        System.out.println(LongestConsicutiveSequence.longestConsecutiveSequence(arr));
    }

}

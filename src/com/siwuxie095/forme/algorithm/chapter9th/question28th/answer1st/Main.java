package com.siwuxie095.forme.algorithm.chapter9th.question28th.answer1st;

/**
 * 两个有序数组间相加和的 TopK 问题
 *
 * 题目：
 * 给定两个有序数组 arr1 和 arr2，再给定一个整数 k，返回来自 arr1 和 arr2 的两个数相加和最大的
 * 前 k 个，两个数必须分别来自两个数组。
 *
 * 比如：
 * arr1 = [1, 2, 3, 4, 5]，arr2 = [3, 5, 7, 9, 11]，k = 4。
 * 返回数组 [16, 15, 14, 14]。
 *
 * 要求：
 * 时间复杂度达到 O(k*logk)。
 *
 * 哪两个分别来自两个排序数组的数相加最大？自然是 arr1 的最后一个数和 arr2 的最后一个数，
 * 假设 arr1 长度为 N，arr2 长度为 M。
 * 既然 arr2[M-1] + arr1[N-1] 无疑是所有和中最大的，那么先把这个和放到大根堆里。然后从
 * 堆中弹出一个堆顶，此时这个堆顶肯定是 (M-1, N-1) 位置的和，即 arr2[M-1] + arr1[N-1]。
 * 然后把两个位置的和再放进堆里，分别是 (M-2, N-1) 和 (M-1, N-2)，因为除了 (M-1, N-1)
 * 位置的和之外，其他任何位置的和都不会比 (M-2, N-1) 和 (M-1, N-2) 位置的和更大。每放
 * 入一个位置的和，都经过堆的调整（heapInsert 调整）。当再从堆中弹出一个堆顶时，此时的堆
 * 顶必然是堆中最大的和，假设是 (i, j) 位置的和。弹出之后再把堆调整成大根堆，即把堆中最后
 * 一个元素放到堆顶堆位置进行从上到下的 heapify 调整，调整之后再依次把 (i, j-1) 和 (i-1,
 * j) 位置的和放入到堆中。每次弹出的位置和就是从大到小排列的我们想得到的 TopK K。这个过程
 * 总结为：
 * 1、初始时把位置 (M-1, N-1) 放入堆中，因为这个位置代表的相加和就是最大的相加和。
 * 2、此时堆顶为 (M-1, N-1)，把这个位置代表的相加和 (arr2[M-1]+arr1[N-1]) 收集起来，
 * 然后把堆尾放到堆顶的位置，再经历堆的调整过程（heapify），最后把 (M-2, N-1) 和 (M-1,
 * N-2) 放入堆中，并根据代表的相加和来重新调整堆（heapInsert）。
 * 3、每次堆顶都会有一个位置记为 (i, j)，把这个位置代表的相加和 (arr2[i]+arr1[j]) 收
 * 集起来，然后把堆尾放到堆顶的位置，再经历堆的调整（heapify）。最后把这个位置上边的 (i-1,
 * j) 和左边的 (i, j-1) 放入到堆中，并根据代表的相加和调整堆（heapInsert）。
 * 4、直到收集的个数为 k，整个过程结束。
 * 堆的大小为 k，每次堆的调整为 O(logk) 级别，并且一共收集 k 个数，所以时间复杂度为 O
 * (k*logk)。需要特别注意的是，要利用哈希表来防止同一个位置重复进堆的情况。
 *
 * @author Jiajing Li
 * @date 2019-07-25 22:04:54
 */
public class Main {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 5, 7, 9, 11};
        int[] res = Top.topKSum(arr1, arr2, 4);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }

}

package com.siwuxie095.forme.algorithm.chapter8th.question18th.answer1st;

/**
 * 在数组中找到一个局部最小的位置
 *
 * 题目：
 * 定义局部最小的概念。arr 的长度为 1 时，arr[0] 是局部最小。arr 的长度为 N（N > 1）时，如果 arr[0] < arr[1]，
 * 那么 arr[0] 是局部最小的；如果 arr[N-1] < arr[N-2]，那么 arr[N-1] 是局部最小；如果 0<i<N-1，既有 arr[i]
 * < arr[i+1]，那么 arr[i] 是局部最小。
 * 给定无序数组 arr，已知 arr 中任意两个相邻的数都不相等，写一个函数，只需返回 arr 中任意一个局部最小出现的位置即
 * 可。
 *
 * 解答：
 * 本题可以利用二分查找做到时间复杂度为 O(N*logN)、额外空间复杂度为 O(1)，步骤如下：
 * 1、如果 arr 为空或者长度为 0，返回 -1 表示不存在局部最小。
 * 2、如果 arr 长度为 1 或者 arr[0] < arr[1]，说明 arr[0] 是局部最小，返回 0。
 * 3、如果 arr[N-1] < arr[N-2]，说明 arr[N-1] 是局部最小，返回 N-1。
 * 4、如果 arr 长度大于 2 且 arr 的左右两头都不是局部最小，则令 left = 1，right
 * = N-2，然后进入步骤 5 做二分查找。
 * 5、令 mid = (left+right)/2，然后进行如下判断：
 * 1）如果 arr[mid] > arr[mid-1]，可知 arr[left..mid-1]上，肯定存在局部最小，令 right = mid-1，重复步骤 5。
 * 2）如果不满足 1），但 arr[mid] > arr[mid+1]，可知在 arr[mid+1..right] 上肯定存在局部最小，令 left = mid
 * +1，重复步骤 5。
 * 3）如果既不满足 1），也不满足 2），那么 arr[mid] 就是局部最小，直接返回 mid。
 * 6、步骤 5 一直进行二分查找，直到 left == right 时停止，返回 left。
 *
 * 如此可见，二分查找并不是数组有序时才能使用，只要你确定二分两侧的某一侧肯定存在你要找的内容，就可以使用二分查找。
 *
 * @author Jiajing Li
 * @date 2019-06-09 20:50:55
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5};
        System.out.println(Index.getLessIndex(arr));
    }

}

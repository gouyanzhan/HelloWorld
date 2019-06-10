package com.siwuxie095.forme.algorithm.chapter8th.question15th.answer1st;

/**
 * 奇数下标都是奇数或者偶数下标都是偶数
 *
 * 题目：
 * 给定一个长度不小于 2 的数组 arr，实现一个函数调整 arr，要么让所有的偶数下标都是偶数，要么让所有的
 * 奇数下标都是奇数。
 *
 * 要求：
 * 如果 arr 的长度为 N，函数要求时间复杂度为 O(N)，额外空间复杂度为 O(1)。
 *
 * 解答：
 * 实现方法有很多，这里介绍一种易于实现的方法，步骤如下：
 * 1、设置变量 even，表示目前 arr 最左边的偶数下标，初始时 even = 0。
 * 2、设置变量 odd，表示目前 arr 最左边的奇数下标，初始时 odd = 1。
 * 3、不断检查 arr 的最后一个数，即 arr[N-1]。如果 arr[N-1] 是偶数，交换 arr[N-1] 和 arr[even]，
 * 然后令 even = even + 2。如果 arr[N-1] 是奇数，交换 arr[N-1] 和 arr[odd]，然后令 odd = odd
 * + 2。继续重复步骤 3。
 * 4、如果 even 或者 odd 大于或等于 N，过程停止。
 *
 * 即 最后位置的数是偶数，就向偶数下标发送，最后位置的数是奇数，就向奇数下标发送，如果偶数下标或者奇数
 * 下标已经无法再向右移动，说明调整结束。
 *
 * @author Jiajing Li
 * @date 2019-06-03 21:26:27
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 2, 4, 6};
        Modify.modify(arr);
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

}

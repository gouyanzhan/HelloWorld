package com.siwuxie095.forme.algorithm.chapter4th.question15th.answer1st;

/**
 * 跳跃游戏
 *
 * 题目：
 * 给定数组 arr，arr[i] == k 代表可以从位置 i 向右跳 1～k 个距离。比如，arr[2] == 3，代表
 * 从位置 2 可以跳到位置 3、位置 4 或位置 5。如果从位置 0 出发，返回最少跳几次能跳到 arr 最后
 * 的位置上。
 *
 * 比如：
 * arr = [3, 2, 3, 1, 1, 4]。
 * arr[0] == 3，选择跳到位置 2；arr[2] == 3，可以跳到最后的位置。所以返回 2。
 *
 * 要求：如果 arr 长度为 N，要求实现时间复杂度为 O(N)、额外空间复杂度为 O(1) 的方法。
 *
 * 解答：
 * 具体过程如下：
 * 1、整型变量 jump，代表目前跳了多少步。整型变量 curr，代表如果只能跳 jump 步，最远能够达到
 * 的位置。整型变量 next，代表如果再多跳一步，最远能够达到的位置。初始时，jump = 0，curr = 0，
 * next = 0。
 * 2、从左到右遍历 arr，假设遍历到位置 i。
 * （1）如果 curr >= i，说明跳 jump 步可以到达位置 i，此时什么也不做。
 * （2）如果 curr < i，说明只跳 jump 步不能到达位置 i，需要多跳一步才行。此时令 jump++，curr
 * = next。表示多跳了一步，curr 更新成跳 jump+1 步能够到达的位置，即 next。
 * （3）将 next 更新成 max{next, i + arr[i]}，表示下一次多跳一步到达的最远位置。
 * 3、最终返回 jump 即可。
 *
 * @author Jiajing Li
 * @date 2019-04-08 16:02:45
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 3, 1, 1, 4};
        System.out.println(Jump.jump(arr));
    }

}

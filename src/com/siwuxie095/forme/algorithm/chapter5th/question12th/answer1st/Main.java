package com.siwuxie095.forme.algorithm.chapter5th.question12th.answer1st;

/**
 * 数组中两个字符串的最小距离
 *
 * 题目：
 * 给定一个字符串数组 strArr，再给定两个字符串 str1 和 str2，返回在 strArr 中 str1 和 str2 的最小距离，
 * 如果 str1 或 str2 为 null，或不在 strArr 中，返回 -1。
 *
 * 比如：
 * strArr = ["1", "3", "3", "3", "2", "3", "1"]，str1 = "1"，str2 = "2"，返回 2。
 * strArr = ["CD"]，str1 = "CD"，str2 = "AB"，返回 -1。
 *
 * 进阶题目：
 * 如果查询发生的次数有很多，如何把每次查询的时间复杂度降为 O(1)？
 *
 * 解答：
 * 原问题。从左到右遍历 strArr，用遍历 last1 记录最近一次出现的 str1 的位置，用变量 last2 记录最近一次
 * 出现的 str2 的位置。如果遍历到 str1，那么 i-last2 的值就是当前的 str1 和左边离它最近的 str2 之间的
 * 距离。如果遍历到 str2，那么 i-last1 的值就是当前的 str2 和左边离它最近的 str1 之间的距离。用变量 min
 * 记录这些距离的最小值即可。
 *
 * @author Jiajing Li
 * @date 2019-04-22 09:36:15
 */
public class Main {

    public static void main(String[] args) {
        String[] strArr = {"1", "3", "3", "3", "2", "3", "1"};
        System.out.println(Distance.minDistance(strArr, "1", "2"));
    }

}











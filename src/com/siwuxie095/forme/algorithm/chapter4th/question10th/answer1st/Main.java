package com.siwuxie095.forme.algorithm.chapter4th.question10th.answer1st;

/**
 * 字符串的交错组成
 *
 * 题目：
 * 给定三个字符串 str1、str2 和 aim，如果 aim 包含且仅包含来自 str1 和 str2 的所有字符，
 * 而且在 aim 中属于 str1 的字符之间保持原来在 str1 中的顺序，属于 str2 的字符之间保持原
 * 来在 str2 中的顺序，那么称 aim 是 str1 和 str2 的交错组成。实现一个函数，判断 aim 是
 * 否是 str1 和 str2 交错组成。
 *
 * 比如：
 * str1 = "AB"，str2 = "12"，那么 "AB12"、"A1B2"、"A12B"、"1A2B" 和 "1AB2" 等都是
 * str1 和 str2 的交错组成。
 *
 * 解答：
 * 如果 str1 的长度为 M，str2 的长度为 N，经典动态规划的方法可以达到时间复杂度为 O(M * N)，
 * 额外空间复杂度为 O(M * N)。如果结合空间压缩的技巧，可以把额外空间复杂度减至 O(min{M, N})。
 * 先来介绍经典动态规划的方法。首先 aim 如果是 str1 和 str2 的交错组成，aim 的长度一定是 M
 * + N，否则直接返回 false。然后生成大小为 (M+1) * (N+1) 的布尔类型的矩阵 dp，dp[i][j]
 * 的值代表 aim[0..i+j-1] 能否被 str1[0..i-1] 和 str2[0..j-1] 交错组成。计算 dp 矩阵
 * 的时候，是从左到右，再从上到下计算的，dp[M][N] 也就是 dp 矩阵中最右下角的值，表示 aim 整
 * 体能否被 str1 整体和 str2 整体交错组成，也就是最终结果。下面具体说明 dp 矩阵每个位置的值
 * 是如何计算的：
 * 1、dp[0][0] = true。aim 为空串时，当然可以被 str1 为空串和 str2 为空串交错组成。
 * 2、矩阵 dp 第一列即 dp[0..M-1][0]。dp[i][0] 表示 aim[0..i-1] 能否只被 str1[0..i-1]
 * 交错组成。如果 aim[0..i-1] 等于 str1[0..i-1]，则令 dp[i][0] = true，否则令 dp[i][0]
 * = false。
 * 3、矩阵 dp 第一行即 dp[0][0..N-1]。dp[0][j] 表示 aim[0..j-1] 能否只被 str2[0..j-1]
 * 交错组成。如果 aim[0..j-1] 等于 str1[0..j-1]，则令 dp[i][0] = true，否则令 dp[i][0]
 * = false。
 * 4、对其他位置 (i, j)，dp[i][j] 的值由下面的情况决定：
 * （1）dp[i-1][j] 代表 aim[0..i+j-2] 能否被 str1[0..i-2] 和 str2[0..j-1] 交错组成，
 * 如果可以，那么如果再有 str1[i-1] 等于 aim[i+j-1]，说明 str1[i-1] 又可以作为交错组成
 * aim[0..i+j-1] 的最后一个字符。令 dp[i][j] = true。
 * （2）dp[i][j-1] 代表 aim[0..i+j-2] 能否被 str1[0..i-1] 和 str2[0..j-2] 交错组成，
 * 如果可以，那么如果再有 str2[j-1] 等于 aim[i+j-1]，说明 str1[j-1] 又可以作为交错组成
 * aim[0..i+j-1] 的最后一个字符。令 dp[i][j] = true。
 * （3）如果第一种情况和第二种情况都不满足，令 dp[i][j] = false。
 * 具体代码请参看 isCross1() 方法。
 *
 *
 * 经典动态规划方法结合空间压缩的方法。实际进行空间压缩的时候，比较 str1 和 str2 中哪个长度
 * 较小，长度较小的那个作为列对应的字符串，然后生成和较短字符串长度一样的一维数组 dp，滚动更新
 * 即可。
 *
 * @author Jiajing Li
 * @date 2019-04-07 10:50:47
 */
public class Main {

    public static void main(String[] args) {
        String str1 = "AB";
        String str2 = "12";
        String aim  = "AB12";
        System.out.println(Cross.isCross1(str1, str2, aim));
        System.out.println(Cross.isCross2(str1, str2, aim));
    }

}

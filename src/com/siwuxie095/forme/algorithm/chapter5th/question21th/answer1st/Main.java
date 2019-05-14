package com.siwuxie095.forme.algorithm.chapter5th.question21th.answer1st;

/**
 * 回文最少分割数
 *
 * 题目：
 * 给定一个字符串 str，返回把 str 全部切成回文子串的最小分割数。
 *
 * 比如：
 * str = "ABA"。
 * 不需要切割，str 本身就是回文串，所以返回 0。
 * str = "ACDCDCDAD"。
 * 最少需要切 2 次变成 3 个回文子串，比如 "A"、"CDCDC" 和 "DAD"，所以返回 2。
 *
 * 解答：
 * 本题是一个经典的动态规划题目。定义动态规划数组 dp，dp[i] 的含义是子串 str[i..len-1] 至少需要切割几次，
 * 才能把 str[i..len-1] 全部切成回文子串。那么，dp[0] 就是最后的结果。
 * 从右往左依次计算 dp[i] 的值，i 初始为 len-1，具体计算过程如下：
 * 1、假设 j 位置处在 i 与 len-1 位置之间（i<=j<=len-1），如果 str[i..j] 是回文串，那么 dp[i] 的值
 * 可能是 dp[j+1]+1，其含义在 str[i..len-1] 上，既然 str[i..j] 是一个回文串，那么它可以自己作为一个分
 * 割的部分，剩下的部分（即 str[j+1..len-1]）继续做最经济的切割，而 dp[j+1] 值的含义正好是 str[j+1..len-1]
 * 的最少回文分割数。
 * 2、根据步骤 2 的方式，让 j 在 i 到 len-1 位置上枚举，那么所有可能情况中的最小值就是 dp[i] 的值，即
 * dp[i] = Min{ dp[j+1]+1 （i<=j<len，且 str[i..j] 必须是回文串）}。
 * 3、如何方便快速地判断 str[i..j] 是否是回文串呢？具体过程如下：
 * 1）定义一个二维数组 boolean[] p，如果 p[i][j] 值为 true，说明字符串 str[i..j] 是回文串，否则不是。
 * 在计算 dp 数组的过程中，希望能够同步、快速地计算出矩阵 p。
 * 2）p[i][j] 如果为 true，一定是以下三种情况：
 * （1）str[i..j] 由 1 个字符组成。
 * （2）str[i..j] 由 2 个字符组成且 2 个字符相等。
 * （3）str[i+1..j-1] 是回文串，即 p[i+1][j-1] 为 true，且 str[i] == str[j]，即 str[i..j] 上首尾
 * 两个字符相等。
 * 3）在计算 dp 数组的过程中，位置 i 是从右往左依次计算的。而对每一个 i 来说，又依次从 i 位置向右枚举所有的
 * 位置 j（i<=j<len），以此来决策出 dp[i] 的值。所以对 p[i][j] 来说，p[i+1][j-1] 值一定已经计算过。这
 * 就使判断一个子串是否为回文串变得极为方便。
 * 4、最终返回 dp[0] 的值，过程结束。
 *
 * @author Jiajing Li
 * @date 2019-05-14 11:02:27
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Cut.minCut("ABA"));
        System.out.println(Cut.minCut("ACDCDCDAD"));
    }

}

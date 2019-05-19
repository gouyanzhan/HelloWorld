package com.siwuxie095.forme.algorithm.chapter5th.question13th.answer2nd;

/**
 * 添加最少字符使字符串整体都是回文字符串
 *
 * 题目：
 * 给定一个字符串 str，如果可以在 str 的任意位置添加字符，请返回在添加字符最少的情况下，
 * 让 str 整体都是回文字符串的一种结果。
 *
 * 比如：
 * str = "ABA"。str 本身就是回文串，不需要添加字符，所以返回 "ABA"。
 * str = "AB"，可以在 'A' 之前添加 'B'，使 str 整体都是回文串，故可以返回 "BAB"。
 * 也可以在 'B' 之后添加 'A'，使 str 整体都是回文串，故也可以返回 "ABA"。总之，只要
 * 添加的字符数最少，只返回其中一种结果即可。
 *
 * 进阶题目：
 * 给定一个字符串 str，再给定 str 的最长回文子序列字符串 lps，请返回在添加字符最少的情
 * 况下，让 str 整体都是回文字符串的一种结果。进阶问题比原问题多了一个参数，请做到时间复
 * 杂度比原问题的实现低。（lps 即 longest palindrome subsequence）
 *
 * 比如：
 * str = "A1B21C"，lps = "121"，返回 "AC1B2B1CA" 或 "CA1B2B1AC"。总之，只要是
 * 添加的字符数最少，只返回其中一种结果即可。
 *
 * 解答：
 * 进阶问题。如果有最长回文子序列字符串 lps，那么求解的时间复杂度可以加速到 O(N)。如果
 * str 的长度为 N，lps 的长度为 M，则整体回文串的长度应该是 2*N-M。这里提供的解法类似
 * 于 "剥洋葱" 的过程，给出示例来具体说明：
 * str = "A1BC22DE1F"，lps = "1221"。res = ...长度为 2*N-M ...
 * 洋葱的第 0 层由 lps[0] 和 lps[M-1] 组成，即 "1...1"。从 str 最左侧开始找字符
 * '1'，发现 'A' 是 str 第 0 个字符，'1' 是 str 第 1 个字符，所以左侧第 0 层洋葱
 * 圈外的部分为 "A"，记为 leftPart。从 str 最右侧开始找字符 '1'，发现右侧第 0 层洋
 * 葱圈外的部分为 "F"，记为 rightPart。把 leftPart + rightPart 的逆序复制到 res
 * 左侧未设值的部分，把 rightPart + leftPart 逆序复制到 res 的右侧未设值的部分，即
 * result 变为 "AF...FA"。把洋葱的第 0 层复制进 res 的左右两侧未设值的部分，即 result
 * 变为 "AF1...1FA"。至此，洋葱第 0 层被剥掉。洋葱的第 1 层由 lps[1] 和 lps[M-2]
 * 组成，即 "2...2"。从 str 左侧的洋葱第 0 层往右找 "2"，发现左侧第一层洋葱圈外的部分
 * 为 "BC"，记为 leftPart。从 str 右侧的洋葱第 0 层往左找 "2"，发现右侧第 1 层洋葱
 * 圈外的部分记为 "DE"，记为 rightPart。把 leftPart + rightPart 的逆序复制到 res
 * 左侧未设值的部分，把 rightPart + leftPart 逆序复制到 res 的右侧未设值的部分，res
 * 变为 "AF1BCED...DECB1FA"。把洋葱的第一层复制进 res 的左右未设值的部分，即 result
 * 变为 "AF1BCED2...2DECB1FA"。第 1 层被剥掉，洋葱剥完了，返回 "AF1BCED22DECB1FA"。
 * 整个过程就是不断找到洋葱圈的左部分和右部分，把 leftPart + rightPart 的逆序复制到 res
 * 左侧未设值的部分，把 rightPart + leftPart 逆序复制到 res 的右侧未设值的部分，洋葱
 * 剥完则过程结束。
 *
 * @author Jiajing Li
 * @date 2019-04-22 21:53:46
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Palindrome.getPalindrome("A1BC22DE1F", "1221"));
    }

}

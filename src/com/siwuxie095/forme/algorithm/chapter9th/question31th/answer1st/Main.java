package com.siwuxie095.forme.algorithm.chapter9th.question31th.answer1st;

/**
 * KMP 算法
 *
 * 题目：
 * 给定两个字符串 str 和 match，长度分别为 N 和 M。实现一个算法，如果字符串 str 中含有子串 match，则
 * 返回 match 在 str 中的开始位置，不含有则返回 -1。
 *
 * 比如：
 * str = "acbc"，match = "bc"，返回 2。
 * str = "acbc"，match = "bcc"，返回 -1。
 *
 * 要求：
 * 如果 match 的长度大于 str 的长度（M > N），str 必然不会含有 match，可直接返回 -1。但如果 N >= M，
 * 要求算法复杂度为 O(N)。
 *
 * 解答：
 * 本文是想重点介绍一下 KMP 算法，该算法是由 Donald Knuth、Vaughan Pratt 和 James H.Morris 于 1997
 * 年联合发明的。在介绍 KMP 算法之前，先来看看普通解法怎么做。
 * 最普通的解法是从左到右遍历 str 的每一个字符，然后看如果以当前字符作为第一个字符出发是否匹配出 match。比
 * 如 str = "aaaaaaaaaaaaaaaaab"，match = "aaaab"。从 str[0] 出发，开始匹配，匹配到 str[4] = 'a'
 * 时发现和 match[4] = 'b' 不一样，所以匹配失败，说明从 str[0] 出发是不行的。从 str[1] 出发，开始匹配，
 * 匹配到 str[5] = 'a' 时发现和 match[4] = 'b' 不一样，所以匹配失败，说明从 str[1] 出发是不行的。从
 * str[2..12] 出发都会一直失败。从 str[13] 出发开始匹配，匹配到 str[17] = 'b' 时发现 match[4] = 'b'
 * 一样，match 已经全部匹配完，说明匹配成功，返回 13。普通解法的时间复杂度较高，从每个字符出发时，匹配的代
 * 价都可能是 O(M)，那么一共有 N 个字符，所以整体的时间复杂度为 O(N*M)。普通解法的时间复杂度这么高，是因
 * 为每次遍历到一个字符时，检查工作相当于从无开始，之前的遍历检查不能优化当前的遍历检查。
 * 下面介绍 KMP 算法是如何快速解决字符串匹配问题的。
 * 1、首先生成 match 字符串的 nextArr 数组，这个数组的长度与 match 字符串的长度一样，nextArr[i] 的含
 * 义是在 match[i] 之前的字符串 match[0..i-1] 中，必须以 match[i-1] 结尾的后缀子串（不能包含 match[0]）
 * 与必须以 match[0] 开头的前缀子串（不能包含 match[i-1]）最大的匹配长度是多少。这个长度就是 nextArr[i]
 * 的值。比如，match = "aaaab" 字符串，nextArr[4] 的值该是多少呢？match[4] = 'b'，所以它之前的字符串
 * 为 "aaaa"，根据定义这个字符串的后缀子串和前缀子串最大匹配为 "aaa"。也就是当后缀子串等于 match[1..3]
 * = 'aaa'，前缀子串等于 match[0..2] = 'aaa' 时，这时前缀和后缀不仅相等，而且是所有前缀和后缀的可能性
 * 中最大的匹配。所以 nextArr[4] 的值等于 3。再如 match = "abc1abc1" 字符串，nextArr[7] 的值该是多
 * 少呢？match = '1'，所以它之前的字符串为 "abc1abc1"，根据定义这个字符串的后缀子串和前缀子串最大匹配为
 * "abc"。也就是当后缀子串等于 match[4..6] = "abc"，前缀子串等于 match[0..2] = "abc" 时，这时前缀和
 * 后缀不仅相等，而且是所有前缀和后缀的可能性中最大的匹配。所以 nextArr[7] 的值等于 3。关于如何快速得到
 * nextArr 数组的问题，我们把 KMP 算法的大概过程介绍完毕之后再详细说明，接下来先看如果有了 match 的 nextArr
 * 数组，如何加速进行 str 和 match 的匹配过程。
 * 2、假设从 str[i] 字符出发时，匹配到 j 位置的字符发现与 match 中的字符不一致。也就是说，str[i] 与
 * match[0] 一样，并且从这个位置开始一直可以匹配，即 str[i..j-1] 与 match[0..j-i-1] 一样，直到发现
 * str[j] != match[j-i]，匹配停止。
 *
 * str 中匹配的位置是不退回的，match 则一直向右滑动，如果在 str 中的某个位置完全匹配出 match，整个过程
 * 停止。否则 match 滑到 str 的最右侧过程也停止，所以滑动的长度最大为 N，所以时间复杂度为 O(N)。匹配的
 * 全部过程请参看 getIndexOf() 方法。
 *
 * @author Jiajing Li
 * @date 2019-07-27 16:44:29
 */
public class Main {

    public static void main(String[] args) {
        String str = "acbc";
        String match = "bc";
        System.out.println(Index.getIndexOf(str, match));
        match = "bcc";
        System.out.println(Index.getIndexOf(str, match));
    }

}

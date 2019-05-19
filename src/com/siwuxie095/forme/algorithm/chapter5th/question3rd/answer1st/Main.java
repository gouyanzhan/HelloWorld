package com.siwuxie095.forme.algorithm.chapter5th.question3rd.answer1st;

/**
 * 去掉字符串中连续出现 k 个 0 的子串
 *
 * 题目：
 * 给定一个字符串 str 和一个整数 k，如果 str 中正好有连续的 k 个 '0' 字符出现时，把 k 个
 * 连续的 '0' 字符去除，返回处理后的字符串。
 *
 * 比如：
 * str = "A00B"，k = 2，返回 "AB"。
 * str = "A0000B000"，k = 3，返回 "A0000B"。
 *
 * 解答：
 * 解决本题能做到时间复杂度为 O(N)、额外空间复杂度为 O(1) 的方法有很多。这里仅提供
 * 一种以做参考。解法的关键是如何在从左到右遍历 str 时，将正好有连续的 k 个 '0' 的
 * 字符串都找到，然后把字符 '0' 去掉。具体过程如下：
 * 1、生成两个变量。整型变量 count，表示目前连续个 '0' 的数量；整型变量 start，表
 * 示连续个 '0' 出现的开始位置。初始时，count = 0，start = -1。
 * 2、从左到右遍历 str，假设遍历到 i 位置的字符为 cha，根据具体的 cha 有不同的处理。
 * 3、如果 cha 是字符 '0'，令 start = (start == -1) ? i : start，表示如果 start
 * 等于 -1，说明之前没处在发现连续的 '0' 的阶段，那么令 start = i，表示连续的 '0'
 * 从 i 开始，如果 start 不等于 -1，说明之前就已经处在发现连续的 '0' 的阶段，所以
 * start 不变，令 count++。
 * 4、如果 cha 不是字符 '0'，是去掉连续 '0' 的时刻。首先看此时 count 是否等于 k，
 * 如果等于，说明之前发现的连续 k 个 '0' 可以从 start 位置开始去掉，如果不等于，说
 * 明之前发现的连续的 '0' 数量不是 k 个，则不能去掉。最后令 count = 0，start = -1。
 * 5、既然把去掉连续的 '0' 的时机放在了 cha 不是字符 '0' 的时候，那么如果 str 是以
 * 字符 '0' 结尾的，可能会出现最后一组正好有连续的 k 个 '0' 字符出现而没有去掉的情况。
 * 所以遍历完成后，再检查一下 count 是否等于 k，如果等于，就去掉最后一组连续的 k 个 '0'。
 *
 * @author Jiajing Li
 * @date 2019-04-09 22:22:03
 */
public class Main {

    public static void main(String[] args) {
        String str = "A00B";
        int k = 2;
        System.out.println(Remove.removeKZeros(str, k));
        str = "A0000B000";
        k = 3;
        System.out.println(Remove.removeKZeros(str, k));
    }

}

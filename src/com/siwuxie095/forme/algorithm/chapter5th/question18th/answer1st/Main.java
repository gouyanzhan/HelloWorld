package com.siwuxie095.forme.algorithm.chapter5th.question18th.answer1st;

/**
 * 找到字符串的最长无重复字符子串
 *
 * 题目：
 * 给定一个字符串 str，返回 str 的最长无重复字符子串的长度。
 *
 * 比如：
 * str = "abcd"，返回 4。
 * str = "aabcb"，最长无重复子串为 "abc"，返回 3。
 *
 * 要求：
 * 如果 str 的长度为 N，请实现时间复杂度为 O(N) 的方法。
 *
 * 解答：
 * 如果 str 长度为 N，字符编码范围是 M，本题可以做到时间复杂度为 O(N)，额外空间复杂度为 O(M)。下面介绍
 * 这种方法的具体实现。
 * 1、在遍历 str 之前，先申请一个变量。哈希表 map，key 表示某个字符，value 为这个字符最近一次出现的位置。
 * 整型变量 pre，如果当前遍历到字符 str[i]，pre 表示在必须以 str[i-1] 字符结尾的情况下，最长无重复字符
 * 子串开始位置的前一个位置，初始时 pre = -1。整型变量 len，记录以每一个字符结尾的情况下，最长无重复字符子
 * 串长度的最大值，初始时，len = 0。从左到右依次遍历 str，假设现在遍历到 str[i]，加下来求在必须以 str[i]
 * 结尾的情况下， 最长无重复字符子串的长度。
 * 2、map(str[i]) 的值表示之前的遍历中最近一次出现 str[i] 字符的位置，假设在 a 位置，想要求以 str[i]
 * 结尾的最长无重复子串，a 位置必然不能包含进来，因为 str[a] 等于 str[i]。
 * 3、根据 pre 的定义，pre+1 表示在必须以 str[i-1] 字符结尾的情况下，最长无重复字符字符子串的开始位置，
 * 也就是说，以 str[i-1] 结尾的最长无重复子串是向左扩到 pre 位置停止的。
 * 4、如果 pre 位置在 a 位置的左边，因为 str[a] 不能包含进来，而 str[a+1..i-1] 上都是不重复的，所以
 * 以 str[i] 结尾的最长无重复子串就是 str[a+1..i]。如果 pre 位置在 a 位置的右边，以 str[i-1] 结尾
 * 的最长无重复子串是向左扩到 pre 位置停止的。所以以 str[i] 结尾的最长无重复子串向左扩到 pre 位置也必然
 * 会停止，而且 str[pre+1..i-1] 这一段上肯定不含有 str[i]，所以以 str[i] 结尾的最长无重复字符子串就是
 * str[pre+1..i]。
 * 5、计算完长度之后，pre 位置和 a 位置哪一个在右边，就作为新的 pre 值。然后去计算下一个位置的字符，整个
 * 过程中求得所有长度的最大值用 len 记录下来返回即可。
 *
 * @author Jiajing Li
 * @date 2019-04-29 13:42:59
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Unique.maxUnique("abcd"));
        System.out.println(Unique.maxUnique("aabcb"));
    }

}

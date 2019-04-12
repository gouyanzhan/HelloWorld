package com.siwuxie095.forme.algorithm.chapter5th.question6th.answer1st;

/**
 * 替换字符串中连续出现的指定字符串
 *
 * 题目：
 * 给定三个字符串 str、from 和 to，把 str 中所有 from 的子串全部替换成 to 字符串，对
 * 连续出现的 from 的部分要求只替换成一个 to 字符串，返回最终的结果字符串。
 *
 * 比如：
 * str = "123abc"，from = "abc"，to = "4567"，返回 "1234567"。
 * str = "123"，from = "abc"，to = "456"，返回 "123"。
 * str = "123abcabc"，from = "abc"，to = "X"，返回 "123X"。
 *
 * 解答：
 * 解决本题的方法有很多，这里仅提供一种以作参考。如果把 str 看作字符类型的数组，首先把 str
 * 中 from 部分所有位置的字符编码设为 0（即 空字符），比如 str = "12abcabca4"，from =
 * "abc"，处理后 str 为 ['1', '2', '0', '0', '0', '0', '0', '0', 'a', '4']。具体
 * 过程如下：
 * 1、生成整型变量 match，表示目前匹配到 from 字符串的什么位置，初始时，match = 0。
 * 2、从左到右遍历 str 中的每个字符，假设当前遍历到 str[i]。
 * 3、如果 str[i] == from[match]。如果 match 是 from 最后一个字符的位置，说明在 str
 * 中发现了 from  字符串，则从 i 位置向左的 M 个位置，都把字符编码设为 0，M 为 from 的
 * 长度，设置完成后令 match = 0。如果 match 不是 from 最后一个字符的位置，令 match++。
 * 继续遍历 str 的下一个字符。
 * 4、如果 str[i] != from[match]，说明匹配失败，令 match = 0，即 回到 from 开头重新
 * 匹配。继续遍历 str 的下一个字符。
 *
 * 通过上面的过程，接下来替换就比较容易。比如：
 * ['1', '2', '0', '0', '0', '0', '0', '0', 'a', '4']
 * 将不为 0 的区域拼在一起，连续为 0 的部分用 to 来替换，即 "12" + to + "a4" 即可。
 *
 * @author Jiajing Li
 * @date 2019-04-12 09:13:51
 */
public class Main {

    public static void main(String[] args) {
        String str = "123abc";
        String from = "abc";
        String to = "4567";
        System.out.println(Replace.replace(str, from, to));
        str = "123";
        from = "abc";
        to = "456";
        System.out.println(Replace.replace(str, from, to));
        str = "123abcabc";
        from = "abc";
        to = "X";
        System.out.println(Replace.replace(str, from, to));
    }

}

package com.siwuxie095.forme.algorithm.chapter5th.question1st.answer1st;

/**
 * 判断两个字符串是否互为变形词
 *
 * 题目：
 * 给定两个字符串 str1 和 str2，如果 str1 和 str2 中出现的字符种类一样且每种字符
 * 出现的次数也一样，那么 str1 与 str2 互为变形词。请实现函数判断两个字符串是否互为
 * 变形词。
 *
 * 比如：
 * str1 = "123"，str2 = "231"，返回 true。
 * str1 = "123"，str2 = "2331"，返回 false。
 *
 * 解答：
 * 如果字符串 str1 和 str2 长度不同，直接返回 false。如果长度相同，假设出现字符的
 * 编码值在 0～255 之前，那么先申请一个长度为 256 的整型数组 map，map[a] = b 代
 * 表字符编码为 a 的字符出现了 b 次，初始时 map[0..255] 的值都是 0。然后遍历字符
 * 串 str1，统计每种字符出现的数量，比如遍历到字符 'a'，其编码值为 97，则令 map[97]
 * ++。这样 map 就成令 str1 中每种字符的词频统计表。然后遍历字符串 str2，每遍历到
 * 一个字符都在 map 中把词频减下来。比如遍历到字符 'a'，其编码值为 97，则令 map[97]
 * --，如果减小之后的值小于 0，直接返回 false。如果遍历完 str2，map 中的值也没有出
 * 现负值，则返回 true。
 *
 * @author Jiajing Li
 * @date 2019-04-08 18:57:42
 */
public class Main {

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "231";
        System.out.println(Deformation.isDeformation(str1, str2));
    }

}

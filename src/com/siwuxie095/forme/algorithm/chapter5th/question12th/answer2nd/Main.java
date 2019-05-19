package com.siwuxie095.forme.algorithm.chapter5th.question12th.answer2nd;

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
 * 进阶问题。其实是通过数组 strArr 先生成某种记录，在查询时通过记录进行查询，这里提供了一种记录的结构以供参考，
 * 如果 strArr 的长度为 N，那么生成记录的时间复杂度为 O(N^2)，记录的空间复杂度为 O(N^2)，在生成记录之后，单
 * 次查询操作的时间复杂度可降为 O(1)。这里实现的记录其实是一个哈希表 HashMap<String, HashMap<String, Integer>>，
 * 这是一个 key 为 String 类型，value 为哈希表类型的哈希表。为了描述清楚，把这个哈希表叫作 外哈希表，把 value
 * 代表的哈希表叫作 内哈希表。外哈希表的 key 代表 strArr 中的某种字符串，key 所对应的内哈希表表示其他字符串到
 *  key 字符串的最小距离。比如当 strArr = ["1", "3", "3", "3", "2", "3", "1"] 时，生成的记录如下：
 *
 *  key         value
 *  "1"         ("2", 2) -> "1" 到 "2" 的最小距离为 2。("3", 1) -> "1" 到 "3" 的最小距离为 1。
 *  "2"         ("1", 2) -> "2" 到 "1" 的最小距离为 2。("3", 1) -> "2" 到 "3" 的最小距离为 1。
 *  "3"         ("1", 1) -> "3" 到 "1" 的最小距离为 1。("2", 1) -> "3" 到 "2" 的最小距离为 1。
 *
 * 如果生成了这种结构的记录，那么查询 str1 和 str2 的最小距离时只用两次哈希查询操作就可以完成。
 *
 * @author Jiajing Li
 * @date 2019-04-22 09:49:06
 */
public class Main {

    public static void main(String[] args) {
        String[] strArr = {"1", "3", "3", "3", "2", "3", "1"};
        Record record = new Record(strArr);
        System.out.println(record.minDistance("1", "2"));
        System.out.println(record.minDistance("2", "3"));
        System.out.println(record.minDistance("1", "3"));
    }

}

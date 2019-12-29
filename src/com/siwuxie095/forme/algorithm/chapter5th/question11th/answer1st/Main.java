package com.siwuxie095.forme.algorithm.chapter5th.question11th.answer1st;

/**
 * 翻转字符串
 *
 * 题目：
 * 给定一个字符类型的数组 charArr，请在单词间做逆序调整。只要单词顺序租到逆序即可，对空格的位置没有特别要求。
 *
 * 比如：
 * 如果把 charArr 看作字符串 "dog loves pig"，调整成 "pig loves dog"。
 * 如果把 charArr 看作字符串 "I'm a studentInfo."，调整成 "studentInfo. a I'm"。
 *
 * 补充题目：
 * 给定一个字符类型的数组 charArr 和一个整数 size，请把大小为 size 的左半区整体移到右半区，右半区整体移到
 * 左边。
 *
 * 比如：
 * 如果把 charArr 看作字符串为 "ABCDE"，size = 3，调整成 "DEABC"。
 *
 * 要求：
 * 如果 charArr 长度为 N，两道题的时间复杂度为 O(N)，额外空间复杂度为 O(1)。
 *
 * 解答：
 * 原问题。首先把 charArr 整体逆序。在逆序之后，遍历 charArr 找到每一个单词，然后把每个单词里的字符逆序即可。
 * 比如 "dog loves pig"，先整体变成 "gip sevol god"，然后每个单词进行逆序处理就变成了 "pig loves dog"。
 * 逆序之后找每一个单词的逻辑，做到不出错即可。具体代码请参看 rotateWord() 方法。
 *
 * 补充问题。方法一。先把 charArr[0..size-1] 部分逆序，再把 charArr[size..N-1] 部分逆序，最后把 charArr
 * 整体逆序即可。比如，charArr = "ABCDE"，size = 3。先把 charArr[0..2] 部分逆序，charArr 变成 "CBADE",
 * 再把 charArr[3..4] 部分逆序，charArr 变成 "CBAED"，最后把 charArr 整体逆序，charArr 变为 "DEABC"。
 * 具体代码请参看 rotate1() 方法。
 *
 * 补充问题。方法二。用举例的方式来说明这个过程，charArr = "1234567ABCD"，size = 7。
 * 1、左部分为 "1234567"，右部分为 "ABCD"，右部分长度为 4，比左部分小，所以把左部分前 4 个字符与右部分交换，
 * charArr[0..10] 变成 "ABCD5671234"。右部分小，所以右部分ABCD换过去再也不需要移动，剩下的部分为 charArr
 * [4..10] = "5671234"。左部分大，所以换过来的 "1234" 视为下一步的右部分，下一步的左部分为 "567"。
 * 2、左部分为 "567"，右部分为 "1234"，左部分的长度为 3，比右部分小，所以把右部分的后三个字符与左部分交换，charArr
 * [4..10] 变成 "2341567"。左部分小，所以左部分 "567" 换过去再也不需要移动，剩下的部分为 charArr = "2341"。
 * 右部分大，所以换过来的 "234" 视为下一步的左部分，下一步的右部分为 "1"。
 * 3、左部分为 "234"，右部分为 "1"。右部分的长度为 1，比左部分小，所以把左部分前 1 个字符与右部分交换，charArr
 * 变为 "1342"。右部分小，所以右部分 "1" 换过去再也不需要移动，剩下的部分为 charArr[5..7] = "342"。左部分大，
 * 所以换过来的 "2" 视为下一步的右部分，下一步的左部分为 "34"。
 * 4、左部分为 "34"，右部分为 "2"。右部分的长度为 1，比左部分小，所以把左部分前 1 个字符与右部分交换，charArr
 * 变为 "243"。右部分小，所以右部分 "2" 换过去再也不需要移动，剩下的部分为 charArr[6..7] = "43"，左部分大，所
 * 以换过来的 "3" 视为下一步的右部分，下一步的左部分为 "4"。
 * 5、左部分为 "4"，右部分为 "3"。一旦发现左部分和右部分的长度一样，那么左右部分完全交换即可。charArr[6..7] 变为
 * "34"。整个过程结束，charArr 已经变成 "ABCD1234567"。
 *
 * 如果每一次左右部分的划分进行 M 次交换，那么都有 M 个字符再也不需要移动，而字符数一共为 N，所以交换行为最多发生 N
 * 次。另外，如果某一次划分出的左右部分长度一样，那么交换完成后将不会再有新的划分，所以在很多时候交换行为会少于 N 次。
 * 比如，charArr = "1234ABCD"，size = 4，最开始左部分为 "1234"，右部分为 "ABCD"，左右两个部分完全交换后为
 * "ABCD1234"，同时不会有后续的划分，所以这种情况下一共只有 4 次交换行为。具体代码请参看 rotate2() 方法。
 *
 * @author Jiajing Li
 * @date 2019-04-18 21:24:20
 */
public class Main {

    public static void main(String[] args) {
        Rotate.rotateWord("dog loves pig".toCharArray());
        Rotate.rotateWord("I'm a studentInfo.".toCharArray());
        System.out.println();
        Rotate.rotate1("1234567ABCD".toCharArray(), 7);
        Rotate.rotate2("1234567ABCD".toCharArray(), 7);
    }

}

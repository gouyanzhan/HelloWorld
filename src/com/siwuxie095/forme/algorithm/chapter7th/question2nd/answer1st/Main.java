package com.siwuxie095.forme.algorithm.chapter7th.question2nd.answer1st;

/**
 * 不用任何比较判断找出两个数中较大的数
 *
 * 题目：
 * 给定两个 32 位整数 a 和 b，返回 a 和 b 中较大的。
 *
 * 要求：不用任何比较判断。
 *
 * 解答：
 * 第一种方法。得到 a-b 的值的符号，就可以知道是返回 a 还是返回 b。具体代码请参看 getMax1() 方法。
 * 其中 sign 函数的功能是返回整数 n 的符号，正数和 0 返回 1。负数则返回 0。flip 函数的功能是如果
 * n 为 1，返回 0，如果 n 为 0，返回 1。所以，如果 a-b 的结果为 0 或正数，那么 scA 为 1，scB 为
 * 0；如果 a-b 的值为负数，那么 scA 为 0，scB 为 1。scA 和 scB 必有一个为 1，另一个必为 0。所以
 * 返回 a * scA + b * scB，就是根据 a-b 的值的状况，选择要么返回 a，要么返回 b。
 * 但方法一是有局限性的，那就是如果 a-b 的值出现溢出，返回结果就不正确。
 *
 * 第二种方法。这种方法可以彻底解决溢出的问题。具体代码请参看 getMax2() 方法。
 * 如果 a 的符号与 b 的符号不同（diffSab = 1, sameSab = 0），则有：
 * （1）如果 a 为 0 或正，那么 b 为负（sa = 1，sb = 0），应该返回 a；
 * （2）如果 a 为负，那么 b 为 0 或正（sa = 0，sb = 1），应该返回 b；
 * 如果 a 的符号与 b 的符号相同（diffSab = 0，sameSab = 1），这种情况下，a-b 的值绝对不会溢出：
 * （1）如果 a-b 为 0 或正（sc = 1），返回 a；
 * （2）如果 a-b 为负（sc = 0），返回 b；
 * 综上所述，应该返回 a * (diffSab*sa + sameSab*sc) + b * flip(diffSab*sa + sameSab*sc)。
 *
 * @author Jiajing Li
 * @date 2019-05-18 13:36:34
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Max.getMax1(1, 2));
        System.out.println(Max.getMax2(1, 2));
    }

}

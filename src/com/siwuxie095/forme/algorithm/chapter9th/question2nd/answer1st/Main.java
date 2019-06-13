package com.siwuxie095.forme.algorithm.chapter9th.question2nd.answer1st;

/**
 * 一行代码求两个数的最大公约数
 *
 * 题目：
 * 给定两个不等于 0 的整数 M 和 N，求 M 和 N 的最大公约数。
 *
 * 解答：
 * 一个很简单的求两个数最大公约数的算法是欧几里得在其《几何原本》中提出的欧几里得算法，
 * 又称为辗转相除法。
 * 具体做法为：如果 q 和 r 分别是 m 除以 n 的商和余数，即 m = nq + r，那么 m 和 n
 * 的最大公约数等于 n 和 r 的最大公约数。详细证明略。
 *
 * @author Jiajing Li
 * @date 2019-06-13 22:26:30
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(GCD.gcd(10, 5));
    }

}

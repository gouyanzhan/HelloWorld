package com.siwuxie095.forme.algorithm.chapter9th.question12th.answer1st;

/**
 * 调整 [0, x) 区间上的数出现的概率
 *
 * 题目：
 * 假设函数 Math.random() 等概率随机返回一个在 [0, 1) 范围上的数，那么我们知道，在 [0, 1)
 * 区间上的数出现的概率为 x（0 < x <= 1）。给定一个大于 0 的整数 k，并且可以使用 Math.random()
 * 函数，请实现一个函数依然返回在 [0, 1) 范围上的数，但是在 [0, x) 区间上的数出现的概率为 x^k
 * （0 <= x <= 1）。
 *
 * 解答：
 * 实现在区间 [0, x) 上的数返回的概率是 x^2，只用调用 2 次 Math.random()，返回最大的那个数
 * 即可。具体代码请参看 randXPower2() 方法。
 *
 * 解释起来也很简单，如果 randXPower2 要想返回在 [0, x) 区间上的数，两次调用 Math.random()
 * 的返回值都必须落在 [0, x) 区间上，否则会返回大于 x 的数，所以概率为 x^2。
 * 同理，想让区间 [0, x) 上的数返回的概率是 x^2，只用调用 k 次 Math.random()，返回最大的那
 * 个数即可。具体代码请参看 randXPowerK() 方法。
 *
 * @author Jiajing Li
 * @date 2019-06-30 21:34:04
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Rand.randXPower2());
        System.out.println(Rand.randXPower2());
        System.out.println();
        System.out.println(Rand.randXPowerK(2));
        System.out.println(Rand.randXPowerK(4));
        System.out.println(Rand.randXPowerK(6));
        System.out.println(Rand.randXPowerK(8));
    }

}

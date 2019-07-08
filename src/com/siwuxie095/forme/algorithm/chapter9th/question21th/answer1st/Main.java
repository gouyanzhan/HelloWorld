package com.siwuxie095.forme.algorithm.chapter9th.question21th.answer1st;

/**
 * 数字的英文表达和中文表达
 *
 * 题目：
 * 给定一个 32 位整数 num，写两个函数分别返回 num 的英文与中文表达字符串。
 *
 * 比如：
 * num = 319
 * 英文表达字符串为：Three Hundred Nineteen
 * 中文表达字符串为：三百一十九
 *
 * num = 1014
 * 英文表达字符串为：One Thousand, Fourteen
 * 中文表达字符串为：一千零十四
 *
 * num = -2147483648
 * 英文表达字符串为：Negative, Two Billion, One Hundred Forty Seven Million,
 * Four Hundred Eighty Three Thousand, Six Hundred Forty Eight
 * 中文表达字符串为：负二十一亿四千七百八十万三千六百四十八
 *
 * num = 0
 * 英文表达字符串为：Zero
 * 中文表达字符串为：零
 *
 * 解答：
 * 本题的重点是考察面试者分析业务场景并实际解决问题的能力。本题的实现方式当然是多种多样的，
 * 这里提供的方法仅是作者的实现，希望读者也能写出自己的实现。
 *
 * 英文表达的实现。英文表达是以三个数为单位成一组的，所以先要解决数组 1～999 的表达问题。
 * 首先看数字 1～19 的表达问题，具体代码请参看 num1To19En() 方法。
 * 然后利用 num1To99() 方法来解决数字 1～99 的表达问题。具体代码请参看 num1To99En()
 * 方法。
 * 有了以上两个函数，再解决数字 1～999。具体代码请参看 num1To999En() 方法。
 *
 * 最后可以解决最终的问题，需要注意如下几个特殊情况：
 * （1）num 为 0 的情况要单独处理。
 * （2）num 为负的处理，对于负数，一律以处理其绝对值的方式来得到表达字符串，然后加上 "Negative "
 * 的前缀，所以 num 为 Integer.MIN_VALUE 时，也是特殊情况。
 * （3）把 32 位整数分解成十亿组、百万组、千组、1～999 组。对每个组的表达利用 num1To999En()
 * 方法，再把组与组之间各自的表达字符串连接起来即可。
 * 最后是英文表达的主方法，具体代码请参见 getNumEnExp() 方法。
 *
 * 中文表达的实现。与英文表达的处理过程类似，都是有小范围的数向大范围的数扩张的过程，这个
 * 过程有非常不同的处理细节。
 * 首先解决数字 1～9 的中文表达问题，具体代码请参看 num1To9Zh() 方法。
 * 利用 num1To9Zh() 方法，来看数字 1～99 如何表达。其中有一个很值得注意的细节，16 的
 * 表达是十六，116 的表达是一百一十六，1016 的表达可以是一千零十六，也可以是一千零一十
 * 六。这个细节说明，对 10～19 来说，如果其前一位（也就是百位）有数字，则表达该是一十～
 * 一十九。如果百位上没数字，则表达应该一律规定为十～十九。具体代码请参看 num1To99Zh()
 * 方法。boolean 型参数 hasBai 表示是否前一位（百位）有数字。
 * 利用 num1To9Zh() 与 num1To99Zh() 方法后，接下来解决数字 1～999 的表达，具体代码
 * 请参看 num1To999Zh() 方法。
 * 然后是数字 1～9999 的表达问题，具体代码请参看 num1To9999Zh() 方法。
 * 接下来是数字 1～9999_9999 的表达问题，具体代码请参看 num1To99999999Zh() 方法。
 * 最后是中文表达的主方法，具体代码请参看 getNumZhExp() 方法。
 *
 * 该类型的代码面试题目实际上是相当棘手的。通常是由小的、简单的场景出发，把复杂的事情拆解
 * 成简单的场景，最终得到想要的结果。
 *
 * @author Jiajing Li
 * @date 2019-07-08 20:38:29
 */
public class Main {

    public static void main(String[] args) {
        int num1 = 319;
        System.out.println(Num.getNumEnExp(num1));
        System.out.println(Num.getNumZhExp(num1));
        System.out.println();
        int num2 = 1014;
        System.out.println(Num.getNumEnExp(num2));
        System.out.println(Num.getNumZhExp(num2));
        System.out.println();
        int num3 =  -2147483648;
        System.out.println(Num.getNumEnExp(num3));
        System.out.println(Num.getNumZhExp(num3));
        System.out.println();
        int num4 =  0;
        System.out.println(Num.getNumEnExp(num4));
        System.out.println(Num.getNumZhExp(num4));
    }

}

package com.siwuxie095.forme.algorithm.chapter9th.question18th.answer1st;

/**
 * 判断一个数是否是回文数
 *
 * 题目：
 * 定义回文数的概念如下：
 * （1）如果一个非负数左右完全对称，则该数是回文数，例如：121，22 等。
 * （2）如果一个负数的绝对值左右完全对称，也是回文数，例如：-121，-22 等。
 * 给定一个 32 位整数 num，判断 num 是否是回文数。
 *
 * 解答：
 * 本题的实现方法当然有很多种，这里介绍一种仅用一个整型变量就可以实现的方法，步骤如下：
 * （1）假设判断的数字为非负数 n，先生成变量 help，开始时 help = 1。
 * （2）用 help 不停地乘以 10，直到变得与 num 的位数一样。例如：num 等于 123321 时，help 就是 100000。
 * num 如果是 131，help 就是 100，总之，让 help 与 num 的位数一样。
 * （3）那么 num/help 的结果就是最高级的数字，num%10 就是最低位的数字，比较这两个数字，不相同则直接返回 false。
 * 相同则令 num = (num%help)/10，即 num 变成除去最高位和最低位两个数字之后的值。令 help/=100，即 让 help 变
 * 得继续和新的 num 位数一样。
 * （4）如果 num == 0，表示所有的数字都已经对应判断完，返回 true，否则重复判断 3。
 *
 * 上述方法就是让 num 每次剥掉最左和最右两个数，然后逐渐完成所有对应的判断。需要注意的是，如上方法只适用于非负数的
 * 判断，如果 n 为负数，则先把 n 变成其绝对值，然后用上面的方法进行判断。同时还需注意，32 位整数中的最小值为 -21
 * 47483648，它是转不成相应的绝对值的，可这个数很明显不是回文数。所以，如果 n 为 -2147483648，直接返回 false。
 * 具体代码请参看 isPalindrome() 方法。
 *
 * @author Jiajing Li
 * @date 2019-07-07 21:05:08
 */
public class Main {

    public static void main(String[] args) {
        int num1 = 121;
        System.out.println(Judge.isPalindrome(num1));
        int num2 = -121;
        System.out.println(Judge.isPalindrome(num2));
        int num3 = -2147483648;
        System.out.println(Judge.isPalindrome(num3));
    }

}

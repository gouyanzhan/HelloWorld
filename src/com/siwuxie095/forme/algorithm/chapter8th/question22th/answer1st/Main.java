package com.siwuxie095.forme.algorithm.chapter8th.question22th.answer1st;

/**
 * 不包含本位置值的累乘数组
 *
 * 题目：
 * 给定一个整型数组 arr，返回不包含本位置值的累乘数组。
 * 比如，arr = [2, 3, 1, 4]，返回 [12, 8, 24, 6]，即除自己外，其他位置上的累乘。
 *
 * 要求：
 * 1、时间复杂度为 O(N)。
 * 2、除需要返回的结果数组外，额外空间复杂度为 O(1)。
 *
 * 进阶题目：
 * 对时间和空间复杂度的要求不变，而且不可以使用除法。
 *
 * 解答：
 * 先介绍可以使用除法的实现，结果数组记为 res，所有数的乘积记为 all。如果数组中不含
 * 0，则设置 res[i] = all/arr[i]（0<=i<=n）即可。如果数组中有 1 个 0，对唯一的
 * arr[i] == 0 的位置令 res[i] = all，其他位置上的值都是 0 即可。如果数组中 0 的
 * 数量大于 1，那么 res 所有位置上的值都是 0。具体代码请参看 product1() 方法。
 *
 * 不能使用除法的情况下，可以用以下方法实现进阶问题：
 * 1、生成两个长度和 arr 一样的新数组 lr[] 和 rl[]。lr[] 表示从左到右的累乘（lr[i]
 * =arr[0..i]）的累乘。rl 表示从右到左的累乘（即 rl[i]=arr[i..N-1]）的累乘。
 * 2、一个位置上除去自己值的累乘，就是自己左边的累乘再乘以自己右边的累乘，即 res[i]=
 * lr[i-1]*rl[i+1]。
 * 3、最左位置和最右位置的累乘比较特殊，即 res[0] = rl[1]，res[N-1]=lr[N-2]。
 * 以上思路虽然可以得到结果 res，但是除 res 之外，又使用了两个额外数组，怎么省掉这两个
 * 额外数组呢？可以通过 res 数组复用的方式。也就是说，先把 res 数组作为辅助计算的数组，
 * 然后把 res 调整成结果数组返回。具体代码请参看 product2() 方法。
 *
 * @author Jiajing Li
 * @date 2019-06-11 10:30:15
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4};
        int[] res = Product.product1(arr);
        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
        res = Product.product2(arr);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }

}

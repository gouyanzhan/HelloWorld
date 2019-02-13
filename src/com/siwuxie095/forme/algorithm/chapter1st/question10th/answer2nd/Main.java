package com.siwuxie095.forme.algorithm.chapter1st.question10th.answer2nd;

/**
 * 最大值减去最小值小于等于 num 的子数组数量
 *
 * 普通解法
 *
 * @author Jiajing Li
 * @date 2019-02-13 21:39:47
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int num = 5;
        int count = Number.getNum(arr, num);
        System.out.println("满足条件的子数组数量 = " + count);
    }

}
